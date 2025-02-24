# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Khái quát spring
3. Dependency Injection (DI)
4. Inversion of Control (IoC)
5. ApplicationContext & Bean Factory
6. Event & Listener
7. AOP (Aspect-Oriented Programming)
8. Spring Transactions
9. Spring Profiles & Configuration
10. Spring Bean Customization
11. Spring Context Refresh & Lazy Initialization
12. Spring mvc.


# **------ Nội dung chi tiết ------**

## *** 1. Tài liệu tham khảo ***
- https://docs.spring.io/spring-framework/reference/core.html
- https://www.digitalocean.com/community/tutorials/spring-tutorial-spring-core-tutorial

## *** 2. Khái quát spring ***
**2.1 Các thành phần chính**
- Spring Core (Spring IoC): Cung cấp Dependency Injection (DI) và Inversion of Control (IoC).
- Spring AOP: Hỗ trợ lập trình hướng khía cạnh (Aspect-Oriented Programming).
- Spring Data: Tích hợp với các cơ sở dữ liệu như JPA, JDBC, MongoDB.
- Spring MVC: Framework giúp xây dựng ứng dụng web theo mô hình MVC.
- Spring Security: Cung cấp xác thực (authentication) và phân quyền (authorization).
- Spring Boot: Giúp đơn giản hóa việc cấu hình ứng dụng Spring, đi kèm với các "starter" để tích hợp nhanh với các công nghệ khác.
- Spring Batch: Hỗ trợ xử lý batch jobs trong Java.
- Spring Cloud: Cung cấp các công cụ để xây dựng ứng dụng microservices.

**2.2 Các khái niện quan trọng trong spring**
- Dependency Injection (DI) & Inversion of Control (IoC): Spring dùng DI để quản lý sự phụ thuộc giữa các đối tượng. Thay vì tự khởi tạo đối tượng, Spring container sẽ inject dependencies giúp code dễ bảo trì hơn.
- Spring Bean & ApplicationContext: Bean là các đối tượng do Spring quản lý. ApplicationContext là container quản lý vòng đời của Bean.
- Spring AOP (Aspect-Oriented Programming): Dùng để tách biệt các logic phụ như logging, transaction, security bằng cách sử dụng Aspect.
- Transaction Management: Spring hỗ trợ quản lý transaction bằng @Transactional.
- Spring MVC: Xây dựng ứng dụng web
- Spring Boot: Spring Boot giúp đơn giản hóa cấu hình ứng dụng bằng cách cung cấp starter dependencies, auto-configuration, và embedded server.

## *** 3. Dependency Injection (DI) ***
**3.1 Khái niệm**
-
