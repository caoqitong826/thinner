package com.thinner.apps.mail;

import javax.mail.*;

/**
 * Created by caoqitong on 8/22/15.
 */

public class MyAuthenticator extends Authenticator {
  String userName = null;
  String password = null;

  public MyAuthenticator() {
  }

  public MyAuthenticator(String username, String password) {
    this.userName = username;
    this.password = password;
  }

  protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(userName, password);
  }
}

