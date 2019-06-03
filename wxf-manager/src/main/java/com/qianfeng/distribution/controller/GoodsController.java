package com.qianfeng.distribution.controller;

import com.qianfeng.distribution.user.po.WxGoods;
import com.qianfeng.distribution.user.service.IGoodsService;
import com.qianfeng.distribution.vo.JsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goodsAll")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/list")
    public String queryGoods(Model model){
         List<WxGoods> goods = goodsService.queryGoods();
         model.addAttribute("goods",goods);
         return "goods-list";
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public JsonResultVO updateGoodsState(String goodsId,int state){
        JsonResultVO jsonResultVO=new JsonResultVO();
        goodsService.updateGoodsState(goodsId,state);
        jsonResultVO.setCode(1);
        return jsonResultVO;
    }




}
