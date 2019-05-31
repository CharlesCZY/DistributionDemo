package com.qianfeng.distribution.controller;


import com.qianfeng.distribution.user.po.WxbCustomer;
import com.qianfeng.distribution.user.service.IMerchantService;
import com.qianfeng.distribution.vo.JsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private IMerchantService merchantService;

    @RequestMapping("/list")
    public String queryMerchantList(Model model){
        List<WxbCustomer> wxbCustomers = merchantService.queryMerchantList();
        model.addAttribute("customer",wxbCustomers);
        return "merchant-list";
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResultVO saveMerchant(WxbCustomer customer){
        JsonResultVO jsonResultVO=new JsonResultVO();
        try {
            merchantService.saveMerchant(customer);
            jsonResultVO.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
        }
        return jsonResultVO;
    }

}
