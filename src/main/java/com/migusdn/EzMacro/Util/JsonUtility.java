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
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUtility {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Task ToTask(String JsonString) throws JsonProcessingException {
        return mapper.readValue(JsonString, Task.class);
    }
//    private static TaskElement taskElementInit(Command command, TargetType targetType, String target){
//        return new TaskElement(
//                command,
//                targetType,
//                target
//        );
//    }

    public static Task ImportFile(String FilePath){
        Task TaskObj = new Task();
        ArrayList<TaskElement> taskElements = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(FilePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject JObj = (JSONObject) obj;
            JSONArray jArr = (JSONArray)JObj.get("urls");
            String url = jArr.get(0).toString();
            JSONArray tests = (JSONArray) JObj.get("tests");
            JObj = (JSONObject) tests.get(0);
            JSONArray commands = (JSONArray) JObj.get("commands");
            for (Object o : commands) {
                JSONObject tmp = (JSONObject) o;
                Command command = Command.valueOf(tmp.get("command").toString());
                System.out.println(tmp.get("command"));
                String[] target = tmp.get("target").toString().split("=");
                if (command == Command.open || command == Command.runScript) {
                    taskElements.add(
                            new TaskElement(command,
                                    null,
                                    target[0]
                            )
                    );
                } else {
                    try {
                        taskElements.add(
                                new TaskElement(
                                        command,
                                        TargetType.valueOf(target[0]),
                                        target[1]
                                )
                        );
                    } catch (NullPointerException e) {
                        taskElements.add(
                                new TaskElement(
                                        command,
                                        TargetType.valueOf(target[0]),
                                        null
                                )
                        );
                    } catch (Exception e) {
                        System.out.println("Error!!\n" + tmp.get("command"));
                    }
                }
                //System.out.println(TElement.toString());
            }
            TaskObj.setTaskList(taskElements);
            TaskObj.setTarget_url(url);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return TaskObj;
    }
}
