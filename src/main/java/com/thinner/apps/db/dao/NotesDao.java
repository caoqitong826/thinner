package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.NotesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caoqitong on 8/16/15.
 */
@Transactional
@Component("notesDao")
public class NotesDao {
  @Autowired
  NotesRepository repository;

  public List<NotesEntity> findByCId(int cid) {
    return repository.findByCId(cid);
  }

  public NotesEntity save(NotesEntity notesEntity) {
    return repository.save(notesEntity);
  }

  public void deleteByCId(int cid) {
    repository.deleteByCId(cid);
  }

  public void updateCommentById(int id, String comment) {
    repository.updateCommentById(comment, id);
  }
}
