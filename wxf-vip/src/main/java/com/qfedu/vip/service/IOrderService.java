package com.qfedu.vip.service;

import com.qfedu.vip.po.OrderInfo;

public interface IOrderService {
    void addOrder(OrderInfo orderInfo)throws Exception;

    void updateOrderState(String orderId)throws Exception;
}
