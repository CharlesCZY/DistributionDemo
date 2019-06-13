package com.qianfeng.demo19_springboot.controller;


import com.qianfeng.demo19_springboot.vo.JsonResultVO;
import com.qianfeng.demo19_springboot.vo.UserInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class AuthController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public JsonResultVO login(UserInfo userInfo){
        JsonResultVO jsonResultVO=new JsonResultVO();

        if ("admin".equals(userInfo.getUsername()) && "123456".equals(userInfo.getPassword())){

            Md5Hash md5Hash=new Md5Hash();
            String tokenStr=userInfo.getUsername()+userInfo.getPassword()+System.currentTimeMillis();
            md5Hash.setBytes(tokenStr.getBytes());
            String token=md5Hash.toHex();

            redisTemplate.boundValueOps(token).set(userInfo.getUsername(),30, TimeUnit.MINUTES);

            jsonResultVO.setCode(1);
            jsonResultVO.setMsg(token);
            return jsonResultVO;
        }
        jsonResultVO.setCode(0);
        return jsonResultVO;
    }

    @RequestMapping("/auth")
    public JsonResultVO auth(String token){
        JsonResultVO jsonResultVO=new JsonResultVO();

        String userInfo = redisTemplate.boundValueOps(token).get();
        if (userInfo==null||"".equals(userInfo.trim())){
            jsonResultVO.setCode(0);
            return jsonResultVO;
        }
        jsonResultVO.setCode(1);
        return jsonResultVO;
    }
}
