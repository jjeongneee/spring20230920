package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface MyDao8 {

    @Select("""
            SELECT *
            FROM products
            WHERE ProductID = #{id}
            """)
    Map<String, Object> selectProductById(Integer id);

    @Select("""
            SELECT EmployeeID id,
                FirstName,
                LastName,
                BirthDate,
                Photo,
                Notes
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33Employee selectByEmployeeId(Integer id);

    @Select("""
            SELECT ProductID id,
                p.Price price,
                c.CategoryName category,
                p.Unit unit
            FROM products p JOIN categories c ON p.CategoryID = c.CategoryID
            WHERE ProductID = #{id}
            """)
    MyDto45 selectByProductId2(Integer id);
}
