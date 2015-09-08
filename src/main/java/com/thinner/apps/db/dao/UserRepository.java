package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caoqitong on 8/15/15.
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
  UserEntity findById(int id);

  UserEntity findByUserNameOrPhoneOrEmail(String userName, String phone, String email);

  @Modifying
  @Query("update UserEntity u set u.passWord=:password where u.id =:id")
  void updatePassWord(@Param("password")String password,@Param("id") int id);

  @Modifying
  @Query("update UserEntity u set u.nickName=:nickName where u.id =:id")
  void updateNickName(@Param("nickName")String nickName,@Param("id") int id);
}
