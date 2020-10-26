import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileImportTest {
    @Test
    public void fileImportTest(){
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("/Users/hyunwoopark/Downloads/tttt.side")) {
            Object obj = jsonParser.parse(reader);
            System.out.println(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getUrlsTest(){
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("/Users/hyunwoopark/Downloads/tttt.side")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray jArr = (JSONArray)((JSONObject) obj).get("urls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getTaskElement(){
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("/Users/hyunwoopark/Downloads/tttt.side")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jobj = (JSONObject) obj;
            JSONArray tests = (JSONArray) jobj.get("tests");
            jobj = (JSONObject) tests.get(0);
            JSONArray commands = (JSONArray) jobj.get("commands");
            Iterator it1 = commands.iterator();
            while(it1.hasNext()){
                System.out.println(it1.next().toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
