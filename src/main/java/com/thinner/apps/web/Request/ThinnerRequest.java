package com.thinner.apps.web.Request;

/**
 * Created by caoqitong on 8/15/15.
 */
public class ThinnerRequest {
  private String token;
  private Object data;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
