package com.nakkunakku.linkme.util;

import com.google.gson.Gson;

public class Json {
    private static Gson gson = new Gson();
    
    private static Gson getInstance() {
        return gson;
    }

    public static String toJson(Object object) throws LinkMeException {
        try {
            return getInstance().toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LinkMeException(e.getMessage());
        }
    }

    public static <T> T fromJson(String json, Class<T> c) throws LinkMeException {
        try {
            return getInstance().fromJson(json, c);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LinkMeException(e.getMessage());
        }
    }
}
