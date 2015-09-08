package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.NotesEntity;
import com.thinner.apps.web.bean.Notes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caoqitong on 8/15/15.
 */
@Transactional
@Repository
public interface NotesRepository extends CrudRepository<NotesEntity, Integer> {
  NotesEntity findById(int id);

  List<NotesEntity> findByCId(int cid);

  NotesEntity save(NotesEntity notesEntity);

  @Modifying
  @Query("update NotesEntity n set n.comment=:comment where n.id =:id")
  void updateCommentById(@Param("comment")String comment, @Param("id")int id);

  @Modifying
  @Query("delete from NotesEntity n where n.cId =:cid")
  void deleteByCId(@Param("cid") int cid);
}
