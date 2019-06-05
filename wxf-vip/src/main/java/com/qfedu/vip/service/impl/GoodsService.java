package com.qfedu.vip.service.impl;

import com.qfedu.vip.mapper.GoodsMapper;
import com.qfedu.vip.po.GoodSku;
import com.qfedu.vip.po.Goods;
import com.qfedu.vip.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class GoodsService implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryAllGoods() {
         List<Goods> goodsList = goodsMapper.queryAllGoods();
        return goodsList;
    }

    @Transactional(readOnly = true)
    public List<GoodSku> querySkuListByGood(String goodsId) {
        List<GoodSku> goodSkus = goodsMapper.querySkuListByGood(goodsId);
        return goodSkus;
    }

    @Transactional(readOnly = true)
    public Goods queryGoodsById(String goodsId) {
        Goods goods = goodsMapper.queryGoodsById(goodsId);
        List<GoodSku> goodSkus = querySkuListByGood(goodsId);

        goods.setSkuList(goodSkus);
        return goods;
    }
}
