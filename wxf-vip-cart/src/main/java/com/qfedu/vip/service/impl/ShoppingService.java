package com.qfedu.vip.service.impl;


import com.qfedu.vip.mapper.ShoppingMapper;
import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.service.IShoppingCar;
import com.qfedu.vip.vo.JsonResultVo;
import com.qfedu.vip.vo.MerchartInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import org.apache.log4j.Logger;

@RestController
public class ShoppingService implements IShoppingCar {

    @Resource
    private ShoppingMapper shoppingMapper;

    private Logger logger=Logger.getLogger("购物车");

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @Override
    public JsonResultVo addShopping(@RequestBody ShoppingCar shoppingCar) {

        shoppingMapper.addShopping(shoppingCar);
        JsonResultVo jsonResultVo=new JsonResultVo();
        jsonResultVo.setCode(1);
        return jsonResultVo;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @Override
    public List<MerchartInfo> queryShoppingList() {
        List<MerchartInfo> merchartInfos = shoppingMapper.queryShoppingList("06778441");
        return merchartInfos;
    }
}
