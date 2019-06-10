package com.qfedu.vip.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCar {
    private String shpCartId;
    private String shpGoodsId;
    private String shpUserId;
    private String shpMerchantId;
    private String shpGoodsSku;
    private String shpGoodsNum;

    public void getShpUserId(String s) {
        this.shpUserId=s;
    }
}
