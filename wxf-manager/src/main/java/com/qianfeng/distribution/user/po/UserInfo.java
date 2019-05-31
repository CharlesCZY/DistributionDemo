package com.qianfeng.distribution.user.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

  private String userId;
  private String userName;
  private String account;
  private String password;
  private String remark;
  private String userType;
  private String enabled;
  private java.sql.Timestamp loginTime;
  private String roleId;
  private String self;


}