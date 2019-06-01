package com.qfedu.wfxmerchant.service.CustomerService;


import com.qfedu.wfxmerchant.mapper.CustomerMapper;
import com.qfedu.wfxmerchant.po.Customers;
import com.qfedu.wfxmerchant.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customers> customerLogin(String username,String password) throws Exception{
        List<Customers> customers = customerMapper.customerLogin(username,password);
        return customers;
    }


}
