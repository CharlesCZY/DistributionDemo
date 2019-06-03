package com.qianfeng.distribution.user.service.impl;


import com.qianfeng.distribution.user.mapper.GoodsMapper;
import com.qianfeng.distribution.user.po.WxGoods;
import com.qianfeng.distribution.user.service.IGoodsService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService implements IGoodsService{

    @Resource
    private GoodsMapper goodsMapper;



    @Override
    public List<WxGoods> queryGoods() {
        List<WxGoods> goods = goodsMapper.queryGoods();

        return goods;
    }

    @Override
    public void updateGoodsState(String goodsId,int state) {
        goodsMapper.updateGoodsState(goodsId,state);
    }


}
