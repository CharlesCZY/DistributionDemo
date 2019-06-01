package com.qfedu.wfxmerchant.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customers {
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

}
