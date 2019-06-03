package com.qfedu.wfxmerchant.service.GoodsService;

import com.qfedu.wfxmerchant.mapper.GoodsMapper;
import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import com.qfedu.wfxmerchant.po.WxbGoodSku;
import com.qfedu.wfxmerchant.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService implements IGoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<WxGoodType> queryGoodType() {
        List<WxGoodType> goodTypes = goodsMapper.queryGoodType();

        return goodTypes;
    }

    @Transactional
    public void insertGoods(WxGoods goods) {

        String ids=UUID.randomUUID().toString();
        goods.setGoodId(ids);
        List<WxbGoodSku> skuList=goods.getSkuList();
        int size=skuList.size();
        for (int i=0;i<size;i++){
            WxbGoodSku wxbGoodSku=skuList.get(i);

            wxbGoodSku.setSkuId(UUID.randomUUID().toString());
            wxbGoodSku.setGoodId(ids);
        }

        goodsMapper.insertGoods(goods);

        goodsMapper.saveGoodsSku(skuList);
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
