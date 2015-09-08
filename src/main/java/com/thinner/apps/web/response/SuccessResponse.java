package com.thinner.apps.web.response;

/**
 * Created by caoqitong on 8/15/15.
 */
public class SuccessResponse extends AbstractResponse {
  public SuccessResponse() {
    super(IResponse.STATUS_SUCCESS, IResponse.SUC_CODE);
  }

  public SuccessResponse(Object data) {
    this();
    this.setData(data);
  }
}