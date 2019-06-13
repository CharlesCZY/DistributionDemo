package com.qfedu.vip.service;

import com.qfedu.vip.po.GoodSku;
import com.qfedu.vip.po.Goods;

import java.util.List;


public interface IGoodsService {

    List<Goods> queryAllGoods();

    List<GoodSku> querySkuListByGood(String goodsId);

    Goods queryGoodsById (String goodsId);
}
