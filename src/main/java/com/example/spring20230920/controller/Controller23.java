package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main23")
public class Controller23 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(String keyword) throws SQLException { // String keyword 써서 검색링크의 parameter로 표시하기 위해 사용
        String sql = """
                SELECT * FROM products
                WHERE productName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            System.out.println();
            System.out.println(keyword + "가 포함된 상품명들");
            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                System.out.println("name = " + name);
            }
        }
    }

    // /main23/sub2?k=red
    // erd 라는 텍스트가 중간에 있는 고객명 조회하는
    // 2번째 메소드 작성

    @GetMapping("sub2")
    public void method2(@RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE customerName LIKE ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        List<String> list = new ArrayList<>();
        try(connection; resultSet; statement){
            System.out.println();
            System.out.println(keyword + "가 포함된 고객명");
            while (resultSet.next()) {
                String name = resultSet.getString("customerName");
//                System.out.println("name = " + name);
                list.add(name);
            }

            model.addAttribute("keyword", keyword);
            model.addAttribute("nameList", list);
        }
    }

    // /main23/sub3?st=name2&k=red
    // 이 코드는 Spring Framework에서 사용되는 @GetMapping 어노테이션을 가진 메서드로,
    // HTTP GET 요청이 "/sub3" 경로로 들어왔을 때 이 메서드가 실행되도록 매핑합니다.
    // 해당 메서드는 데이터베이스에서 페이징된 고객 목록을 조회하고,
    // 그 결과를 모델에 담아서 뷰로 전달하는 역할을 합니다.
    @GetMapping("sub3")
    //@GetMapping("sub3"): 이 어노테이션은 HTTP GET 요청이 "/sub3" 경로로 들어왔을 때 이 메서드가 실행되도록 매핑합니다.
    public void method3(@RequestParam(value = "st", defaultValue = "name1") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException {
        // @RequestParam(value = "st", defaultValue = "name1") String searchType:
        // 이 어노테이션은 HTTP 요청 파라미터를 메서드의 인자로 받아오고, 요청 파라미터 중 "st"를 받아오는데,
        // 만약 "st"가 없다면 기본값으로 name1을 사용합니다.
        // 이 파라미터는 현재 페이지를 나타냅니다.


        // Model model: Spring MVC에서 사용되는 Model 객체로, 뷰에 데이터를 전달하기 위해 사용됩니다.
        // throws SQLException: 메서드에서 SQLException이 발생할 수 있음을 선언하고 있습니다. 이 예외는 데이터베이스 연동 시 발생할 수 있는 문제를 나타냅니다.
        //@RequestParam 사용 이유: @RequestParam 어노테이션은 HTTP 요청의 파라미터 값을 메서드의 인자로 받아오는데 사용됩니다. 이를 통해 클라이언트가 전달한 파라미터 값을 쉽게 추출하여 사용할 수 있습니다. 여기서는 페이지 번호를 받아오기 위해 사용되었습니다.

        // SQL 쿼리문: 데이터베이스에서 고객 정보를 조회하기 위한 SQL 쿼리문이 포함되어 있습니다.
        String sql = """
                SELECT * FROM customers
                WHERE
                """;

        if (searchType.equals("name1")) {
            sql += "customerName LIKE ?";
        } else if (searchType.equals("name2")) {
            sql += "contactName LIKE ?";
        }

        // Connection, PreparedStatement, ResultSet: JDBC를 사용하여
        // 데이터베이스와의 연결, 쿼리 수행, 결과 처리를 위한 객체들이 생성되고 사용됩니다.
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        // try-with-resources: try 블록 내에서 사용된 Connection, PreparedStatement, ResultSet 객체들은 try 블록을 벗어나면 자동으로 close됩니다.
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                String customerName = resultSet.getString("customerName");
                String contactName = resultSet.getString("contactName");

                list.add(Map.of("customerName", customerName, "contactName", contactName));
            }

            // JSP 모델에 추가: searchType, keyword, customers 등의 정보를 모델에 추가하여 뷰로 전달합니다.
            model.addAttribute("searchType", searchType);
            model.addAttribute("keyword", keyword);
            model.addAttribute("customers", list);
        }
    }

    @GetMapping("sub4")
    public void method4(@RequestParam(value = "t", defaultValue = "lname") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException{
        String sql = """
                SELECT * FROM employees
                WHERE
                """;

//        if (searchType.equals("lname")) {
//            sql += "LastName LIKE ?";
//        } else if (searchType.equals("fname")) {
//            sql += "FirstName LIKE ?";
//        } else if (searchType.equals("note")) {
//            sql += "Notes LIKE ?";
//        }

        switch (searchType) {
            case "lname":
                sql += "LastName LIKE ?";
                break;
            case "fname":
                sql += "FirstName LIKE ?";
                break;
            case "note":
                sql += "Notes LIKE ?";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet){
            while(resultSet.next()) {
                String LastName = resultSet.getString("LastName");
                String FirstName = resultSet.getString("FirstName");
                String Notes = resultSet.getString("Notes");

                list.add(Map.of("LastName", LastName,
                        "FirstName", FirstName,
                        "Notes", Notes));
            }
            model.addAttribute("searchType", searchType);
            model.addAttribute("keyword", keyword);
            model.addAttribute("employees", list);
        }
        }


}
