package com.qfedu.wfxmerchant.controller;


import com.qfedu.wfxmerchant.po.Customers;
import com.qfedu.wfxmerchant.service.CustomerService.CustomerService;
import com.qfedu.wfxmerchant.vo.JsonResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResultVo customerLogin(String username,String password){
        JsonResultVo jsonResultVo=new JsonResultVo();
        try {
            List<Customers> customers = customerService.customerLogin(username, password);
            
            jsonResultVo.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVo.setCode(0);
        }
        return jsonResultVo;

    }
}
