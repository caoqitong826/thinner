package com.thinner.apps.web.controller;

import com.thinner.apps.service.CollectionsService;
import com.thinner.apps.service.UserService;
import com.thinner.apps.utils.JacksonUtil;
import com.thinner.apps.utils.StringUtil;
import com.thinner.apps.web.Request.ThinnerRequest;
import com.thinner.apps.web.bean.Collections;
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

import java.util.List;
import java.util.Map;

/**
 * Created by caoqitong on 8/15/15.
 */
@RestController
@RequestMapping(value = "/api/collections/")
public class CollectionsController {
  @Autowired
  CollectionsService collectionsService;
  @Autowired
  UserService userService;
  Logger logger = LoggerFactory.getLogger(CollectionsController.class);

  @RequestMapping(value = "search", method = RequestMethod.POST)
  public IResponse findByUserId(@RequestBody ThinnerRequest thinnerRequest) {
    String token = thinnerRequest.getToken();
    try {
      User user = userService.getUserByToken(token);
      if (user == null) {
        logger.error(StringUtil.formatLog("user is not exist", token, user));
        return new FailResponse(IResponse.USER_NOT_EXIST);
      }
      List<Collections> collectionses = collectionsService.findByUserId(user.getId());
      return new SuccessResponse(collectionses);
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("Base64 decoder error"));
      return new FailResponse(IResponse.BASE64_EXCEPTION);
    }
  }
  @RequestMapping(value = "add", method = RequestMethod.POST)
  public IResponse addCollections(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> paramMap = (Map)thinnerRequest.getData();
    String token = thinnerRequest.getToken();
    try {
      User user = userService.getUserByToken(token);
      if (user == null) {
        logger.error(StringUtil.formatLog("user is not exist", token, user));
        return new FailResponse(IResponse.USER_NOT_EXIST);
      }
      String collectionContent = JacksonUtil.objToJson(paramMap);
      Collections collections = JacksonUtil.jsonToObj(collectionContent, Collections.class);
      collections.setUserId(user.getId());
      if(collectionsService.save(collections)==null){
        logger.error(StringUtil.formatLog("save error",collectionContent));
        return new FailResponse(IResponse.SAVE_ERROR);
      }
      return new SuccessResponse();
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("jackson mapping error",paramMap));
      return new FailResponse(IResponse.JACKSON_MAPPING_ERROR);
    }
  }
  @RequestMapping(value = "delete",method = RequestMethod.POST)
  public IResponse delete(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> thinnerMap = (Map)thinnerRequest.getData();
    int id = Integer.parseInt(thinnerMap.get("id"));
    collectionsService.deleteCollections(id);
    return new SuccessResponse();
  }
}

















