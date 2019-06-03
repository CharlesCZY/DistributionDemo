package com.qianfeng.distribution.user.mapper;


import com.qianfeng.distribution.user.po.WxGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {



    List<WxGoods> queryGoods();

    void updateGoodsState(@Param("goodsId") String goodsId,@Param("state") int state);

}
