# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Spring Boot – H2 Database
3. Spring Boot – JDBC
4. JPA And ORM
5. Hibernate 
6. Spring Boot – Spring Data JPA
7. Spring Boot – MongoRepository with Example
8. Spring Boot – Difference Between CrudRepository and JpaRepository
9. Spring Boot – CRUD Operations using MongoDB



# **------ Nội dung chi tiết ------**

## 1. Nội dung tham khảo
- https://www.geeksforgeeks.org/spring-boot/
- https://www.geeksforgeeks.org/spring-data-jpa-tutorial/
- https://www.geeksforgeeks.org/hibernate-tutorial/

## 4.  JPA And ORM

**4.1 JPA**
- JPA (Java Persistence API) là một specification (đặc tả, tiêu chuẩn) được đưa ra bởi Java EE (nay là Jakarta EE). Là đặc tả (specification) để làm ORM trong Java.
- JPA là một specification (đặc tả) — tức là nó chỉ định giao diện, quy tắc, annotation, hành vi, nhưng không triển khai thực tế.
- Để sử dụng JPA, bạn chọn một JPA provider cụ thể (ví dụ như Hibernate hoặc EclipseLink).
- Các provider này triển khai JPA theo cách riêng nhưng đều tuân theo cùng một hợp đồng JPA.
- JPA là một tập hợp các interface, không phải là thư viện có thể chạy độc lập. Ví dụ: EntityManager, @Entity, @OneToMany... đều là phần của JPA specification.

