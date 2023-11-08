package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDao10 {

    @Select("""
        SELECT CustomerName FROM customers
        WHERE CustomerID = 50
        """)
    String getCustomerName();

    @Select("""
            SELECT 
             CustomerID id,
             CustomerName name,
             ContactName,
             address,
             City,
             PostalCode,
             Country
             FROM customers
            WHERE CustomerID = 50
            """)
    MyDto34Customer getCustomer();

    @Select("""
            SELECT 
             CustomerID id,
             CustomerName,
             ContactName,
             address,
             City,
             PostalCode,
             Country
             FROM customers
            WHERE CustomerID = #{id}
            """)
    MyDto34Customer getCustomerById(Integer id);
}
