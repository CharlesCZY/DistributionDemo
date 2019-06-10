package com.qfedu.vip.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MerchartInfo {
    private String merchantName;

    private List<GoodsInfo> goodsInfoList;
}
