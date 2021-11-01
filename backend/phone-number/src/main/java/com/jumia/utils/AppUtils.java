package com.jumia.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class AppUtils {

  public static <T> Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    JavaTimeModule module = new JavaTimeModule();
    mapper.registerModule(module);
    return mapper.readValue(json, objectClass);
  }
}
