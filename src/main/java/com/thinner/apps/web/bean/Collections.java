package com.thinner.apps.web.bean;

import com.thinner.apps.db.entities.CollectionsEntity;

/**
 * Created by caoqitong on 8/15/15.
 */
public class Collections {
  private int id;
  private int userId;
  private String url;
  private String content;
  private int status;

  public static Collections fromCollectionsEntity(CollectionsEntity collectionsEntity){
    Collections collections = new Collections();
    collections.setId(collectionsEntity.getId());
    collections.setContent(collectionsEntity.getContent());
    collections.setStatus(collectionsEntity.getStatus());
    collections.setUrl(collectionsEntity.getUrl());
    collections.setUserId(collectionsEntity.getUserId());
    return collections;
  }

  public static CollectionsEntity fromCollections(Collections collections){
    CollectionsEntity collectionsEntity = new CollectionsEntity();
    collectionsEntity.setUrl(collections.getUrl());
    collectionsEntity.setContent(collections.getContent());
    collectionsEntity.setUserId(collections.getUserId());
    collectionsEntity.setStatus(collections.getStatus());
    return collectionsEntity;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
