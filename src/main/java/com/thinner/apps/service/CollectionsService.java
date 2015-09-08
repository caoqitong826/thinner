package com.thinner.apps.service;

import com.thinner.apps.db.dao.CollectionsDao;
import com.thinner.apps.db.entities.CollectionsEntity;
import com.thinner.apps.utils.StringUtil;
import com.thinner.apps.web.bean.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqitong on 8/15/15.
 */
@Service
public class CollectionsService {
  @Autowired
  CollectionsDao collectionsDao;
  @Autowired
  NotesService notesService;
  Logger logger = LoggerFactory.getLogger(CollectionsService.class);
  public List<Collections> findByUserId(int userId){
    List<CollectionsEntity> collectionsEntitys = collectionsDao.findByUserId(userId);
    List<Collections> collectionses = new ArrayList<>();
    for(CollectionsEntity collectionsEntity : collectionsEntitys){
      collectionses.add(Collections.fromCollectionsEntity(collectionsEntity));
    }
    return collectionses;
  }

  public Collections save(Collections collections){
    CollectionsEntity collectionsEntity = Collections.fromCollections(collections);
    return Collections.fromCollectionsEntity(collectionsDao.save(collectionsEntity));
  }

  public void deleteCollections(int id){
    try {
      notesService.deleteByCId(id);
      collectionsDao.delete(id);
    } catch (Exception e) {
      logger.error(StringUtil.formatLog("delete error"));
    }
  }
}
