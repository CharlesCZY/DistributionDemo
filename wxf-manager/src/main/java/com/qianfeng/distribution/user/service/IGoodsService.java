package com.qianfeng.distribution.user.service;

import com.qianfeng.distribution.user.po.WxGoods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGoodsService {


    List<WxGoods> queryGoods();

    void updateGoodsState(String goodsId,int state);
}
