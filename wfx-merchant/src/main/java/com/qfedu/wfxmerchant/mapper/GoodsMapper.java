package com.qfedu.wfxmerchant.mapper;


import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import com.qfedu.wfxmerchant.po.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<WxGoodType> queryGoodType();

    void insertGoods(WxGoods goods);

    void saveGoodsSku(@Param("skuList")List<WxbGoodSku> sku);
    List<WxGoods> queryGoods(String customerId);

    void delGoods(String goodsId);
}
