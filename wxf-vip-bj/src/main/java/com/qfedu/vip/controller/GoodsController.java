package com.qfedu.vip.controller;

import com.qfedu.vip.po.Goods;
import com.qfedu.vip.po.ShoppingCar;
import com.qfedu.vip.service.IGoodsService;
import com.qfedu.vip.vo.JsonResultVo;
import com.qfedu.vip.vo.MerchartInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
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

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${cxyservice}")
    private String cxyserviceUrl;

    private Logger logger=Logger.getLogger("保健商城");

    @RequestMapping("/cxy/list")
    public String queryAllGoods1(Model model) {
        logger.info("程序员保健品商城入口");
        Goods[] goods = restTemplate.getForObject(cxyserviceUrl, Goods[].class);
        List<Goods> goodsList = Arrays.asList(goods);
        model.addAttribute("goods", goodsList);
        return "index";
    }
    @RequestMapping("/zln/list")
    public String queryAllGoods2(Model model) {
        logger.info("中老年保健品商城入口");
        Goods[] goods = restTemplate.getForObject("http://zuul-server/zln/goods/list", Goods[].class);
        List<Goods> goodsList = Arrays.asList(goods);
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
   // @HystrixCommand(fallbackMethod = "addshoppingBei")
    @ResponseBody
    public JsonResultVo addShopping(String goodsId, String sku,String token) {

        jmsTemplate.convertAndSend("session",token);

        JsonResultVo resultVo=restTemplate.getForObject("http://auth-center/auth?token="+token,JsonResultVo.class);

        if (resultVo.getCode()==1) {
            ShoppingCar shoppingCar = new ShoppingCar();
            shoppingCar.setShpGoodsId(goodsId);
            shoppingCar.setShpGoodsNum("1");
            shoppingCar.setShpGoodsSku(sku);
            shoppingCar.getShpUserId("06778441");
            shoppingCar.setShpMerchantId("69609206");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String currentDate = simpleDateFormat.format(new Date());
            shoppingCar.setShpCartId(currentDate);

            JsonResultVo jsonResultVo = restTemplate.postForObject("http://wfx-cart1/add", shoppingCar, JsonResultVo.class);


            return jsonResultVo;
        }
        resultVo.setCode(0);
        return resultVo;
    }

    public JsonResultVo addshoppingBei(String goodsId, String sku){
        System.out.println("---触发熔断机制-----");
        JsonResultVo jsonResultVo=new JsonResultVo();
        jsonResultVo.setCode(0);
        jsonResultVo.setMsg("触发熔断机制");
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
