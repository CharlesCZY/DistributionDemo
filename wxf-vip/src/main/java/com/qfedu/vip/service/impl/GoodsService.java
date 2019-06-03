package com.qfedu.vip.service.impl;

import com.qfedu.vip.mapper.GoodsMapper;
import com.qfedu.vip.po.Goods;
import com.qfedu.vip.service.IGoodsService;
import org.springframework.stereotype.Service;

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
}
