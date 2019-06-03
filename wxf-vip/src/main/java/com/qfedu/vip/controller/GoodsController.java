package com.qfedu.vip.controller;

import com.qfedu.vip.po.Goods;
import com.qfedu.vip.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/list")
    public String queryAllGoods (Model model){
        List<Goods> goodsList = goodsService.queryAllGoods();
        model.addAttribute("goods",goodsList);
        return "index";
    }
}
