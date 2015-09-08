package com.thinner.apps.db.entities;

import javax.persistence.*;

/**
 * Created by caoqitong on 8/15/15.
 */
@Entity
@Table(name = "notes")
public class NotesEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;
  @Column
  private int cId;
  @Column(columnDefinition = "LONGTEXT")
  private String content;
  @Column(columnDefinition = "TEXT")
  private String comment;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getcId() {
    return cId;
  }

  public void setcId(int cId) {
    this.cId = cId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
