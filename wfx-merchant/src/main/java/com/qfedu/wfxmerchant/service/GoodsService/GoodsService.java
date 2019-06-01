package com.qfedu.wfxmerchant.service.GoodsService;

import com.qfedu.wfxmerchant.mapper.GoodsMapper;
import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import com.qfedu.wfxmerchant.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService implements IGoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<WxGoodType> queryGoodType() {
        List<WxGoodType> goodTypes = goodsMapper.queryGoodType();

        return goodTypes;
    }

    @Override
    public void insertGoods(WxGoods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Override
    public List<WxGoods> queryGoods(String customerId) {
        List<WxGoods> goods = goodsMapper.queryGoods(customerId);

        return goods;
    }

    @Override
    public void delGoods(String goodsId) throws Exception{
        goodsMapper.delGoods(goodsId);
    }
}
