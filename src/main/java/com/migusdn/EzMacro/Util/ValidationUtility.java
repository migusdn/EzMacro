package com.migusdn.EzMacro.Util;

import java.util.regex.Pattern;

public class ValidationUtility {
    private static final String urlRegex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";

    public static boolean urlCheck(String url){
        return Pattern.matches(urlRegex, url);
    }

}
