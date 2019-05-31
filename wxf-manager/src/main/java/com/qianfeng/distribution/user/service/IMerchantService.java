package com.qianfeng.distribution.user.service;

import com.qianfeng.distribution.user.po.WxbCustomer;

import java.util.List;

public interface IMerchantService {
    List<WxbCustomer> queryMerchantList();

    void saveMerchant(WxbCustomer customer);

}
