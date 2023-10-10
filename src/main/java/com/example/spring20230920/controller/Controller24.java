package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto17Supplier;
import com.example.spring20230920.domain.MyDto18Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Controller
@RequestMapping("main24")
public class Controller24 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                INSERT INTO products(ProductName, SupplierID, CategoryID, Unit, Price)
                VALUE(?, ?, ?, ?, ?)
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try(connection; statement) {
            statement.setString(1, "돈까스");
            statement.setInt(2, 3);
            statement.setInt(3, 4);
            statement.setString(4, "한장");
            statement.setDouble(5, 500.00d);

//        statement.executeQuery(); // select 쿼리
            int count = statement.executeUpdate(); // DML(insert, delete, update) 쿼리

            if (count == 1) {
                System.out.println("잘됨!!");
            } else {
                System.out.println("뭔가 잘못됨");
            }
        }

    }
    // /main24/sub2 로 요청시
    // suppliers 테이블에 하나의 레코드 추가하는 메소드 작성
    @PostMapping("sub2")
    public void method2(MyDto17Supplier supplier) throws SQLException{
        String sql = """
                INSERT INTO suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUE (?, ?, ?, ?, ?, ?, ?)
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement){
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getContactName());
            statement.setString(3, supplier.getAddress());
            statement.setString(4, supplier.getCity());
            statement.setString(5, supplier.getPostalCode());
            statement.setString(6, supplier.getCountry());
            statement.setString(7, supplier.getPhone());

            int count = statement.executeUpdate();

            if (count == 1) {
                System.out.println("잘됨!");
            } else {
                System.out.println("안되나");
            }
        }
    }

    @GetMapping("sub3")
    public void method3() {

    }

    // 이 코드는 Spring MVC 컨트롤러 메서드로, HTTP GET 요청이 "/sub4" 경로로 들어왔을 때 실행되며,
    // 주어진 MyDto18Employee 객체에 저장된 정보를 사용하여 "employees" 테이블에 새 레코드를 추가합니다.

    // HTTP GET 요청이 "/sub4" 경로로 들어왔을 때 해당 메서드가 실행되도록 설정합니다.
    @GetMapping("sub4")
    public void method4() {

    }

    @PostMapping("sub4")
    public void method5(MyDto18Employee employee) throws SQLException {
        // INSERT INTO employees를 사용하여 "employees" 테이블에 새로운 레코드를 추가하는 SQL 쿼리를 정의합니다.
        // VALUES (?, ?, ?, ?, ?) 부분에는 각각 MyDto18Employee 객체의 필드에 해당하는 값이 들어갑니다.
        String sql = """
                INSERT INTO employees 
                (lastname, firstname, birthdate, photo, notes)
                VALUE (?, ?, ?, ?, ?)                
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        // try-with-resources 블록:
        //
        //Connection, PreparedStatement 객체들은 try 블록을 빠져나가면 자동으로 close됩니다.
        // PreparedStatement에 값 설정:
        //
        //MyDto18Employee 객체에서 각 필드 값을 가져와서 PreparedStatement에 설정합니다.
        try (connection; statement){
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getFirstName());
            statement.setTimestamp(3, Timestamp.valueOf(employee.getBirthDate().atStartOfDay()));
            statement.setString(4, employee.getPhoto());
            statement.setString(5, employee.getNotes());
// executeUpdate 메서드:
//
//SQL 쿼리를 실행하고, 영향을 받은 행의 수를 반환합니다.
//count 변수에 저장된 값으로 쿼리가 성공적으로 실행되었는지 여부를 확인합니다.
            int count = statement.executeUpdate();

            if (count == 1) {
                System.out.println("된당");
            } else {
                System.out.println("안된당");
            }
        }
    }

}
