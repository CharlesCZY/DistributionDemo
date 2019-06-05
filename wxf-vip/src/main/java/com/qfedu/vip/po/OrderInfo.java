package com.qfedu.vip.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo {
    private String orderId;
    private String buyerPhone;
    private String goodId;
    private String orderTime;
    private String channelId;
    private String state;
    private String buyNum;
    private String province;
    private String city;
    private String area;
    private String buyerReamrk;
    private String payType;
    private String buyerName;
    private String skuId;
    private String address;

    public OrderInfo() {
    }

    public OrderInfo(String orderId, String buyerPhone, String goodId, String orderTime, String channelId, String state, String buyNum, String province, String city, String area, String buyerReamrk, String payType, String buyerName, String skuId, String address) {
        this.orderId = orderId;
        this.buyerPhone = buyerPhone;
        this.goodId = goodId;
        this.orderTime = orderTime;
        this.channelId = channelId;
        this.state = state;
        this.buyNum = buyNum;
        this.province = province;
        this.city = city;
        this.area = area;
        this.buyerReamrk = buyerReamrk;
        this.payType = payType;
        this.buyerName = buyerName;
        this.skuId = skuId;
        this.address = address;
    }

}
