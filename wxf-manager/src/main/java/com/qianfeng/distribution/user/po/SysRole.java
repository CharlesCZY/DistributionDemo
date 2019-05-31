package com.qianfeng.distribution.user.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysRole {

  private String roleCode;
  private String roleName;
  private String roleDesc;
  private long roleOrder;
  private long roleType;

}
