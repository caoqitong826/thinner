package com.thinner.apps.utils;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
/**
 * Created by caoqitong on 8/15/15.
 */
public class StringUtil {
  public static String md5(String str) {
    return Hashing.md5().hashString(str, Charsets.UTF_8).toString();
  }

  public static boolean isEmpty(String str) {
    return Strings.isNullOrEmpty(str);
  }
  public static String formatLog(String desc, Object... params) {
    StringBuilder sb = new StringBuilder();
    sb.append(desc);
    sb.append(" - [");
    int i = 0;
    for (Object obj : params) {
      if (i++ > 0) sb.append(",");
      sb.append(obj);
    }
    sb.append("]");
    return sb.toString();
  }
  public static String formatUserId(int id){
    return String.format("U%010d",id);
  }
  public static void main(String[] args){
    System.out.println(formatUserId(111));
  }
}
