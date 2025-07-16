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

**2.4. Data Definition Language DDL**
- CREATE
- ALTER
- DROP
- TRUNCATE
- RENAME (tuỳ hệ CSDL)

**2.4. Transaction Control Language TCL**
- BEGIN / START TRANSACTION
- COMMIT
- ROLLBACK
- SAVEPOINT
- SET TRANSACTION

**2.4. Session/Configuration Commands**
- SET
- USE
- EXPLAIN / DESCRIBE
- SHOW 

# 6. SQL Clauses (Mệnh đề trong sql) Và statement (câu lệnh)
- https://www.geeksforgeeks.org/sql/sql-clauses/

## 6.1 Clause trong câu lệnh SELECT**
**6.1.1 WHERE**

**6.1.2 ORDER BY**
- ORDER BY – Sắp xếp kết quả
- ASC (default) : tăng dần
- DESC: Giảm dần
- Có thể sắp xếp theo
  + Tên cột
  + **Thứ tự cột: ORDER BY 2 (cột thứ 2)**
  + Biểu thức: ORDER BY LENGTH(name) DESC với MySQL hoặc PostgreSQL còn sqlserver là LEN
  + Sắp xếp nhiều cột: ORDER BY Country, CustomerName; hoặc ORDER BY Country ASC, CustomerName DESC;

