package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

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

//    private Integer id;
//    private String lastName;
//    private String firstName;
//    private String photo;
//    private String notes;
//    private LocalDate birthDate;
    @Select("""
            SELECT 
            EmployeeID, LastName, FirstName, Photo, Notes, BirthDate
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33Employee getEmployeeById(Integer id);
}
