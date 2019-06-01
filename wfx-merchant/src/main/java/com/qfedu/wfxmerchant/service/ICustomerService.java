package com.qfedu.wfxmerchant.service;


import com.qfedu.wfxmerchant.po.Customers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {

    List<Customers> customerLogin(String username,String password)throws Exception;

}
