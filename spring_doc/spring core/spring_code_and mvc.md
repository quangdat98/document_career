![image](https://github.com/user-attachments/assets/347858f9-d46a-4d7a-9283-d84d734ca7b1)# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Khái quát spring
3. Inversion of Control (IoC)
4. Dependency Injection (DI)
5. Bean
6. ApplicationContext & Bean Factory
7. Event & Listener
8. AOP (Aspect-Oriented Programming)
9. Spring Transactions
10. Spring Profiles & Configuration
11. Spring Bean Customization
12. Spring Context Refresh & Lazy Initialization
13. Spring mvc.


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

## ***5. Bean***
**5.1. Định nghĩa bean**
- **là một đối tượng (object) được quản lý bởi Spring IoC (Inversion of Control) container. Đây thường là các instance của các class được cấu hình để Spring khởi tạo, quản lý vòng đời, và tiêm phụ thuộc (dependency injection).**
- Bean là đơn vị cơ bản trong ứng dụng Spring, đại diện cho các thành phần như services, repositories, controllers, hoặc bất kỳ đối tượng nào cần được quản lý.
- Các ỹ nghĩa của bean:
  + Quản Lý Vòng Đời Đối Tượng Tự Động (khởi tạo (@PostConstruct) và dọn dẹp (@PreDestroy))
  + Tăng Tính Tái Sử Dụng (Reusability): bean có thể được sử dụng nhiều nơi thay vì tạo nhiều instance mới
  + Giảm Bớt Sự Phụ Thuộc Chặt Chẽ: do có hỗ trợ Dependency Injection (DI) thay vì new Object().
  + Quản lý phạm vi(scope) của bean
**5.2 Khởi tạo bean**
- Có ba phương pháp quan trọng để cung cấp siêu dữ liệu cấu hình cho Spring IoC Container:
  + Tệp tin cấu hình dựa trên XML. ![image](https://github.com/user-attachments/assets/719b6c8f-d9af-447c-8a12-7a0da6f40ddf)
  + Định nghĩa Bean bằng Java Configuration (@Configuration) ![image](https://github.com/user-attachments/assets/a838eeeb-d843-4e01-b041-2973d5b5a898)
  + Định nghĩa Bean bằng Annotation Configuration: @Component, @Service, @Repository, @Controller
  
**5.3 scope**
- singleton (default) : Một bean duy nhất được tạo trong toàn bộ spring container - Dùng cho Service, Repository, Component dùng chung, Ví dụ: Kết nối Database, Logger, Cache Manager
  + ![image](https://github.com/user-attachments/assets/3db36ad1-77b0-43bd-a953-3c21ac1c303b)
  + ![image](https://github.com/user-attachments/assets/23d33faa-e879-4270-a756-bac43be045b2)

- prototype: mỗi lần request sẽ tạo 1 instance mới -Khi bạn cần một bean chỉ sử dụng một lần rồi bỏ đi, không cần tái sử dụng, chẳng hạn trong các tác vụ xử lý dữ liệu tạm thời hoặc tạo các đối tượng kết quả (result objects).
  + ![image](https://github.com/user-attachments/assets/401ab4f9-5a7d-42e7-99b1-d01befa09071)
  + ![image](https://github.com/user-attachments/assets/f210fb4f-6906-4dc5-a75a-62857b508d1c)

- Request: Tạo một instance mới cho mỗi HTTP reques - Dùng cho Controller hoặc Service cần xử lý dữ liệu mỗi request khác nhau. ví dụ như cần tracker thông tin các request gửi tới
- Session: Tạo một instance cho mỗi HTTP session (Duy trì xuyên suốt session của user) - Lưu thông tin đăng nhập, giỏ hàng của user
- Application: Nó tương tự như scope singleton, nhưng khác ở chỗ nó được gắn với ServletContext thay vì Spring ApplicationContext. Bean này tồn tại xuyên suốt vòng đời của ứng dụng web và được chia sẻ giữa tất cả các session, request, và người dùng.
  + ![image](https://github.com/user-attachments/assets/3a8d5942-f2fc-4ad6-a1f4-702c2ec44e09)

**5.3 Lifecycle Hooks**

## ***6. ApplicationContext & Bean Factory***
- https://www.geeksforgeeks.org/spring-beanfactory/
**6.1. BeanFactory**
- BeanFactory là một thành phần cốt lõi trong Spring Framework, đóng vai trò như một container quản lý các đối tượng (beans) trong ứng dụng. Nó chịu trách nhiệm khởi tạo, cấu hình, và cung cấp các beans khi cần thiết.
- BeanFactory là container cơ bản và gốc rễ trong Spring Framework. Nó cung cấp các chức năng cốt lõi để:
  + Quản lý bean: Tạo, cấu hình, và cung cấp bean khi cần.
  + Dependency Injection (DI): Tiêm các phụ thuộc vào bean.
  + Quản lý vòng đời: Khởi tạo, sử dụng, và hủy bean.
- Dùng xml(XmlBeanFactory (Đã bị deprecated)) để config beanFactory. ![image](https://github.com/user-attachments/assets/2aa451b3-4526-4242-8027-a8a24d76bc3c)
- Trong Spring boot thì chúng ta có interface BeanFactory
- BeanFactory chỉ cung cấp các phương thức cơ bản để quản lý bean mà không hỗ trợ các tính năng nâng cao như ApplicationContext (ví dụ như quét @Component, @Service.. để nhận biết đó là 1 bean). (chúng ta có thể xem các phương thức ở interface)
- DefaultListableBeanFactory và DefaultListableBeanFactory đọc cấu hình từ file xml ![image](https://github.com/user-attachments/assets/274573dd-a512-4727-b92b-6511cac20fbc)
- AutowireCapableBeanFactory là một cơ chế trong Spring giúp bạn inject dependencies vào một object mà Spring không quản lý. Chúng ta có thể dùng để inject 1 thư viện mà spring ko quảng lý
  +  ![image](https://github.com/user-attachments/assets/f8400bd4-218a-4c57-965d-3bef27bae2aa)
  +  ![image](https://github.com/user-attachments/assets/a95971b5-2778-4c72-8e4c-83308dd883fe)
  +  ![image](https://github.com/user-attachments/assets/6d9a164a-323b-4486-8637-40b09ff16205)

- Lifecycle của Bean trong BeanFactory








