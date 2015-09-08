package com.thinner.apps.service;

import com.thinner.apps.db.dao.UserDao;
import com.thinner.apps.db.entities.UserEntity;
import com.thinner.apps.utils.TokenUtil;
import com.thinner.apps.web.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caoqitong on 8/15/15.
 */
@Service
public class UserService{
  @Autowired
  UserDao userDao;
  public User login(String userName,String phone,String email){
    UserEntity userEntity=userDao.findByUserNameOrPhoneOrEmail(userName,phone,email);
    return User.fromUserEntity(userEntity);
  }

  public User getUserByToken(String token)throws Exception{
    int userId = TokenUtil.getUserIdByToken(token);
    UserEntity userEntity = userDao.findById(userId);
    return User.fromUserEntity(userEntity);
  }

  public void updatePassWord(int id,String password){
    userDao.updatePassWord(password,id);
  }

  public void updateNickName(int id,String nickName){
    userDao.updateNickName(nickName, id);
  }

  public User register(User user){
    UserEntity userEntity = userDao.save(User.fromUser(user));
    return User.fromUserEntity(userEntity);
  }
}
