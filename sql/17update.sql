SELECT * FROM products;
SELECT * FROM products WHERE ProductID = 1;

UPDATE products
SET ProductName = '차이즈',
    Unit = '10 박스',
    Price = 36.00
WHERE ProductID = 1;

UPDATE products
SET ProductName = '두부김치'; -- where 꼭 쓸 것!!!(안써서 실행 안됨)

SELECT * FROM customers;
SELECT * FROM employees;
SELECT * FROM suppliers;

-- 예) 2번 고객의 이름 수정하기
SELECT * FROM customers
WHERE CustomerID = 2;

UPDATE customers
SET CustomerName = '전정국'
WHERE CustomerID = 2;

-- 예) 5번 직원이 notes 변경하기
SELECT * FROM employees
WHERE EmployeeID = 5;

UPDATE employees
SET Notes = '한국이라고'
WHERE EmployeeID = 5;

-- 예) 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers
WHERE SupplierID = 1;

UPDATE suppliers
SET Phone = '010-1234-5678',
    Address = '서울특별시'
WHERE SupplierID = 1;

--
SELECT * FROM products
WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;

SELECT * FROM shippers;