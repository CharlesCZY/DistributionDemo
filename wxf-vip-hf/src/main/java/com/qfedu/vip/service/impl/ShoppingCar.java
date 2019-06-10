package com.qfedu.vip.service.impl;


import com.qfedu.vip.mapper.ShoppingMapper;
import com.qfedu.vip.service.IShoppingCar;
import com.qfedu.vip.vo.MerchartInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCar implements IShoppingCar {

    @Resource
    private ShoppingMapper shoppingMapper;

    @Override
    public void addShopping(com.qfedu.vip.po.ShoppingCar shoppingCar) {

        shoppingMapper.addShopping(shoppingCar);


    }

    @Override
    public List<MerchartInfo> queryShoppingList(String userId) {
        List<MerchartInfo> merchartInfos = shoppingMapper.queryShoppingList(userId);
        return merchartInfos;
    }
}
