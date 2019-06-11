package com.qfedu.vip.mapper;

import com.qfedu.vip.po.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    void addOrder(OrderInfo orderInfo);

    void updateOrderState(@Param("orderId") String orderId);

}
