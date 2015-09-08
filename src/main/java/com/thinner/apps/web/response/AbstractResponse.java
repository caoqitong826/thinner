package com.thinner.apps.web.response;

/**
 * Created by caoqitong on 8/15/15.
 */
public abstract class AbstractResponse implements IResponse{
  private String status;
  private String code;
  private Object data="";

  public AbstractResponse(String status,String code){
    this.status = status;
    this.code = code;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
