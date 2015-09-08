package com.thinner.apps.db.entities;

import javax.persistence.*;

/**
 * Created by caoqitong on 8/15/15.
 */
@Entity
@Table(name = "collections")
public class CollectionsEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;
  @Column
  private int userId;
  @Column
  private String url;
  @Column(columnDefinition = "LONGTEXT")
  private String content;
  @Column
  private int status;

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
