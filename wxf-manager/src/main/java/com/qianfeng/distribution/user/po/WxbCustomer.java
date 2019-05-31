package com.qianfeng.distribution.user.po;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class WxbCustomer {

  private String customerId;
  private String customerName;
  private String qq;
  private String wxh;
  private String phone;
  private java.sql.Timestamp createtime;
  private String loginName;
  private String loginPwd;
  private long state;
  private long level;
  private double accBalance;
  private java.sql.Timestamp updateTime;
  private String website;

  public void getCreatetime(Timestamp timestamp) {
    this.createtime=timestamp;
  }

  public void getCustomerId(String s) {
    this.customerId=s;
  }
}
