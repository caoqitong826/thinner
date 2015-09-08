package com.thinner.apps.db.dao;

import com.thinner.apps.db.entities.UserEntity;
import com.thinner.apps.web.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by caoqitong on 8/15/15.
 */
@Transactional
@Component("userDao")
public class UserDao {
  @Autowired
  private UserRepository repository;
  public UserEntity findByUserNameOrPhoneOrEmail(String userName,String phone,String email){
    return repository.findByUserNameOrPhoneOrEmail(userName, phone, email);
  }

  public UserEntity findById(int id){
    return repository.findById(id);
  }

  public void updatePassWord(String password,int id){
    repository.updatePassWord(password,id);
  }

  public void updateNickName(String nickName,int id){
    repository.updateNickName(nickName, id);
  }

  public UserEntity save(UserEntity userEntity){
    return repository.save(userEntity);
  }
}
