package com.qfedu.vip.controller;

import com.qfedu.vip.po.Goods;
import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.service.IGoodsService;
import com.qfedu.vip.service.IShoppingCar;
import com.qfedu.vip.vo.JsonResultVo;
import com.qfedu.vip.vo.MerchartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IShoppingCar iShoppingCar;

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
        JsonResultVo jsonResultVo = new JsonResultVo();
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setShpGoodsId(goodsId);
        shoppingCar.setShpGoodsNum("1");
        shoppingCar.setShpGoodsSku(sku);
        shoppingCar.getShpUserId("06778441");
        shoppingCar.setShpMerchantId("69609206");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDate = simpleDateFormat.format(new Date());
        shoppingCar.setShpCartId(currentDate);

        iShoppingCar.addShopping(shoppingCar);
        jsonResultVo.setCode(1);


        return jsonResultVo;
    }

    @RequestMapping("/shoppingList")
    public String queryShoppingList(Model model){
        List<MerchartInfo> merchartInfos = iShoppingCar.queryShoppingList("06778441");
        model.addAttribute("shoppingList",merchartInfos);
        return "shoppingcart";
    }
}
