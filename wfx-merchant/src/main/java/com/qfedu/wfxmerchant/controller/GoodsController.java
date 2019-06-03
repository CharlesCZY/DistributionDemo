package com.qfedu.wfxmerchant.controller;

import com.qfedu.wfxmerchant.po.WxGoodType;
import com.qfedu.wfxmerchant.po.WxGoods;
import com.qfedu.wfxmerchant.service.IGoodsService;
import com.qfedu.wfxmerchant.vo.JsonResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/type")
    public String queryGoodType(Model model){

            List<WxGoodType> goodTypes = goodsService.queryGoodType();
            model.addAttribute("goodtype",goodTypes);
        return "goods-add";

    }
    @RequestMapping("/list")
    public String queryGoods(Model model){
         List<WxGoods> goods = goodsService.queryGoods("69609206");
         model.addAttribute("goods",goods);
         return "goods-list";
    }


    @RequestMapping("save")
    @ResponseBody
    public JsonResultVo insertGoods(@RequestBody WxGoods goods){
        JsonResultVo jsonResultVo=new JsonResultVo();
        goods.getCustomerId("69609206");
        goods.setCreateTime(new Timestamp(new Date().getTime()));
        goodsService.insertGoods(goods);


        jsonResultVo.setCode(1);
        return jsonResultVo;

    }

    @RequestMapping("del")
    @ResponseBody
    public JsonResultVo delGoods(String goodId){
        JsonResultVo jsonResultVo =new JsonResultVo();
        try {
            goodsService.delGoods(goodId);
            jsonResultVo.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVo.setCode(0);
        }

        return jsonResultVo;
    }


}
