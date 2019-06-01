package com.qfedu.wfxmerchant.mapper;


import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<WxGoodType> queryGoodType();

    void insertGoods(WxGoods goods);

    List<WxGoods> queryGoods(String customerId);

    void delGoods(String goodsId);
}
