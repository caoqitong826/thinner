package com.thinner.apps.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Created by caoqitong on 8/16/15.
 */
public class Base64Util {
  // encode
  public static String getBase64(String str) throws UnsupportedEncodingException {
    byte[] bytes = null;
    String s = null;
    bytes = str.getBytes("utf-8");
    if (bytes != null) {
      s = new BASE64Encoder().encode(bytes);
    }
    return s;
  }

  // decoder
  public static String getFromBase64(String s) throws Exception {
    byte[] b = null;
    String result = null;
    if (s != null) {
      BASE64Decoder decoder = new BASE64Decoder();
      b = decoder.decodeBuffer(s);
      result = new String(b, "utf-8");

    }
    return result;
  }
}
