package com.thinner.apps.db;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by caoqitong on 8/15/15.
 */
public class ThinnerMySQL5Dialect extends MySQL5Dialect {
  @Override
  public String getTableTypeString() {
    return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
  }
}
