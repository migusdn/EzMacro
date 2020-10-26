package com.migusdn.EzMacro.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migusdn.EzMacro.Enum.Command;
import com.migusdn.EzMacro.Enum.TargetType;
import com.migusdn.EzMacro.Macro.Task;
import com.migusdn.EzMacro.Macro.TaskElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonUtility {
    private static ObjectMapper mapper = new ObjectMapper();

    public static Task ToTask(String JsonString) throws JsonProcessingException {
        Task TaskObj = mapper.readValue(JsonString, Task.class);
        return TaskObj;
    }
    public static Task ImportFile(String FilePath) throws IOException {
        Task TaskObj = new Task();
        ArrayList<TaskElement> TElement = new ArrayList<TaskElement>();
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(FilePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject JObj = (JSONObject) obj;
            JSONArray jArr = (JSONArray)JObj.get("urls");
            String url = jArr.get(0).toString();
            JSONArray tests = (JSONArray) JObj.get("tests");
            JObj = (JSONObject) tests.get(0);
            JSONArray commands = (JSONArray) JObj.get("commands");
            Iterator it1 = commands.iterator();
            while(it1.hasNext()){
                JSONObject tmp = (JSONObject) it1.next();
                System.out.println(tmp.get("command"));
                String[] target = tmp.get("target").toString().split("=");

                try {
                    TElement.add(
                            new TaskElement(
                                    Command.valueOf((String) tmp.get("command")),
                                    TargetType.valueOf(target[0]),
                                    target[1]
                            )
                    );
                } catch(Exception e){
                    System.out.println("Error!!\n"+tmp.get("command"));
                }
                //System.out.println(TElement.toString());
            }
            TaskObj.setTaskList(TElement);
            TaskObj.setTarget_url(url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return TaskObj;
    }
}
