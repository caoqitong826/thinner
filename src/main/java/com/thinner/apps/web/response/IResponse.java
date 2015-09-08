package com.thinner.apps.web.response;

/**
 * Created by caoqitong on 8/15/15.
 */
public interface IResponse {

  String STATUS_SUCCESS = "success";
  String STATUS_FAIL = "fail";

  //默认的成功代码，目前无实际意义
  String SUC_CODE = "0";

  //errorCode
  /**
   * public error code 10000-19999
   * user error code 20000-29999
   * collections error code 30000-39999
   * notes error code 40000-49999
   */
  String PARAMS_NULL = "10001";
  String DB_EXCEPTION = "10002";
  String THINNER_NULL = "10003";
  String REQUEST_BODY_NULL = "10004";
  String BASE64_EXCEPTION="10005";
  String JACKSON_MAPPING_ERROR = "10006";
  String SAVE_ERROR="10007";
  String KEY_NULL ="10008";

  String NAME_PASSWORD_NULL = "20001";
  String USER_NOT_EXIST = "20002";
  String TOKEN_NULL = "20003";
  String INVALID_TOKEN ="20004";
  String UPDATE_ERROR = "20005";



}
