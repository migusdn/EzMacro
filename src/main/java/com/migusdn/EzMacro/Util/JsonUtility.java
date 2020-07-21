package com.migusdn.EzMacro.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migusdn.EzMacro.Macro.Task;

public class JsonUtility {
    private static ObjectMapper mapper = new ObjectMapper();

    public static Task ToTask(String JsonString) throws JsonProcessingException {
        Task TaskObj = mapper.readValue(JsonString, Task.class);
        return TaskObj;
    }
}
