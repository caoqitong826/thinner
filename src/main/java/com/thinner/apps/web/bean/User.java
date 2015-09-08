package com.thinner.apps.web.bean;

import com.thinner.apps.db.entities.UserEntity;

import java.util.Date;

/**
 * Created by caoqitong on 8/15/15.
 */
public class User {
  private int id;
  private String userName;
  private String nickName = "";
  private String Phone;
  private String email;
  private String passWord;
  private Date lastLogin;

  public static User fromUserEntity(UserEntity userEntity) {
    User user = new User();
    user.setId(userEntity.getId());
    user.setUserName(userEntity.getUserName());
    user.setNickName(userEntity.getNickName());
    user.setPhone(userEntity.getPhone());
    user.setEmail(userEntity.getEmail());
    user.setPassWord(userEntity.getPassWord());
    user.setLastLogin(userEntity.getLastLogin());
    return user;
  }

  public static UserEntity fromUser(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(user.getId());
    userEntity.setUserName(user.getUserName());
    userEntity.setNickName(user.getNickName());
    userEntity.setPhone(user.getPhone());
    userEntity.setEmail(user.getEmail());
    userEntity.setPassWord(user.getPassWord());
    userEntity.setLastLogin(user.getLastLogin());
    return userEntity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getPhone() {
    return Phone;
  }

  public void setPhone(String phone) {
    Phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String emial) {
    this.email = emial;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }
}
