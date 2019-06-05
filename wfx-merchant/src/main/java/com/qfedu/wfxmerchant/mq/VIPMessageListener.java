package com.qfedu.wfxmerchant.mq;


import io.goeasy.GoEasy;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class VIPMessageListener {

    @JmsListener(destination = "merchant")
    public void listen(String msg){
        System.out.println("接收："+msg);

        GoEasy goEasy=new GoEasy("http://rest-hangzhou.goeasy.io","BC-923762b14d194202a9ef77bfed6e2953");
        goEasy.publish("merchant","success");
    }
}
