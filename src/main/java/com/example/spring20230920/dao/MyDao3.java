package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDao3 {

    // 1행 1열
    @Select(("""
            SELECT CustomerName FROM customers
            WHERE CustomerID = 1
            """))
    String select1();

    @Select("""
            SELECT Price FROM products
            WHERE ProductID = 1
            """)
    Double select2();

    @Select("""
SELECT LastName FROM employees
WHERE EmployeeID = 1
""")
    String select3();

    @Select("""
SELECT BirthDate FROM employees
WHERE EmployeeID = 2
""")
    String select4();
}
