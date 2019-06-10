package com.qfedu.vip.service;

import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.vo.MerchartInfo;

import java.util.List;

public interface IShoppingCar {

    void addShopping(ShoppingCar shoppingCar);

    List<MerchartInfo> queryShoppingList(String userId);
}
