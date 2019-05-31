package com.qianfeng.distribution.user.service.impl;

import com.qianfeng.distribution.user.mapper.MerchantMapper;
import com.qianfeng.distribution.user.po.WxbCustomer;
import com.qianfeng.distribution.user.service.IMerchantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class MerchantServiceImpl implements IMerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    @Override
    public List<WxbCustomer> queryMerchantList() {
         List<WxbCustomer> wxbCustomers = merchantMapper.queryMerchantList();
            return wxbCustomers;
    }

    @Override
    public void saveMerchant(WxbCustomer customer) {
        customer.getCustomerId(UUID.randomUUID().toString());
        customer.getCreatetime(new Timestamp(new Date().getTime()));
        merchantMapper.saveMerchant(customer);
    }
}
