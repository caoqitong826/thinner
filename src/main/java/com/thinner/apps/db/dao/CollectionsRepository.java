package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.CollectionsEntity;
import com.thinner.apps.web.bean.Collections;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caoqitong on 8/15/15.
 */
@Transactional
@Repository
public interface CollectionsRepository extends CrudRepository<CollectionsEntity, Integer> {
  List<CollectionsEntity> findByUserId(int userId);
  CollectionsEntity save(CollectionsEntity collectionsEntity);

}