**6.1.3 GROUP BY và HAVING**
- **GROUP BY là mệnh đề SQL dùng để gộp nhiều dòng dữ liệu có cùng giá trị ở một (hoặc nhiều) cột lại thành một nhóm. Sau đó bạn có thể áp dụng hàm tổng hợp như:COUNT(),SUM(),AVG() – tính trung bình, MAX() / MIN() – giá trị lớn nhất / nhỏ nhất. Chỉ gộp cột không dk dùng group by để với hàm tổng hợp -> nếu ko dùng với hàm tổng hợp thì sẽ ko có ỹ nghĩa**
- Không để các mệnh đề tổng hợp nào sau group by. ![image](https://github.com/user-attachments/assets/3bb7331f-1130-4de3-a796-55c2b5c9dd78)
- HAVING: HAVING dùng để lọc kết quả sau khi đã GROUP BY, Giống như WHERE, nhưng HAVING áp dụng các hàm tổng hợp, không phải từng dòng.
- ![image](https://github.com/user-attachments/assets/dfe9da1d-a631-46d9-af70-a17504ad05e9)



**6.1.4 LIMIT/ TOP/ FETCH FIRST**
-  LIMIT: Giới hạn số lượng dòng bạn muốn lấy ra từ kết quả SELECT.![image](https://github.com/user-attachments/assets/95197291-4158-4652-a93f-4be12c176d05)
-  OFFSET: để bỏ qua số dòng đầu, thường kết hợp với LIMIT ![image](https://github.com/user-attachments/assets/f21aeab9-db9f-4d75-83b5-7848819278a7)
-  TOP: Lấy những dòng đầu tiên, phải đứng sau select ![image](https://github.com/user-attachments/assets/a6b81b04-74be-4795-b3c0-c4155bd480ea)
   + TOP PERCENT: Cúng là lấy những dòng đầu nhưng là tính theo phần trăm ![image](https://github.com/user-attachments/assets/a9fdcc55-0d68-4706-bfb8-f1bbce120d95)

- FETCH FIRST n ROWS ONLY: FETCH FIRST là một mệnh đề SQL dùng để giới hạn số dòng được trả về từ một truy vấn, tương tự như LIMIT hoặc TOP.
  + ![image](https://github.com/user-attachments/assets/dfdc9a06-b5a3-4219-b53a-22046bacf9fc)
  + ![image](https://github.com/user-attachments/assets/ee2fb9bc-3eb8-4d74-85b4-5eaa0c1be7ea)

**6.1.5 LIKE**
- LIKE là một toán tử trong SQL được dùng để so sánh chuỗi văn bản với mẫu có chứa ký tự đại diện - dùng trong mệnh đề where để lọc
- **% -> Khớp với 0 hoặc nhiều ký tự bất kỳ** VD 'A%' → bắt đầu bằng A ![image](https://github.com/user-attachments/assets/4b9b94a6-460e-4d74-b62c-72a69bf93275)
- **_ -> Khớp với đúng 1 ký tự bất kỳ** VD 	'A_' → 2 ký tự, bắt đầu bằng A ![image](https://github.com/user-attachments/assets/869fadf1-bc82-41f1-8e48-f50b8d408d9d)
- **[] -> Biểu thị bất kỳ ký tự đơn nào trong dấu ngoặc** loại này có 1 số DBMS ko hỗ trợ. VD tìm tất cả các name có ký tự đầu là BSD -> WHERE CustomerName LIKE '[bsp]%';

**6.1.6 FROM**
- Lấy giá trị từ bảng nào

**6.1.7 AND**
- 

**6.1.8 DISTINCT**
- DISTINCT được dùng trong SQL để loại bỏ các dòng (record) bị trùng nhau trong kết quả truy vấn. SELECT DISTINCT Country FROM Customers;
- DISTINCT trên nhiều cột → Chỉ loại bỏ dòng trùng nếu cả Country và City cùng giống nhau. VD: SELECT DISTINCT Country, City FROM Customers;
- COUNT(DISTINCT x) Đếm cột x chỉ tính các giá trị khác nhau
- Nó không dùng với các hàm tổng hợp
- ![image](https://github.com/user-attachments/assets/35d0a373-cf88-42aa-8201-027e970db45d)


**6.1.9 JOIN**
- FULL JOIN: Lấy tất cả bản ghi ở cả 2 bảng, dù có khớp hay không (Chỉ hỗ trợ ở PostgreSQL, SQL Server, không có trong MySQL (phải dùng UNION).)
- CROSS JOIN: Tổ hợp tất cả các dòng (bảng A × bảng B)
  + ![image](https://github.com/user-attachments/assets/f441f80c-a1f3-4399-8779-fecc2f399916)
  + ![image](https://github.com/user-attachments/assets/da78e88b-f2e3-4ffa-80ce-ef0174d00d63)
  + ![image](https://github.com/user-attachments/assets/ec7e5ea0-a9f3-4d15-a4ca-e46f44369787)

- SELF JOIN = JOIN chính bảng đó với chính nó, Dùng bí danh (A, B) **SELF JOIN không là từ khóa chỉ là cách gọi**
  + ![image](https://github.com/user-attachments/assets/dfeac8b6-d83d-4346-a51d-1c4060ae6544)
  + ![image](https://github.com/user-attachments/assets/a02779d4-87a9-42fd-9e55-537bef6432a7)
  + ![image](https://github.com/user-attachments/assets/8b303426-2372-4197-9b89-c47b780032b5)
  + Chúng ta chũng có thể from từ 2 bảng ![image](https://github.com/user-attachments/assets/6da7a443-051c-459f-99e8-bd4a01ff876b)

**6.1.10 UNION/ UNION ALL**
- UNION được dùng để kết hợp kết quả của 2 (hoặc nhiều) câu truy vấn SELECT lại thành 1 tập kết quả duy nhất.
  + Điều kiện bắt buộc là: Số cột trong các SELECT phải bằng nhau, Kiểu dữ liệu tương ứng giữa các cột phải giống hoặc tương thích
  + UNION sẽ loại bỏ các dòng trùng lặp
  + ![image](https://github.com/user-attachments/assets/50c5426c-33f5-422d-bd03-e294396ce594)

- UNION ALL: giống UNION chỉ là lấy tất cả các bản ghi, cả bản ghi trùng nặp
  + ![image](https://github.com/user-attachments/assets/02149724-f333-4a26-b15f-f8f415447407)

**6.1.11 EXISTS, IN , NOT IN**
- IN: kiểm tra xem giá trị có nằm trong danh sách không ![image](https://github.com/user-attachments/assets/8bd5737b-ff85-42a5-8fc6-19ec857462e0)
- NOT IN:  kiểm tra không nằm trong danh sách ![image](https://github.com/user-attachments/assets/d442b9ff-20d3-4845-8d3b-73c582bd1221)
- IN (SELECT): Lọc giá trị có xuất hiện trong subquery, subquery chỉ trả ra 1 dòng ![image](https://github.com/user-attachments/assets/b6580e06-c9db-4e1e-9fc6-fd492900d45f)
- NOT IN (SELECT): Lọc giá trị không có trong subquery ![image](https://github.com/user-attachments/assets/30022fc7-aae5-48a7-ae18-7f1911cdff7d)
- **NOT  IN và NOT IN (SELECT) chú ý là nếu subquery là null thì nó cũng trả ra null -> sai logic -> cần check null**
- **EXISTS** là một mệnh đề được dùng trong WHERE để kiểm tra sự tồn tại của một hoặc nhiều dòng trong, Nếu có ít nhất một dòng được trả về từ subquery → EXISTS trả về TRUE.
  + ![image](https://github.com/user-attachments/assets/d6014fa4-c7a3-4622-959f-3dfd2956753d)
  + Không quan tâm là select cái gì, chỉ cần subquery có kết quả là true -> hiệu năng cao hơn
- **NOT EXISTS** ngược lại với Exists ![image](https://github.com/user-attachments/assets/c0a06472-7466-4be5-ab87-b085a81527bd)

**6.1.12 CASE WHEN ... THEN ... ELSE ... END**
- Câu lệnh CASE WHEN ... THEN ... ELSE ... END trong SQL là một biểu thức điều kiện rất mạnh, tương đương với cấu trúc if-else trong ngôn ngữ lập trình.
- ![image](https://github.com/user-attachments/assets/1a036629-fb84-4c44-9db2-3f336672a189)
- ![image](https://github.com/user-attachments/assets/331812d9-d770-4239-9146-94def5515316)
- ![image](https://github.com/user-attachments/assets/cf1018f9-87cd-4fc5-9845-7dd958a4516c)
- ![image](https://github.com/user-attachments/assets/443ec224-f255-4dd8-8b5a-5388f951d2a7)
- ![image](https://github.com/user-attachments/assets/9f1cee0f-063f-4d7f-9142-a7cd5f3179b0)
- Có thể dùng trong SELECT, ORDER BY, WHERE, GROUP BY, HAVING

**6.1.13 OR**


## 6.2 Clause trong câu lệnh INSERT, UPDATE, DELETE**

**6.2.1 INSERT INTO** 
- RETURNING(PostgreSQL) -> mục đích là trả về dữ liệu và được thực hiện(insert/update/delete)  ![image](https://github.com/user-attachments/assets/e1fe8568-1b30-456e-88fa-f74226b0e7b0)
  + Ứng dụng trong JPA: ![image](https://github.com/user-attachments/assets/06494db1-9726-4210-8c04-356bac68c61b)

- OUTPUT(SQL Server) -> Tương tự RETURNING trong PostgreSQL – cho phép truy xuất bản ghi bị ảnh hưởng.
- INSERT INTO ... SELECT -> Sao chép dữ liệu từ một bảng khác, hoặc từ kết quả truy vấn. ![image](https://github.com/user-attachments/assets/966049e1-2a00-4ba4-989b-b6403bca29ab)



**6.2.2 VALUES** 
- Nên batch nhiều VALUES (...) trong 1 INSERT để tối ưu hiệu năng
- Dùng VALUES trong câu UPDATE nâng cao (PostgreSQL, SQL Server):
  + Thay vì dùng CASE có thẻ dùng ![image](https://github.com/user-attachments/assets/903d466d-db93-4397-ac5d-86793b25d9ac)


**6.2.3 UPDATE** 
- Với nhiều row, nên dùng batch UPDATE hoặc MERGE (nâng cao)
- Dùng UPDATE ... JOIN để cập nhật từ bảng khác:

**6.2.4 SET** 
- Tránh SET col = (SELECT ...) nếu SELECT trả về nhiều dòng → lỗi.
- Dùng SET kết hợp CASE, SELECT, COALESCE, NULLIF để xử lý dữ liệu sạch hơn.
- Nếu update nhiều cột cùng lúc, có thể dùng alias tạm:

**6.2.5 DELETE FROM** 
- Cân nhắc dùng ON DELETE CASCADE trong ràng buộc FK nếu muốn xoá kèm con.
- Có thể dùng RETURNING hoặc OUTPUT để lấy bản ghi đã xoá.


## 6.3 Clause trong câu lệnh CREATE / ALTER / DROP**
- ALTER – Sửa đổi đối tượng đã tồn tại. VD:
  + Sửa dữ liệu: ALTER TABLE users ALTER COLUMN age TYPE SMALLINT;
  + Thêm 1 cột vào bảng: ALTER TABLE users ADD COLUMN age INT;
  + Đổi tên cột: ALTER TABLE users RENAME COLUMN name TO full_name;
  + PostgreSQL / SQL Server: ALTER COLUMN column_name TYPE new_data_type;
  + MySQL:MODIFY COLUMN column_name new_data_type;
- DROP IF EXISTS Tránh lỗi nếu đối tượng chưa tồn tại
- DROP CASCADE: Xóa bảng kèm theo các đối tượng phụ thuộc như foreign key, view,...


**6.3.1 CREATE TABLE**
- Ràng buộc (Constraints)
  + NOT NULL – Không được phép null
  + UNIQUE – Không trùng lặp
  + PRIMARY KEY – Khóa chính
  + FOREIGN KEY – Khóa ngoại, chúng ta có thê hành vi ON DELETE / ON UPDATE -> khi có thay đổi thì tất cả phụ thuộc thay đổi theo ![image](https://github.com/user-attachments/assets/aa660e9b-5f41-45be-867f-e8b380e3d42e)
  + CHECK Ràng buộc thảo mãn điều kiện nào đó: ![image](https://github.com/user-attachments/assets/dcba805f-2ef4-487e-bdaf-3d166153797e) ![image](https://github.com/user-attachments/assets/3ad0d65c-febe-4158-baec-2a2cc1be79c9)
  + AUTO INCREMENT -> dùng cho khóa chính tự tăng của mysql ![image](https://github.com/user-attachments/assets/4f32a5de-815c-41ab-bb4e-e7278558dd3b)
  + SERIAL -> dùng cho khóa chính tự tăng của PostgreSQL ![image](https://github.com/user-attachments/assets/4df19160-3eb3-49b3-bf70-4108074700c0)


- Khóa chính (PK) và khóa ngoại (FK)
  + Khóa chính tổ hợp (composite key) ![image](https://github.com/user-attachments/assets/e4b8b10b-f590-44ed-aff5-927256e38c3b)
  + Tránh dùng PK dạng VARCHAR -> Dễ gây tốn index space và chậm JOIN
- Tạo bảng với IF NOT EXISTS ![image](https://github.com/user-attachments/assets/08b73366-a88e-4ab7-a0f7-2e4439154a96)
- Tạo bảng từ kết quả truy vấn ![image](https://github.com/user-attachments/assets/26d96e80-6ebe-418e-95f6-6ec22219fffb)
- Tạo bảng tạm (Temporary Table)
  + Là bảng tồn tại tạm thời trong phiên làm việc hoặc kết nối (session) hiện tại.
  + Không ảnh hưởng đến schema chính của CSDL.
  + Chia nhỏ truy vấn tạo hiệu năng, đơn giản hóa cấu trúc
  + ![image](https://github.com/user-attachments/assets/6cf37b4d-30b8-44be-8e00-1e635ac928c8)

- INHERITS (PostgreSQL) Kế thừa bảng ![image](https://github.com/user-attachments/assets/2c3ae81e-300b-4724-a2c0-2609699ea71e)
  + Ràng buộc PK/FK/UNIQUE Không kế thừa tự động

- Tạo bảng với GENERATED ... STORED (PostgreSQL 12+) Dùng để tạo cột tự động tính toán từ cột khác, không cần trigger.
  + VD price: giá sản phẩm,  quantity: số lượng tồn kho => Muốn tự động tính total_value = price * quantity nhưng không muốn viết trigger ![image](https://github.com/user-attachments/assets/2c18c8e7-44fb-42b0-9294-949e4907048f)
  + Ko thể tự insert cột đã genetated

- GENERATED ... VIRTUAL (mysql) là cột có giá trị được tính toán "tạm thời" mỗi khi truy vấn — không được lưu trữ vào ổ đĩa.

**6.3.2 INDEX**
- https://200lab.io/blog/index-la-gi
- ![image](https://github.com/user-attachments/assets/893b8254-bb7f-4bdd-9a46-7183803cbdd2)
- https://www.atlassian.com/data/sql/how-indexing-works
- CREATE INDEX idx_name_trgm ON products USING gin (name gin_trgm_ops);
- Trong index có nhiều loại nhưng tiêu biểu nhất thì có 2 loại là B-tree và hash table
- Trong đó B-tree thì linh động hơn phù hợp nhiều nhiều kiểu where ==, <, > ... => đây cũng là kiểu mặc định
- Hash table thì kém hơn chỉ phù hợp với ==, do nó có cấu trúc giống như là của thằng hash table

**6.3.2. A Các lưu ý khi đáng index**

- Do khi đánh index  thì các giá trị đó sẽ được lưu trong một cấu trúc dữ liệu riêng biệt:
  + Bảng chính (Table): Lưu toàn bộ dữ liệu của các dòng (record)
  + Index: Là một cấu trúc dữ liệu riêng biệt, chứa:Giá trị của cột (hoặc cột tổ hợp) Con trỏ (hoặc ID) trỏ tới bản ghi tương ứng trong bảng chính |
=> **cách thức hoạt động**:
- Khi tạo index: CREATE INDEX idx_email ON users(email); => Database sẽ tạo một cấu trúc dữ liệu riêng (B-Tree), trông giống như(lưu cột và vị trí dòng): <img width="533" height="193" alt="image" src="https://github.com/user-attachments/assets/2953878d-2a38-4987-afd8-315f5356b8cf" />
- Khi chúng ta truy vấn: SELECT * FROM users WHERE email = 'binh@example.com'; => DB sẽ tra cứu trong index idx_email trước, xác định dòng cần lấy, rồi nhảy nhanh đến dòng đó trong bảng chính (table).
  +  Khi DB Engine có được pointer, nó dùng file offset (vị trí file) hoặc id để truy xuất trực tiếp đến đúng dòng đó không cần quét toàn bộ bảng.
- Chính vì khi đánh index nó tạo thêm 1 bảng cấu trúc dữ liệu riêng => **tạo nhiều index sẽ gây chệm cho các câu lệnh insert, update, delete. Do phải update cả bảng index nữa**
- **Khi đánh nhiều Index thì sẽ có các vấn đề gì?**
  + Mỗi một hệ quản trị cơ sở dữ liệu thì đều có 1 cách khác nhau để quản lý
  + Hệ quản trị cơ sở dữ liệu sử dụng thống kê về dữ liệu trong bảng để quyết định chỉ mục nào sẽ được sử dụng => **Nếu một chỉ mục có nhiều bản ghi hoặc có tỷ lệ chọn lọc tốt hơn, nó có thể được ưu tiên hơn.**
  + **Sử dụng câu lệnh EXPLAIN để xem kế hoạch thực thi của truy vấn để biết hệ quản trị cơ sở dữ liệu đã chọn chỉ mục nào và tại sao**
  + **Về việc tối ưu khi đặt index thì nên tìm hiểu về **Query optimizer** Query optimizer sẽ hoạt động dựa trên (cost,thống kê..)

**6.3.2. B Các loại index**

**6.3.3. Query optimizer**
 
**6.3.3 Sự khác nhau giữa DROP và TRUNCATE và DELETE**
- ![image](https://github.com/user-attachments/assets/23dc40ca-e49c-4631-8286-ce17049fb533)
- TRUNCATE là DDL nên:
  + Không sinh trigger (PostgreSQL, MySQL)
  + Không dùng được nếu bảng bị FOREIGN KEY ràng buộc

- DELETE là DML: 
  + Ghi log từng dòng → phù hợp với audit, an toàn hơn

- DROP không thể rollback nếu không nằm trong transaction block đặc biệt (PostgreSQL 13+ cho phép DROP TABLE trong transaction)

## 6.4 MỆNH ĐỀ CON (SUBQUERY)**

**6.4.1 (SELECT ...)** 

**6.4.1 IN (SELECT ...)** 

**6.4.1 EXISTS (SELECT ...)** 
- Trả về TRUE nếu subquery có ít nhất 1 dòng: Tối ưu vì không quan tâm kết quả, chỉ cần tồn tại. SELECT 1 là kỹ thuật viết subquery nhẹ hơn.

**6.4.1 ANY, ALL (so sánh với subquery)** 
- Dùng để so sánh một giá trị với tập hợp các giá trị từ subquery.
- ALL ![image](https://github.com/user-attachments/assets/bdb578ff-bd10-4f52-a371-d7347ae46984)
- ANY ![image](https://github.com/user-attachments/assets/b6a23919-ef41-4ac6-83d0-ffeae65f1b0e)
- > ALL (subquery) Lớn hơn tất cả giá trị
- < ANY (subquery) Nhỏ hơn ít nhất một giá trị
- = ANY (subquery) Tương đương với IN
- Không dùng IN nếu subquery trả về NULL ⇒ dễ sai kết quả.



## 6.5 MỆNH ĐỀ TRONG QUẢN TRỊ CSDL**
**6.5.0 Tạo user**
- PostgreSQL: CREATE USER username WITH PASSWORD 'password';
- MySQL: CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
  + localhost: Địa chỉ từ đó người dùng có thể kết nối (có thể thay đổi thành % để cho phép kết nối từ mọi địa chỉ).
 
- SQLserver: CREATE LOGIN username WITH PASSWORD = 'password';
**6.5.1 GRANT, REVOKE**
- GRANT: Cấp quyền . VD GRANT SELECT, INSERT ON employees TO user_name; (ấp quyền SELECT, INSERT lên bảng employees cho người dùng user_name.)
  + Một số quyền phổ biến:
  + ELECT, INSERT, UPDATE, DELETE
  + ALL PRIVILEGES: dùng để cấp toàn bộ quyền truy cập khả dụng cho một người dùng đối với một đối tượng (bảng, schema, toàn bộ database,...). Đây là cách nhanh chóng để cho phép user làm mọi thao tác mà hệ thống cho phép.
  + ![image](https://github.com/user-attachments/assets/de5ed6a9-d042-4000-99f8-b42acb901e4f)

  + EXECUTE (đối với thủ tục hoặc hàm)

- REVOKE: Thu hồi quyền. VD: REVOKE SELECT, INSERT ON employees FROM user_name; (Thu hồi quyền SELECT, INSERT khỏi user.)
**6.5.2 COMMIT, ROLLBACK, SAVEPOINT**
- Một transaction là một khối thao tác (SQL) được thực hiện cùng nhau như một đơn vị logic.
-  BEGIN; hoặc START TRANSACTION; bắt đầu 1 transaction
-  COMMIT; Ghi vĩnh viễn các thay đổi vào DB
-  ROLLBACK; ROLLBACK: Hoàn tác (undo) toàn bộ thay đổi kể từ BEGIN
- SAVEPOINT – điểm khôi phục tạm trong transaction ![image](https://github.com/user-attachments/assets/f3f4bff1-b258-4838-b5c0-53e4d417a6c3)


**6.5.3 BEGIN, END**
- BEGIN ... END – Cấu trúc khối (Block Statements)
  + PostgreSQL: sử dụng PL/pgSQL: DO $$ BEGIN ... END $$
  + SQL Server: dùng BEGIN ... END ![image](https://github.com/user-attachments/assets/37ba403e-c2ca-4645-ae12-ad55dc422ac4)

  + Oracle: BEGIN ... END;

**6.5.1 SET**
- SET – Gán giá trị hoặc thiết lập cấu hình
- ![image](https://github.com/user-attachments/assets/c52cf9c4-0bfc-4238-9956-5a3a274688cd)
