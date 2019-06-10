package com.qfedu.vip.mapper;

import com.qfedu.vip.po.GoodSku;
import com.qfedu.vip.po.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> queryAllGoods();

    List<GoodSku> querySkuListByGood(@Param("goodsId") String goodsId);

    Goods queryGoodsById (@Param("goodsId") String goodsId);
}
