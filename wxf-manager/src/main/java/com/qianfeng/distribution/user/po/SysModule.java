package com.qianfeng.distribution.user.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysModule {

  private String moduleId;
  private String moduleCode;
  private String moduleName;
  private String linkUrl;
  private long moduleOrder;
  private String parentModule;
  private String moduleDesc;
  private String expanded;
  private String leaf;

}
