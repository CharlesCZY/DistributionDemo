package com.qfedu.wfxmerchant.service;

import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGoodsService {

    List<WxGoodType> queryGoodType();

    void insertGoods(WxGoods goods);

    List<WxGoods> queryGoods(String customerId);

    void delGoods(String goodsId)throws Exception;
}
