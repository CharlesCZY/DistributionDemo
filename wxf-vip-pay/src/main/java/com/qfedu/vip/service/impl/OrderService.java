package com.qfedu.vip.service.impl;

import com.qfedu.vip.mapper.OrderMapper;
import com.qfedu.vip.po.OrderInfo;
import com.qfedu.vip.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Override
    public void addOrder(OrderInfo orderInfo) throws Exception {
        orderMapper.addOrder(orderInfo);
    }

    @Override
    public void updateOrderState(String orderId) throws Exception {
        orderMapper.updateOrderState(orderId);
    }
}
