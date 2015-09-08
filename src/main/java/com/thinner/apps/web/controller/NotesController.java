package com.thinner.apps.web.controller;

import com.thinner.apps.service.NotesService;
import com.thinner.apps.utils.StringUtil;
import com.thinner.apps.web.Request.ThinnerRequest;
import com.thinner.apps.web.bean.Notes;
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
@RequestMapping(value = "api/notes/")
public class NotesController {
  @Autowired
  NotesService notesService;
  Logger logger = LoggerFactory.getLogger(NotesController.class);

  @RequestMapping(value = "search",method = RequestMethod.POST)
  public IResponse getNotesByCId(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> paramMap = (Map)thinnerRequest.getData();
    int cid = Integer.parseInt(paramMap.get("cid"));
    List<Notes> notes = notesService.findByCId(cid);
    return new SuccessResponse(notes);
  }
  @RequestMapping(value = "edit",method = RequestMethod.POST)
  public IResponse editComment(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> paramsMap = (Map)thinnerRequest.getData();
    if(!paramsMap.containsKey("id")&&!paramsMap.containsKey("comment")){
      logger.error(StringUtil.formatLog("key is not exist.",paramsMap));
      return new FailResponse(IResponse.KEY_NULL);
    }
    int id = Integer.parseInt(paramsMap.get("id"));
    String comment = paramsMap.get("comment");
    notesService.updateComment(id,comment);
    return  new SuccessResponse();
  }
  @RequestMapping(value = "add",method = RequestMethod.POST)
  public IResponse addNote(@RequestBody ThinnerRequest thinnerRequest){
    Map<String,String> paramsMap = (Map)thinnerRequest.getData();
    if(!paramsMap.containsKey("content")&&!paramsMap.containsKey("comment")&&!paramsMap.containsKey("cid")){
      logger.error(StringUtil.formatLog("key is not exist.",paramsMap));
      return new FailResponse(IResponse.KEY_NULL);
    }
    String content = paramsMap.get("content");
    String comment = paramsMap.get("comment");
    int cid = Integer.parseInt(paramsMap.get("cid"));
    notesService.addNotes(content,comment,cid);
    return new SuccessResponse();
  }
}
