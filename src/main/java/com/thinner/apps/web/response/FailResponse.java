package com.thinner.apps.web.response;

/**
 * Created by caoqitong on 8/15/15.
 */
public class FailResponse extends AbstractResponse  {
  public FailResponse(String code) {
    super(IResponse.STATUS_FAIL, code);
  }
}
