# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Basic
3. create database
4. table
5. CRUD Operations
6. Clauses
7. Operators
8. Aggregate Functions
9. Data Constraints
10. Joining Data
11. Functions
12. Views
13. Indexes
14. Subquery
15. Miscellaneous Topics
16. Database Security

# **------ Nội dung chi tiết ------**

## ***1. Tài liệu tham khảo***
- https://www.geeksforgeeks.org/sql-tutorial/
- https://www.sqltutorial.org/

## 2. Basic
**2.1 Introduction**
- SQL là viết tắt của Structured Query Language
- Nó cho phép người dùng thực hiện nhiều tác vụ khác nhau như truy vấn dữ liệu, tạo và sửa đổi cấu trúc cơ sở dữ liệu và quản lý quyền truy cập. SQL được sử dụng rộng rãi trên nhiều hệ thống quản lý cơ sở dữ liệu quan hệ như MySQL, PostgreSQL, Oracle và SQL Server.
- Database Management System (DBMS) (Hệ quản trị cơ sở dữ liệu) là một phần mềm giúp bạn tạo, quản lý, truy cập và bảo trì cơ sở dữ liệu một cách hiệu quả và an toàn.
- Các DBMS phổ biến: MySQL, PostgreSQL, MongoDB (NoSQL)

**2.2 Data Types**
- Numeric Data Types (Kiểu số)
  + ![image](https://github.com/user-attachments/assets/6a8f945e-426f-4ce0-968c-04b6b0816741)

- String/Text Data Types (Kiểu chuỗi)
  + ![image](https://github.com/user-attachments/assets/737cef97-2d2a-4553-b294-4088762854e5)

- Date & Time Data Types (Ngày & Giờ)
  + ![image](https://github.com/user-attachments/assets/9e1e8a0b-97b1-4784-bb6e-2109df049156)

- Other Data Types (Khác)
  + ![image](https://github.com/user-attachments/assets/f8532c68-3be4-4020-b336-e9e6d77b45a6)

**2.3 Operators**
- Arithmetic Operators (Toán tử số học)
  + ![image](https://github.com/user-attachments/assets/8631e6fb-b435-4ab6-8144-fb25fb141bf7)
- Comparison Operators (Toán tử so sánh)
  + ![image](https://github.com/user-attachments/assets/e5dd8d6b-17d9-4d76-b10f-50e914b0c808)
- Logical Operators (Toán tử logic)
  + ![image](https://github.com/user-attachments/assets/7dc028ff-f74c-4380-962f-48c33dfc0b3d)
- Special Operators (Toán tử đặc biệt)
  + ![image](https://github.com/user-attachments/assets/6245eef0-a9ec-4a2d-924c-311bd439ce2d)

**2.4 Commands**
- DDL – Data Definition Language (Ngôn ngữ định nghĩa dữ liệu) => quản lý cấu trúc bảng
- DQL – Data Query Language => lấy dữ liệu từ bảng
- DML – Data Manipulation Language (Ngôn ngữ thao tác dữ liệu) => Quản lý dữ liệu
- DCL – Data Control Language (Ngôn ngữ kiểm soát truy cập) => Phân quyền
- TCL – Transaction Control Language (Ngôn ngữ điều khiển giao dịch) => Quản lý giao dịch
