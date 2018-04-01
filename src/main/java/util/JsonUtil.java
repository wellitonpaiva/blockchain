package util;

import com.google.gson.GsonBuilder;

public class JsonUtil {

    static GsonBuilder builder = new GsonBuilder();

    public static String printObject(Object o) {
        return builder.setPrettyPrinting().create().toJson(o);
    }

}
