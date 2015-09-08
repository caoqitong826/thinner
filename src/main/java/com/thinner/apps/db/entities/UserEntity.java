package com.thinner.apps.db.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by caoqitong on 8/15/15.
 */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"userName","Phone","email"}))
public class UserEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;
  @Column(nullable = false)
  private String userName;
  @Column
  private String nickName = "";
  @Column
  private String phone;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String passWord;
  @Column
  private String photo;
  @Column
  private Date lastLogin;

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
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }
}
