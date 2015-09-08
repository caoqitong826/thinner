package com.thinner.apps.service;

import com.thinner.apps.db.dao.NotesDao;
import com.thinner.apps.db.entities.NotesEntity;
import com.thinner.apps.web.bean.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqitong on 8/15/15.
 */
@Service
public class NotesService {
  @Autowired
  NotesDao notesDao;
  public List<Notes> findByCId(int cid){
    List<NotesEntity> notesEntities = notesDao.findByCId(cid);
    List<Notes> notes = new ArrayList<>();
    for(NotesEntity notesEntity : notesEntities){
      notes.add(Notes.fromNotesEntity(notesEntity));
    }
    return notes;
  }

  public void addNotes(String content,String comment,int cid){
    NotesEntity notesEntity = new NotesEntity();
    notesEntity.setContent(content);
    notesEntity.setComment(comment);
    notesEntity.setcId(cid);
    notesDao.save(notesEntity);
  }

  public void deleteByCId(int cid){
    notesDao.deleteByCId(cid);
  }
  public void updateComment(int id,String comment){
    notesDao.updateCommentById(id,comment);
  }
}
