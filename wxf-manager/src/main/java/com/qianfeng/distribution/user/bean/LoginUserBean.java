package com.qianfeng.distribution.user.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LoginUserBean {
    private String userId;
    private String userName;
    private String account;
    private String password;
    private String remark;
    private String userType;
    private String enabled;
    private Timestamp loginTime;
    private String roleId;
    private String self;
    private String roleCode;
    private String roleName;


}
