package com.thinner.apps.web.controller;

import com.thinner.apps.service.UserService;
import com.thinner.apps.utils.StringUtil;
import com.thinner.apps.utils.TokenUtil;
import com.thinner.apps.web.Request.ThinnerRequest;
import com.thinner.apps.web.bean.User;
import com.thinner.apps.web.response.FailResponse;
import com.thinner.apps.web.response.IResponse;
import com.thinner.apps.web.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoqitong on 8/15/15.
 */
@RestController
@RequestMapping(value = "/api/user/")
public class UserController {
  @Autowired
  UserService userService;
  Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public IResponse login(@RequestBody Map<String, String> params) {
    if (params == null) {
      return new FailResponse(IResponse.PARAMS_NULL);
    }
    String userName = params.get("username");
    String password = params.get("password");
    if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
      logger.error(StringUtil.formatLog("name or password is empty", userName, password));
      return new FailResponse(IResponse.NAME_PASSWORD_NULL);
    }
    User user;
    try {
      user = userService.login(userName, userName, userName);
      if (user == null) {
        logger.error(StringUtil.formatLog("user is not exist", userName));
        return new FailResponse(IResponse.USER_NOT_EXIST);
      }
      String token = TokenUtil.token(user);
      Map<String,String> map = new HashMap<>();
      map.put("token",token);
      return new SuccessResponse(map);
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("findByUserNameOrPhoneOrEmail error", userName));
      return new FailResponse(IResponse.DB_EXCEPTION);
    }
  }

  @RequestMapping(value = "register",method = RequestMethod.POST)
  public IResponse register(@RequestBody Map<String,String> params){
    if (params == null) {
      return new FailResponse("");
    }
    String nickname = params.get("nickname");
    String password = params.get("password");
    String email = params.get("email");
    if (StringUtil.isEmpty(nickname) || StringUtil.isEmpty(password)||StringUtil.isEmpty(email)) {
      logger.error(StringUtil.formatLog("email name or password is empty", nickname, password));
      return new FailResponse(IResponse.KEY_NULL);
    }
    User user = new User();
    user.setEmail(email);
    user.setPassWord(password);
    user.setNickName(nickname);
    user.setUserName(email);
    userService.register(user);
    return new SuccessResponse();
  }

  @RequestMapping(value = "password",method = RequestMethod.POST)
  public IResponse updatePassword(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> paramsMap = (Map)thinnerRequest.getData();
    if(!paramsMap.containsKey("password")){
      logger.error(StringUtil.formatLog("key is not exist.",paramsMap));
      return new FailResponse(IResponse.KEY_NULL);
    }
    try {
      String password = paramsMap.get("passWord");
      String token  = thinnerRequest.getToken();
      if(token ==null){
        logger.error(StringUtil.formatLog("token is null",token));
        return new FailResponse(IResponse.KEY_NULL);
      }
      User user = userService.getUserByToken(token);
      if(user ==null){
        logger.error(StringUtil.formatLog("user is not exist",token));
        return new FailResponse(IResponse.USER_NOT_EXIST);
      }
      userService.updatePassWord(user.getId(),password);
      return new SuccessResponse();
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("update user password error.",thinnerRequest));
      return new FailResponse(IResponse.UPDATE_ERROR);
    }
  }


  @RequestMapping(value = "nickname",method = RequestMethod.POST)
  public IResponse updateNickName(@RequestBody ThinnerRequest thinnerRequest) {
    Map<String, String> paramsMap = (Map) thinnerRequest.getData();
    if (!paramsMap.containsKey("nickname")) {
      logger.error(StringUtil.formatLog("key is not exist.", paramsMap));
      return new FailResponse(IResponse.KEY_NULL);
    }
    try {
      String nickname = paramsMap.get("nickname");
      String token  = thinnerRequest.getToken();
      User user = userService.getUserByToken(token);
      if(user ==null){
        logger.error(StringUtil.formatLog("user is not exist",token));
        return new FailResponse(IResponse.USER_NOT_EXIST);
      }
      userService.updateNickName(user.getId(),nickname);
      return new SuccessResponse();
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("update user nickName error.",thinnerRequest));
      return new FailResponse(IResponse.UPDATE_ERROR);
    }
  }
}