**4.2 ORM**
- Object-Relational Mapping là kỹ thuật ánh xạ giữa các object trong ngôn ngữ lập trình hướng đối tượng (như Java) và các bảng trong cơ sở dữ liệu quan hệ (SQL).
- ![image](https://github.com/user-attachments/assets/079fa8e3-95fa-4b97-809d-9cc19b295d22)
- ORM làm nhiệm vụ chuyển đổi (map) giữa: Class ↔ Table, Object ↔ Row, Field ↔ Column.
- ![image](https://github.com/user-attachments/assets/2194d94a-6045-4c97-bd82-9a29c30579e7)
- Chúng ta có ORM framework phổ biến: Hibernate, Mybatis (Bán-ORM (dùng XML để map SQL))

## 5. Hibernate
**5.1 Khái niện**
-  Hibernate là một thư viện ORM mạnh mẽ, và đồng thời cũng là một JPA Provider.
-  Hibernate là một ORM framework (thư viện) trong Java, giúp ánh xạ các class Java ↔ bảng trong database quan hệ (RDBMS). Hibernate có thể được sử dụng độc lập, không cần JPA.
-  Hibernate chính là một JPA provider — nghĩa là nó hiện thực (implement) toàn bộ các quy định của JPA để bạn có thể thao tác với database theo chuẩn JPA. Sau khi JPA ra đời (về sau), Hibernate đã hiện thực JPA spec, trở thành một JPA provider
-  => **JPA giống như chuẩn USB-C, hibernate giống như một chiếc sạc tương thích với USB-C. Ở đây Bạn có thể dùng Hibernate (sạc) trực tiếp, hoặc thông qua JPA (chuẩn cắm).**

**5.2 config**
- Link https://www.digitalocean.com/community/tutorials/spring-hibernate-integration-example-tutorial
## 6. Spring Data JPA
- Là một phần trong hệ sinh thái của spring data. 
- Spring Boot JPA đã wrapper Hibernate và tạo ra một interface mạnh mẽ. Nếu như bạn gặp khó khăn khi làm việc với Hibernate thì đừng lo, bạn hãy để Spring JPA làm hộ.
- Nếu chỉ làm hibernate chúng ta sẽ cần phải cấu hình rất nhiều, spring jpa đã giúp ta làm thay phần việc này. VD  ![image](https://github.com/user-attachments/assets/e8c80d85-5140-4726-b836-978e73f86621)


**6.1 config**
- có thể config thông qua file properties hoặc thông qua class java

***6.1.1 properties***
- spring.datasource.url=jdbc:postgresql://<host>:<port>/<database_name>?currentSchema=<schema_name> : link server DB, nếu dùng schema mặc định thì có thể bỏ currentSchema
- spring.datasource.username=root => là username dùng trong DB (việc tạo user name và password có thể check doc sql)
- spring.datasource.password=1234 => là password.
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver => dùng cơ sở dữ liệu nào thì tải driver đó.
- spring.jpa.hibernate.ddl-auto:  Cấu hình này dùng để chỉ định cách Hibernate xử lý schema của database khi ứng dụng khởi động. Giá trị mặc định là none.
  + none: Không thực hiện thao tác gì với schema của database.
  + validate: Kiểm tra schema hiện tại và validate với các Entity trong ứng dụng. Nếu không khớp, ứng dụng sẽ báo lỗi.
  + update: Cập nhật schema của database từ các Entity mà không làm mất dữ liệu cũ.
  + create: Xóa schema cũ và tạo lại schema mới từ các Entity khi ứng dụng khởi động (dữ liệu cũ sẽ bị mất).
  + create-drop: Tạo schema mới khi ứng dụng khởi động và xóa schema khi ứng dụng tắt.
- spring.jpa.show-sql: Cấu hình này cho phép bạn xem các câu lệnh SQL mà Hibernate sẽ thực thi. Giá trị mặc định là false
  + true: In các câu SQL ra console.
  + false: Không in câu SQL.
- spring.jpa.properties.hibernate.format_sql: Giúp định dạng các câu lệnh SQL sao cho dễ đọc hơn trong console. Giá trị mặc định là false
  + true: Định dạng SQL đẹp, dễ đọc (các câu lệnh SQL sẽ được căn chỉnh).
  + false: SQL không được định dạng, chỉ in ra nguyên vẹn câu lệnh SQL.
- spring.jpa.properties.hibernate.dialect: chỉ định cũ pháp và hành vi đặc thù của database đó. (thường là MySQLDialect hoặc H2Dialect nếu chưa cấu hình rõ ràng)
  + org.hibernate.dialect.MySQL8Dialect: Dành cho MySQL phiên bản 8.
  + org.hibernate.dialect.PostgreSQLDialect: Dành cho PostgreSQL.
  + org.hibernate.dialect.Oracle12cDialect: Dành cho Oracle 12c.
  + org.hibernate.dialect.SQLServerDialect: Dành cho Microsoft SQL Server.
  + org.hibernate.dialect.H2Dialect: Dành cho H2 database (dùng cho testing).
- spring.jpa.open-in-view: Cấu hình này xác định liệu Hibernate có duy trì kết nối tới database trong suốt vòng đời của HTTP request hay không.Default: true
  + true: Bật tính năng Open Session in View, Hibernate giữ kết nối cho đến khi view được render.
  + false: Tắt tính năng này (khuyến khích tắt trong các ứng dụng thực tế để tránh các vấn đề liên quan đến hiệu suất và LazyInitializationException).
- spring.jpa.defer-datasource-initialization: Cấu hình này dùng để trì hoãn việc khởi tạo datasource cho đến khi các bean khác trong Spring được khởi tạo. mặc định là false
  + true: Trì hoãn việc khởi tạo datasource cho đến khi các bean Spring khác đã được khởi tạo.
  + false: Tự động khởi tạo datasource khi Spring Boot khởi động.
- spring.jpa.properties.hibernate.jdbc.batch_size: Cấu hình này giúp Hibernate sử dụng batch processing cho các câu lệnh SQL (insert, update) để giảm số lần giao tiếp với database, từ đó cải thiện hiệu suất. Default null
  + Một số nguyên dương (ví dụ: 30): Chỉ định kích thước của batch, Hibernate sẽ gom lại 30 bản ghi để thực hiện các thao tác insert/update.
- spring.jpa.properties.hibernate.order_inserts: Cấu hình này quyết định xem Hibernate có gom các câu lệnh insert lại theo thứ tự để tối ưu hóa không. Default false
  + true: Các câu lệnh insert sẽ được gom lại theo thứ tự.
  + false: Mỗi insert sẽ được thực hiện riêng biệt.
- spring.jpa.properties.hibernate.order_updates: Cấu hình này giúp Hibernate gom các câu lệnh update lại theo thứ tự để giảm số lần update vào database. Default false
  + true: Các câu lệnh update sẽ được gom lại theo thứ tự.
  + false: Các update sẽ được thực hiện riêng biệt.
- spring.jpa.properties.hibernate.enable_lazy_load_no_trans: Cấu hình này cho phép truy cập các thuộc tính lazy-loaded của một entity ngoài transaction. Default false
  + true: Cho phép lazy load các thuộc tính khi không có transaction.
  + false: Chỉ cho phép lazy load các thuộc tính trong một transaction.
  + ![image](https://github.com/user-attachments/assets/35310916-2e43-489b-b76a-aa4ff2e4d0c4) Nếu ko đặt trong 1 @Transaction thì sẽ bị lỗi ![image](https://github.com/user-attachments/assets/765b6245-2ff4-4ed9-93a8-9528fc22c35c). Khi bật spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true thì chúng ta ko cần đặt trong @Transaction nữa

***6.1.2 config with java***

***6.2 

**6. Repository**

**6. Entity Relationships**

**6. Composite Key**

**6. FetchType và Performance**

**6. DTO Projection & Custom Result Mapping**

**6. Native Query vs JPQL**

**6. Pagination & Sorting**

**6. Auditing**

**6. Transaction**

**6. Validation & Constraint**

**6. Locking**

**6. Custom Repository**

**6. Migration Tool (Optional): Flyway / Liquibase/ mybatis**




