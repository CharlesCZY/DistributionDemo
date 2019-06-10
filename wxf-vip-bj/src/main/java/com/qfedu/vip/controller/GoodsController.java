package com.qfedu.vip.controller;

import com.qfedu.vip.po.Goods;
import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.service.IGoodsService;
import com.qfedu.vip.vo.JsonResultVo;
import com.qfedu.vip.vo.MerchartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService goodsService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/list")
    public String queryAllGoods(Model model) {
        List<Goods> goodsList = goodsService.queryAllGoods();
        model.addAttribute("goods", goodsList);
        return "index";
    }

    @RequestMapping("/listSku")
    public String querySkuListByGood(String goodsId, Model model) {
        Goods goods = goodsService.queryGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "sku";
    }

    @RequestMapping("/addshopping")
    @ResponseBody
    public JsonResultVo addShopping(String goodsId, String sku) {

        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setShpGoodsId(goodsId);
        shoppingCar.setShpGoodsNum("1");
        shoppingCar.setShpGoodsSku(sku);
        shoppingCar.getShpUserId("06778441");
        shoppingCar.setShpMerchantId("69609206");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDate = simpleDateFormat.format(new Date());
        shoppingCar.setShpCartId(currentDate);

        JsonResultVo jsonResultVo=restTemplate.postForObject("http://wfx-cart1/add",shoppingCar,JsonResultVo.class);


        return jsonResultVo;
    }

    @RequestMapping("/shoppingList")
    public String queryShoppingList(Model model){
        MerchartInfo[] merchartInfos=restTemplate.getForObject("http://wfx-cart1/list", MerchartInfo[].class );
        List<MerchartInfo> list = Arrays.asList(merchartInfos);
        model.addAttribute("shoppingList",list);
        return "shoppingcart";
    }
}
