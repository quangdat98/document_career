# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Spring Boot – H2 Database
3. Spring Boot – JDBC
4. JPA And ORM
5. Hibernate 
6. Spring Boot – Spring Data JPA
7. Spring Boot – MongoRepository with Example



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
- Dùng @Configuration để config
- Chúng ta sẽ dùng các thư viện javax.sql.DataSource và javax.persistence.EntityManagerFactory.
- Có thể config dùng 2 datasource (về mặt DB thì việc chia ra làm 2 url read và write thực tế là sử dụng 1 proxy trung gian như proxysql hay mysal router, maxscale: Tự động route query SELECT → replica, Tự động route INSERT/UPDATE/DELETE → master)
- **EntityManagerFactory**đối tượng chính bạn dùng để tương tác với cơ sở dữ liệu: thêm mới, cập nhật, xóa...
  + Mỗi lần làm việc với DB thì entityManagerFactory.createEntityManager() để tạo ra một phiên làm việc.
- **PlatformTransactionManager**  rong Spring là giao diện cốt lõi để quản lý transaction (giao dịch) – tức là giúp bạn bắt đầu, commit, rollback... các giao dịch khi làm việc với database hoặc các hệ thống transactional khác.
  + khi bạn xử lý thủ công ( không dùng @Transaction): ![image](https://github.com/user-attachments/assets/342c5710-b439-4f9d-a105-3c4604963640). Khi dùng nhiều datasource thì cần nhiều platformTracsactionManager mỗi cái gắn với 1 EntityManagerFactory để quản lý.

**6.2 Repository**

***6.2.1 Khái niệm***
- Repository là một interface hoặc lớp giúp bạn tương tác với cơ sở dữ liệu một cách đơn giản mà không cần phải viết các câu truy vấn SQL thủ công.
- Chúng ta có một số loại repository sau: JpaRepository, CrudRepository,PagingAndSortingRepository, custom

***6.2.2 CrudRepository***
- là một trong những interface cơ bản nhất trong Spring Data JPA, cung cấp các phương thức cơ bản để thực hiện các thao tác CRUD (Create, Read, Update, Delete) với cơ sở dữ liệu.
- Hạn chế: Không hỗ trợ các tính năng nâng cao như phân trang, sắp xếp, hay các truy vấn phức tạp.

***6.2.3 JpaRepository***
- JpaRepository kế thừa từ CrudRepository và PagingAndSortingRepository, vì vậy nó có tất cả các phương thức của CrudRepository cộng thêm một số tính năng nâng cao như phân trang và sắp xếp.
- Các tính năng nâng cao: Có thể sử dụng các phương thức như flush(), saveAndFlush(), giúp bạn tối ưu hóa khi làm việc với dữ liệu lớn hoặc các thao tác cần được commit ngay lập tức.

***6.2.2 PagingAndSortingRepository***

**6.3 Entity Relationships**
- mô tả cách các entity (đối tượng trong cơ sở dữ liệu) liên kết với nhau.
- @OneToOne: Mối quan hệ một-một giữa hai entity, có nghĩa là mỗi đối tượng của entity A chỉ liên kết với một đối tượng duy nhất của entity B, và ngược lại.
  + ![image](https://github.com/user-attachments/assets/cf87ddd4-49c1-4e2d-bb14-22744b63aa1a)
  + Khi cúng ta đã khai báo các mối quan hệ giữa 2 entity thì trong query có thể join trực tiếp ntn: ![image](https://github.com/user-attachments/assets/fdde46d3-0f94-4fa4-b44c-7a98eeca25ed) ![image](https://github.com/user-attachments/assets/578df7c2-6cc0-4fd0-9791-3a2595ca84a9)

- @OneToMany và @ManyToOne
  + ![image](https://github.com/user-attachments/assets/6ddcd34f-5c00-42c6-bd74-ed7ba713a5af)
  + ![image](https://github.com/user-attachments/assets/a2bc7d84-e9d4-4087-b859-f8a509c076d6)
  + ![image](https://github.com/user-attachments/assets/d3f1d133-7997-4aec-bdc1-9612d7b7b8ff)



- @ManyToMany
  + Là mối quan hệ nhiều – nhiều giữa hai entity.
  + JPA sẽ tự tạo bảng trung gian với 2 khóa ngoại.
  + ![image](https://github.com/user-attachments/assets/ec76fa80-8885-4b6b-9c53-1922dbceb3e6)
  + Chỉ 1 bên là chủ sở hữu: là bên không có mappedBy.![image](https://github.com/user-attachments/assets/c5b9a326-2164-4089-ac4c-5ac7e9fe613c)

- Cascade Operations
  + là tập các hành vi tự động truyền tác động từ entity cha sang entity con. Nó giúp bạn đơn giản hóa logic xử lý entity liên kết, đặc biệt khi tạo, cập nhật, hoặc xóa dữ liệu liên quan.
  + **Cascade thường được đặt ở phía chủ sở hữu (owning side) của mối quan hệ trong JPA.**
  + ![image](https://github.com/user-attachments/assets/89afe405-cf12-4513-8724-f4825280709c)
  + ![image](https://github.com/user-attachments/assets/e9c760e2-7719-48e3-9d41-7d0d93921735)
  + PERSIST: Lưu cả entity cha và con vào cơ sở dữ liệu.
  + MERGE: Cập nhật cả entity cha và con.
  + REMOVE: Xóa cả entity cha và con.
  + REFRESH: Tải lại cả entity cha và con.
  + ALL: Tất cả các hành động trên cha cũng áp dụng cho con.
  + DETACH: Ngừng quản lý đối tượng, không tự động lưu thay đổi nữa.
 
- Fetch Types:
  + EAGER: Mặc định sẽ tải dữ liệu liên kết ngay lập tức khi truy vấn entity chính.
  + LAZY: Chỉ tải dữ liệu liên kết khi cần thiết (khi truy xuất các thuộc tính liên quan).![image](https://github.com/user-attachments/assets/1bc899c4-436e-45b4-8551-59bb4391a18c). Khi chúng ta thực hiện List<Child> children = parent.getChildren();  thì lúc đó sẽ có 1 truy vấn thực hiện để lấy thằng con.
  + ![image](https://github.com/user-attachments/assets/1dcb7bb9-49c1-43ad-9aee-a3d51ccc4227)



- OrphanRemoval: dùng để tự động xóa các entity con không còn liên kết với entity cha
 + Khi có @OrphanRemoval = true: Nếu bạn gỡ bỏ một Child khỏi danh sách children của Parent (ví dụ, trong phương thức removeChildFromParent), Child đó sẽ tự động bị xóa khỏi cơ sở dữ liệu.
 + Khi không có @OrphanRemoval: Nếu bạn gỡ bỏ một Child khỏi danh sách children của Parent, Child vẫn sẽ tồn tại trong cơ sở dữ liệu và bạn cần gọi remove thủ công để xóa nó.

- Lỗi N+1
  + Giả sử bạn có 2 bảng Parent và Child, và mối quan hệ giữa chúng là OneToMany. Mỗi Parent có nhiều Child.
  + Ở đây, truy vấn đầu tiên lấy danh sách tất cả các Parent. Sau đó, đối với mỗi Parent, một truy vấn riêng biệt được thực hiện để lấy các Child của Parent đó.
  + Nếu có 100 Parent, sẽ có 1 truy vấn đầu tiên để lấy tất cả các Parent, và 100 truy vấn phụ để lấy các Child cho từng Parent, tức là tổng cộng 101 truy vấn.
  +  => Hiệu suất thấp, Giao tiếp nhiều lần với cơ sở dữ liệu
  +  Các fix: dùng FetchType.LAZY,JOIN FETCH, @EntityGraph
  +  JOIN FETCH JOIN FETCH kết hợp các bảng trong cơ sở dữ liệu và tải dữ liệu liên kết trong một truy vấn duy nhất. Điều này có nghĩa là các đối tượng con sẽ được tải kèm với đối tượng cha mà không phải thực hiện truy vấn bổ sung cho mỗi đối tượng con.![image](https://github.com/user-attachments/assets/9bf2742c-c17f-46bd-a526-a92cd38157d7)
  +  @EntityGraph: @EntityGraph là một tính năng trong JPA cho phép bạn chỉ định các thuộc tính hoặc mối quan hệ nào của entity sẽ được tải khi truy vấn, giúp tối ưu hóa truy vấn dữ liệu liên kết và tránh lỗi N+1. Với @EntityGraph, bạn có thể chọn tải các mối quan hệ cụ thể mà không cần phải viết truy vấn JPQL hoặc HQL thủ công. ![image](https://github.com/user-attachments/assets/67da2b1c-93e4-4e62-92b2-ccacfbe18a16)


**6.4 Composite Key**
- Composite Key là một khóa chính (primary key) được tạo từ nhiều hơn một cột (field/thuộc tính).
- Dùng khi không có một cột duy nhất nào đủ để xác định một bản ghi mà cần kết hợp nhiều cột lại.
- Có 2 các để thể hiện trong code.
  + Dùng @IdClass: Step 1 tạo class chứa các trường FK ![image](https://github.com/user-attachments/assets/9f4a2362-f1ee-4ca2-9247-10d030251ddb) và trong entity dùng @IdClass ![image](https://github.com/user-attachments/assets/67d248c6-d598-41ee-b1bb-5865cc9319b9)
  +  Dùng @EmbeddedId và @Embeddable: Gói các trường khóa chính trong một object có annotation @Embeddable. ![image](https://github.com/user-attachments/assets/fbbda371-cc18-4228-bb17-d22fb7eb055a). Entity chính dùng @EmbeddedId.![image](https://github.com/user-attachments/assets/f42fbc75-ae69-4d78-9243-60d2efa51b44) Khi query cần phải chuyền cả object khóa ![image](https://github.com/user-attachments/assets/7852c162-4942-4a66-a3b9-cd8961f6cfe3)
- Dùng @MapsId để map đến composite key trong entity khác ![image](https://github.com/user-attachments/assets/be351828-9df3-4e47-9a7b-2df943e5d874)

**6. DTO Projection & Custom Result Mapping**

***6.5.1 Interface-based DTO Projection**
- Là cách sử dụng interface để khai báo các thuộc tính cần lấy từ Entity, sau đó Spring Data JPA sẽ tự động map dữ liệu từ kết quả truy vấn (query result) vào các phương thức getter trong interface đó.
- VD:
  + ![image](https://github.com/user-attachments/assets/360ea6de-ee4a-4702-af64-8b0f5c056eda)
  + ![image](https://github.com/user-attachments/assets/9dcd5ace-9202-415d-919f-c695341ab986)
  + ![image](https://github.com/user-attachments/assets/a6047f6f-2edc-4e3c-ba45-6651b653e943)
  + ![image](https://github.com/user-attachments/assets/7be077e8-064e-45d2-a366-99b92fdbd3c2)
 - Không dùng cho các filed phức tạp (List, map..
- Dùng cho cả native ![image](https://github.com/user-attachments/assets/3c5d044f-959e-4d7d-b2bd-a2d337756e6e)




***6.5.2 Class-based DTO Projection**
- Dùng contructor của class ![image](https://github.com/user-attachments/assets/92e5d9b2-9740-49e5-9cae-8319bfe2662d)


***6.5.3 Native Query + Class-based DTO + @SqlResultSetMapping**
- @SqlResultSetMapping là một annotation của JPA (không phải riêng Spring), được dùng để mapping kết quả từ truy vấn SQL thuần (native query) sang DTO hoặc Entity.

***6.5.4 JPQL hoặc Native Query + Tuple hoặc Object[]**
- Dữ liệu trả ra là Object[] (hoặc Stream[]) ![image](https://github.com/user-attachments/assets/831099fc-c5d1-4c77-aa86-8bc9ddc71c62)
- Chúng ta khải tạo 1 class DTO chứa các trường cần lấy, phải có contructor ![image](https://github.com/user-attachments/assets/de29c495-bc6e-429e-9f02-d3306d2f48b8)
- Trong Entity map tới class DTO mới tạo: map đúng contructor ![image](https://github.com/user-attachments/assets/5916bad4-5eac-4d30-b83e-5264440544c6)
- Chúng ta phải dùng EntityManager để gọi: entityManager.createNativeQuery(sql, resultSetMappingName);


***6.5.5 Projection bằng Spring Data JPA Dynamic Projections**

***6.5.6 Native Query + ResultTransformer (Hibernate-specific)**

**6.6 Native Query vs JPQL**
- JPQL: Ngôn ngữ truy vấn giống SQL nhưng hoạt động trên Entity
  + Hạn chế – không hỗ trợ đầy đủ như SQL
- native: SQL thuần (tùy DBMS: MySQL, PostgreSQL, Oracle...)
  + linh hoạt cao, 	Cao – hỗ trợ mọi cú pháp SQL đặc biệt, truy vấn phức tạp thì dùng cái này.
  + Phải dùng @SqlResultSetMapping hoặc ResultTransformer

**6.7 Pagination & Sorting**
- Dùng Pageable, truyền trực tiếp vào query: ![image](https://github.com/user-attachments/assets/43d5b6ef-96ee-4b54-bc9c-abc731dc45f5) ![image](https://github.com/user-attachments/assets/12caaf45-13f5-46e0-856a-a802f8c84ad4) ![image](https://github.com/user-attachments/assets/bf361fe5-2720-4d7d-8728-b3b3359f97cb)



**6.8 Auditing**
- Cơ chế tự động ghi nhập lịch sử
- Các annotation chính:
  + @CreatedDate Ngày tạo bản ghi
  + @LastModifiedDate Ngày cập nhật cuối
  + @CreatedBy Người tạo bản ghi
  + @LastModifiedBy Người sửa cuối cùng
- Các bước thực hiện
  + Tạo class JpaAuditingConfig để bật tính năng auditing của JPA và chỉ định AuditorAware để lấy thông tin người dùng. ![image](https://github.com/user-attachments/assets/014e7beb-fb88-4099-93c5-7e059fb4387f)
  + Tạo class AuditorAwareImpl implement AuditorAware<String> để lấy tên người dùng hiện tại từ SecurityContext.![image](https://github.com/user-attachments/assets/4aa70620-b0d8-4cf1-b422-0856213ce7a2)
  + Tạo Entity với Auditing ![image](https://github.com/user-attachments/assets/11d33d44-0490-4b00-9392-3a5c333b546e)
  + Khi sử dụng @CreatedDate và @LastModifiedDate, bạn không cần phải cấu hình thủ công về ngày giờ. JPA Auditing sẽ tự động điền vào các trường này mà không cần bạn phải can thiệp.



**6.9 Transaction**
- Spring cung cấp một cách rất thuận tiện để làm việc với transaction thông qua Spring Transaction Management. Nó hỗ trợ bạn đảm bảo rằng các thay đổi trong cơ sở dữ liệu sẽ chỉ được lưu lại khi giao dịch thành công.
- Có thể sử dụng thông qua  @Transactional hoặc code java PlatformTransactionManager ![image](https://github.com/user-attachments/assets/d1001a0a-aa35-4148-a82d-161d0b61ec30)

***6.9.1 Propagation trong Spring**
- nó quyết định xem giao dịch có được tiếp tục, chuyển tiếp, tạo mới hay không tham gia vào giao dịch hiện tại.
- REQUIRED (Mặc định):  Nếu có một giao dịch đang hoạt động, phương thức sẽ tham gia vào giao dịch đó ![image](https://github.com/user-attachments/assets/c486bd97-3a48-431b-a869-1ceb0cea4e0f)
- REQUIRES_NEW: Giả sử bạn đang thực hiện một giao dịch chuyển tiền và cần ghi lại lịch sử giao dịch. Khi gọi phương thức lưu lịch sử giao dịch, phương thức đó sẽ bắt đầu một giao dịch mới, không liên quan đến giao dịch chuyển tiền. **=> trong spring khi dùng thằng này thì cần tách ra 1 repository mới  nha, thằng này nó độc lập ko sợ thằng cha bị rollback**
- NESTED: Đảm bảo thằng con lỗi thì ko ảnh hưởng tới thằng cha, nhưng cha thì rollback cả con. 
- SUPPORTS: ko có nhiều ỹ nhĩa dùng cho real, tạo transaction nếu cần
- MANDATORY: Phương thức này yêu cầu giao dịch đã tồn tại và không cho phép chạy nếu không có giao dịch.
- NOT_SUPPORTED: Dùng khi bạn cần thực thi phương thức trong một chế độ không giao dịch, dù có một giao dịch cha.
- NEVER: Dùng khi bạn chắc chắn phương thức không cần giao dịch và không muốn giao dịch nào được bắt đầu.

***6.9.1 Isolation trong Spring**
- Isolation (cô lập giao dịch) quy định mức độ “cô lập” của một giao dịch so với các giao dịch khác, tức là nó kiểm soát giao dịch hiện tại có thể nhìn thấy dữ liệu chưa commit từ các giao dịch khác không. ![image](https://github.com/user-attachments/assets/3644dedf-0b08-44ed-94f0-bd4461c10e6d)

- DEFAULT: Dùng mức mặc định của DB (thường là READ_COMMITTED với H2, MySQL)
- READ_UNCOMMITTED: Cho phép đọc dữ liệu chưa commit từ giao dịch khác → nguy hiểm
- READ_COMMITTED: Chỉ đọc được dữ liệu đã commit → ngăn Dirty Read
- REPEATABLE_READ: 	Giữ nguyên kết quả truy vấn trong cùng một giao dịch → ngăn Non-Repeatable Read
- SERIALIZABLE: Cô lập tối đa, các giao dịch phải chạy tuần tự → an toàn nhất nhưng hiệu suất thấp
**6.10 Validation & Constraint**

**6.11 Locking**
- Trong JPA/Spring Data, Locking (khóa) là cơ chế để đồng bộ truy cập đến dữ liệu giữa các giao dịch, giúp tránh xung đột và đảm bảo nhất quán dữ liệu khi có nhiều người dùng hoặc luồng truy cập cùng lúc.
- Có 2 loại lock chính: Optimistic Lock và Pessimistic Lock
- ![image](https://github.com/user-attachments/assets/1ca35152-7f3f-488e-8280-60f7cdcdc77b)

***6.11.1 Optimistic Lock***
- Không khóa dữ liệu ngay. => Khi cập nhật, JPA sẽ kiểm tra phiên bản (@Version) để biết dữ liệu có bị thay đổi bởi giao dịch khác không. => Nếu có xung đột → ném OptimisticLockException.
- Thêm trường @Version ![image](https://github.com/user-attachments/assets/8d0c1dea-c792-4bc2-bb55-57678b69cba1)

***6.11.2 Pessimistic Lock***
- Khi đọc dữ liệu, JPA gửi SQL có câu lệnh FOR UPDATE (tùy loại lock), để khóa dòng dữ liệu. Các giao dịch khác sẽ bị đợi hoặc bị lỗi nếu muốn truy cập dòng đó.
- ![image](https://github.com/user-attachments/assets/5bac173b-1474-4d29-a7ad-8300142929fa)
- ![image](https://github.com/user-attachments/assets/874d0006-479d-46ca-9e94-0d104d634736)

 
**6. Migration Tool (Optional): Flyway / Liquibase/ mybatis**




