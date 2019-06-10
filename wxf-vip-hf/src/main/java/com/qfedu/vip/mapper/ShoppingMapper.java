package com.qfedu.vip.mapper;


import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.vo.MerchartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    void addShopping(ShoppingCar shoppingCar);

    List<MerchartInfo> queryShoppingList(@Param("userId") String userId);
}
