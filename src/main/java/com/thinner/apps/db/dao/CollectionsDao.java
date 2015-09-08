package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.CollectionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caoqitong on 8/15/15.
 */
@Transactional
@Component("collectionsDao")
public class CollectionsDao {
  @Autowired
  CollectionsRepository repository;
  public List<CollectionsEntity> findByUserId(int userId){
    return repository.findByUserId(userId);
  }

  public CollectionsEntity save(CollectionsEntity collectionsEntity){
    return repository.save(collectionsEntity);
  }

  public void delete(int id){
    repository.delete(id);
  }
}
