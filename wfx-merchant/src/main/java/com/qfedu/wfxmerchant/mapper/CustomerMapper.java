package com.qfedu.wfxmerchant.mapper;

import com.qfedu.wfxmerchant.po.Customers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customers> customerLogin(@Param("username") String username, @Param("password") String password);

}
