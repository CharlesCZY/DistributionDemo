package com.qianfeng.distribution.user.mapper;

import com.qianfeng.distribution.user.po.WxbCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantMapper {

    List<WxbCustomer> queryMerchantList();

    void saveMerchant(WxbCustomer customer);
}
