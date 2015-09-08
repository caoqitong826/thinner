package com.thinner.apps.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by caoqitong on 8/16/15.
 */
public class JacksonUtil {
  private static ObjectMapper mapper = new ObjectMapper();
  public static ObjectMapper getInstance() {
    DateFormat myDateFromate =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    mapper.setDateFormat(myDateFromate);
    return mapper;
  }

  public static String objToJson(Object object) throws JsonProcessingException {
    String json = getInstance().writeValueAsString(object);
    return json;
  }

  public static <T> T jsonToObj(String json, Class clazz) throws IOException {
    mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    T t = (T) getInstance().readValue(json, clazz);
    return t;
  }
}
