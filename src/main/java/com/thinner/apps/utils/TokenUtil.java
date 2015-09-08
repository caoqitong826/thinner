package com.thinner.apps.utils;

import com.thinner.apps.web.bean.User;


/**
 * Created by caoqitong on 8/16/15.
 */
public class TokenUtil {
  public static String key = "A1B2C3D4E5F60708";

  public static String token(User user) throws Exception {
    return DESUtil.encrypt(user.getId()+"@"+user.getPassWord(),key);
    //return Base64Util.getBase64(user.getId() + "@" + user.getPassWord());
  }

  public static int getUserIdByToken(String token) throws Exception {
    return Integer.parseInt(DESUtil.decrypt(token,key).split("@")[0]);
//    return Integer.parseInt(Base64Util.getFromBase64(token).split("@")[0]);
  }
}