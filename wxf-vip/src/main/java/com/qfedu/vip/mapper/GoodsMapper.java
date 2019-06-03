package com.qfedu.vip.mapper;

import com.qfedu.vip.po.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> queryAllGoods();
}
