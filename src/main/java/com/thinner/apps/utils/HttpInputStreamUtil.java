package com.thinner.apps.utils;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by caoqitong on 8/16/15.
 */
public class HttpInputStreamUtil {
  public static String getBodyString(ServletRequest request) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (InputStream inputStream = request.getInputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")))) {
      String line = "";
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    }
    return sb.toString();
  }
}
