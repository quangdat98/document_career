![image](https://github.com/user-attachments/assets/347858f9-d46a-4d7a-9283-d84d734ca7b1)# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Khái quát spring
3. Inversion of Control (IoC)
4. Dependency Injection (DI)
5. ApplicationContext & Bean Factory
6. Event & Listener
7. AOP (Aspect-Oriented Programming)
8. Spring Transactions
9. Spring Profiles & Configuration
10. Spring Bean Customization
11. Spring Context Refresh & Lazy Initialization
12. Spring mvc.


# **------ Nội dung chi tiết ------**

## ***1. Tài liệu tham khảo***
- https://docs.spring.io/spring-framework/reference/core.html
- https://www.digitalocean.com/community/tutorials/spring-tutorial-spring-core-tutorial

## ***2. Khái quát spring***
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

## ***3. Inversion of Control (IoC)***
**3.1 Khái niệm**
- Là một nguyên tắc trong lập trình giúp đảo ngược quyền kiểm soát của chương trình. Thay vì một class tự quản lý sự khởi tạo và vòng đời của dependencies, nó sẽ được cung cấp từ bên ngoài (thông qua Dependency Injection hoặc các IoC Container như Spring).
- Các cách thực hiện IOC:
  + Dependency Injection (DI) – Inject dependencies thông qua Constructor, Setter hoặc Field.
  + Service Locator – Một đối tượng trung tâm cung cấp dependencies.
  + Factory Pattern – Một factory tạo đối tượng thay vì tự khởi tạo.
  + Event-driven Architecture – Xử lý sự kiện thay vì gọi trực tiếp các phương thức.

**3.2 Dependency Injection (DI)**
- ![image](https://github.com/user-attachments/assets/c561a850-793d-479d-8d8f-f0c050e33430)
- ![image](https://github.com/user-attachments/assets/da312854-f379-4276-a831-637d69f4b1b1)
- ![image](https://github.com/user-attachments/assets/889350ed-58e4-4330-be61-704416a4e917)
- =>> Điều quan trọng là khi đổi từ Old sang New chúng ta không phải sửa code

**3.3 IoC Container trong Spring**
- **IoC Container trong Spring chính là lõi của Spring Framework. IoC Container sẽ tạo ra các đối tượng, nối chúng lại với nhau, cấu hình chúng, và quản lý vòng đời của chúng từ khi tạo ra đến khi bị hủy. IoC Container sử dụng DI (Dependency Injection) để quản lý các thành phần tạo nên một ứng dụng. Những đối tượng này được gọi là Spring Bean**
- **Bean là 1 object dk khởi tạo lắp ráp và sử dụng bởi một Spring IoC container**
- IoC Container giúp:
  + Tạo (Instantiate) Bean.
  + Quản lý dependencies giữa các Bean.
  + Cung cấp Bean khi cần mà không cần lập trình viên tự khởi tạo.
- Các loại Ioc container trong spring:
  + BeanFactory (Cơ bản, nhẹ, ít dùng)
  + ApplicationContext (Mạnh mẽ, hay dùng nhất)

## ***4. Dependency Injection (DI)***
**4.1 Khái niện**
- Dependency Injection (DI) là một mẫu thiết kế (design pattern) thuộc nhóm Inversion of Control (IoC), giúp giảm sự phụ thuộc giữa các thành phần trong ứng dụng bằng cách cung cấp dependencies từ bên ngoài, thay vì để một lớp tự khởi tạo chúng.
**4.2 Các cách thực hiện DI trong java**
- Constructor Injection (Khuyến khích)
- Setter Injection
- Field Injection (Không khuyến khích)
**4.3 Constructor Injection**
- inject dependency thông qua constructor. spring sẽ tự động khởi tạo và inject dependency khi tạo instance.![image](https://github.com/user-attachments/assets/6ff520ed-b507-41cb-9031-1241e012113b)

- ưu điểm:
  + Bất biến (Immutability): Dependency được inject ngay từ đầu và không thể thay đổi.
  + Dễ kiểm tra (Testability): Hỗ trợ Unit Test tốt hơn.
  + Phù hợp với Spring Boot @RequiredArgsConstructor.
  + Tránh NullPointerException: Không cần kiểm tra null.
- Nhược điểm:
  + Vấn đề với nhiều dependency: Nếu class có quá nhiều dependency, constructor có thể trở nên quá tải.
**4.4 Setter Injection**
- Inject dependency thông qua phương thức setter. ![image](https://github.com/user-attachments/assets/bb64fe80-0969-4b0f-ab2d-f49fa25bd7d9)
- ![image](https://github.com/user-attachments/assets/46407d49-91e5-4a97-895c-3dc746718965)
- Khi dùng spring thì chúng ta có @Autowired đây là chú thích đánh dấu cần được inject để spring biết và thực hiện mà chúng ta không cần gọi hàm set ![image](https://github.com/user-attachments/assets/31813420-0d06-43ee-b14c-e327d970cd83)
**4.5 Field Injection**
- Đây là cách phổ biến nhất nhưng không khuyến khích vì:
  + Không thể làm bất biến (Immutable).
  + Khó debug khi có nhiều dependency.
  + Vi phạm nguyên tắc SOLID: Class phụ thuộc trực tiếp vào framework.
**4.6 so sánh giữa các kiểu**
- ![image](https://github.com/user-attachments/assets/17dd3ddc-7b07-4199-b57c-9080886313dc)
**4.7 DI trong spring**
- Spring quản lý DI thông qua IoC Container (thường là ApplicationContext), chịu trách nhiệm:
  + Tạo và lưu trữ bean: Các đối tượng (bean) được Spring quản lý thay vì bạn tự tạo bằng new.
  + Inject dependency: Tự động cung cấp dependency cho các bean dựa trên cấu hình.
  + Quản lý vòng đời: Điều khiển từ lúc khởi tạo, inject, sử dụng, đến khi bean bị hủy.
- **Định nghĩa bean**: Bạn khai báo bean bằng annotation (@Component, @Service, @Repository, @Bean, v.v.) hoặc cấu hình XML/Java Config.
- **Quét và đăng ký**: Khi ứng dụng khởi động, Spring quét các class (thường trong các package được chỉ định) để tìm bean. Các bean này được đăng ký vào IoC Container.
- **Inject dependency**: Spring phân tích các điểm cần inject (constructor, setter, hoặc field có @Autowired).Nó tìm bean phù hợp trong container (dựa trên type hoặc @Qualifier) và inject vào.
- **Quản lý vòng đời:**: Spring đảm bảo bean được khởi tạo đúng thứ tự (dependency trước, dependent sau).Nếu bean không còn cần thiết (scope phù hợp), Spring sẽ hủy nó.

## ***5. ApplicationContext & Bean Factory***






