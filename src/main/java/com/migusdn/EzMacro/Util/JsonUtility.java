package com.migusdn.EzMacro.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.migusdn.EzMacro.Macro.Task;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtility {
    private static ObjectMapper mapper = new ObjectMapper();

    public static Task ToTask(String JsonString) throws JsonProcessingException {
        Task TaskObj = mapper.readValue(JsonString, Task.class);
        return TaskObj;
    }
    public static Task ImportFile(String FilePath) throws IOException {
//        Task TaskObj = mapper.readValue(new File(FilePath), Task.class);
        Task TaskObj = new Task();
        String test = mapper.readValue(new File(FilePath), String.class);
        System.out.println(test);
        return TaskObj;
    }
}
