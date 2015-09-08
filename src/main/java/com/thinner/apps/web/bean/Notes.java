package com.thinner.apps.web.bean;

import com.thinner.apps.db.entities.NotesEntity;

/**
 * Created by caoqitong on 8/15/15.
 */
public class Notes {
  private int id;
  private int cId;
  private String content;
  private String comment;

  public static Notes fromNotesEntity(NotesEntity notesEntity){
    Notes notes= new Notes();
    notes.setId(notesEntity.getId());
    notes.setContent((notesEntity.getContent()));
    notes.setcId(notesEntity.getcId());
    notes.setComment(notesEntity.getComment());
    return notes;
  }

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
