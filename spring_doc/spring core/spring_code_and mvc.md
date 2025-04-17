# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Khái quát spring
3. Inversion of Control (IoC)
4. Dependency Injection (DI)
5. Bean
6. ApplicationContext & Bean Factory
7. AOP (Aspect-Oriented Programming)
8. Spring Transactions
9. Spring Bean Customization && Configuration
10. Spring Context Refresh & Lazy Initialization
11. Spring mvc.
12. spring cache


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
- Là quá trình khời tạo và phá hủy bean. Chúng cho phép thực hiện các thao tác như thiết lập tài nguyên hoặc giải phóng tài nguyên bean bị hủy
- **@PostConstruct**: được gọi sau khi bean được khởi tạo và dependencies được inject.
- **afterPropertiesSet()** (bean phải implement  từ interface InitializingBean)
  + Được gọi sau khi tất cả các thuộc tính của bean được thiết lập
  + ![image](https://github.com/user-attachments/assets/a749154e-fbe7-48e0-9f33-4cdf0cc02dc6)
- init-method (Khai báo trong XML hoặc annotation @Bean): chỉ định một phương thức khởi tạo trong file cấu hình. ![image](https://github.com/user-attachments/assets/8eb3b47e-a591-40b3-99db-93388a0ad89f)
- **@PreDestroy**: được gọi trước khi bean bị phá hủy giúp giải phóng tài nguyên
- **destroy()** (Từ DisposableBean interface): Được gọi khi Bean bị hủy, tương tự @PreDestroy.![image](https://github.com/user-attachments/assets/fcfbf4b9-69fc-40ae-b3de-2b32cefc0547)
- destroy-method (Khai báo trong XML hoặc annotation @Bean): Chỉ định một phương thức để giải phóng tài nguyên. ![image](https://github.com/user-attachments/assets/b2c1f772-0fbe-47a2-bcf4-9a824c500617)
- Các chú ý quan trọng:
  + Ưu tiên sử dụng @PostConstruct và @PreDestroy, vì chúng là tiêu chuẩn Java và không phụ thuộc vào Spring.
  + InitializingBean và DisposableBean ràng buộc Bean với Spring, không linh hoạt bằng annotations.
  + init-method và destroy-method hữu ích nếu bạn không thể sửa đổi class để thêm annotations.

## ***6. ApplicationContext & Bean Factory***
- https://www.geeksforgeeks.org/spring-beanfactory/
**6.1. BeanFactory**
- BeanFactory là một thành phần cốt lõi trong Spring Framework, đóng vai trò như một container quản lý các đối tượng (beans) trong ứng dụng. Nó chịu trách nhiệm khởi tạo, cấu hình, và cung cấp các beans khi cần thiết (Lazy loading).
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
  + https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/

**6.2 ApplicationContext**
- ApplicationContext là Spring's IoC container mở rộng từ BeanFactory, cung cấp nhiều tính năng bổ sung như:
  + Quản lý lifecycle của Bean
  + Hỗ trợ event publishing
  + Tích hợp với AOP, Transaction, Resource Loading
  + Hỗ trợ internationalization (i18n)
  + ApplicationEvent & ApplicationListener
- Eager loading (Tạo bean ngay khi context khởi động)
- Các Implementation chính của ApplicationContext: ![image](https://github.com/user-attachments/assets/b81cb0e3-1596-4c4a-bf08-8a9c45683392)
- Các Method Quan Trọng trong ApplicationContext: ![image](https://github.com/user-attachments/assets/90e0592d-4f7e-4d23-aea5-c1a1167edf87)
- **Event Handling**: Spring hỗ trợ event-driven programming, giúp các component có thể giao tiếp với nhau một cách loose coupling (lỏng lẻo).
  + Chúng ta sẽ tạo một sự kiện tùy chỉnh bằng cách kế thừa ApplicationEvent. ![image](https://github.com/user-attachments/assets/b60f9217-5f06-4a89-84a4-f5b860c0d383)
  + Tạo một Event Listener: Lớp này sẽ lắng nghe sự kiện OrderCreatedEvent và thực hiện hành động khi sự kiện xảy ra. ![image](https://github.com/user-attachments/assets/0280b1ee-b2d2-4fda-8888-26be9af8aefb)
  + Phát sự kiện (Publish Event): ApplicationEventPublisher giúp phát sự kiện đến tất cả các listener đã đăng ký.![image](https://github.com/user-attachments/assets/f0f64264-cc07-4997-b1d0-137e815f89b6)
  + Main: ![image](https://github.com/user-attachments/assets/16214c42-cc44-42f9-b327-60a10331fa9c)![image](https://github.com/user-attachments/assets/6018d58c-f34f-49d9-b142-ae5ab0ffa7f5)
  + => khi bạn chạy eventPublisher.publishEvent(new OrderCreatedEvent(this, orderId)). Spring sẽ tìm ìm kiếm tất cả các @EventListener lắng nghe OrderCreatedEvent và thực thi.
- Profile trong Spring giúp phân tách cấu hình dựa trên môi trường như dev, test, prod, v.v.
  + Kích hoạt profile bằng file config: Dùng application.properties hoặc application.yml => spring.profiles.active=dev
  + Dùng tham số JVM khi chạy ứng dụng: java -jar myapp.jar --spring.profiles.active=prod
  + Dùng annotation @ActiveProfiles (cho test): ![image](https://github.com/user-attachments/assets/60d60dd3-934f-4812-a776-7aa12cb3d1ef)
  + Dùng @Profile để chỉ định một bean chỉ được tạo khi profile tương ứng được kích hoạt ![image](https://github.com/user-attachments/assets/2687cf07-fbfd-489a-928c-05522d028a8f)
- Environment: trong Spring giúp truy xuất thông tin cấu hình như biến môi trường hệ thống, các thuộc tích trong file application
  + @Value để inject giá trị: ![image](https://github.com/user-attachments/assets/66e4f066-de45-4b9c-997a-9317d05edb29)
  + Dùng Environment để truy xuất thông tin (import org.springframework.core.env.Environment;) ![image](https://github.com/user-attachments/assets/288d0064-e3be-4234-b160-8a846e90a869)
  + @ConfigurationProperties ![image](https://github.com/user-attachments/assets/bbb8f2b8-c734-4ace-9124-78cfcac2cfea)
- Refresh & Restart
- i18n: i18n (Internationalization) giúp hỗ trợ đa ngôn ngữ và đa định dạng, phù hợp với người dùng ở các khu vực khác nhau.
  + Spring sử dụng MessageSource để quản lý các file ngôn ngữ (.properties hoặc .yml).
  + Tạo file ngôn ngữ (messages_*.properties)
  + ![image](https://github.com/user-attachments/assets/bf4d061c-36c9-43fe-8f4e-2ddf3b6c2098)
  + Cấu hình application.properties: ![image](https://github.com/user-attachments/assets/97430aab-5fdc-462c-9134-02e739c5a968)
  + Cấu hình trong java: ![image](https://github.com/user-attachments/assets/6b3f6f22-81b6-4555-996e-4ccb246c35ba)
  + ResourceBundleMessageSource: Là một implement của MessageSource trong Spring để quản lý i18n.Đọc message từ file .properties trong src/main/resources. Không hỗ trợ reload file khi ứng dụng đang chạy. Mặc định sử dụng ISO-8859-1 (phải chuyển sang UTF-8 nếu dùng tiếng Việt). ![image](https://github.com/user-attachments/assets/f9897e8d-93a5-4c1b-8ea8-4247089ecee8)![image](https://github.com/user-attachments/assets/cc983a8c-3563-4f6a-9bef-0385aa29232f)


  + ReloadableResourceBundleMessageSource:  Giống ResourceBundleMessageSource nhưng có thể reload file i18n khi ứng dụng đang chạy.Cho phép cấu hình cache timeout, giúp tự động cập nhật message sau một khoảng thời gian.![image](https://github.com/user-attachments/assets/6af9d0a1-0411-4f86-99de-a03eb6f96888)

  + AcceptHeaderLocaleResolver: Dùng để xác định ngôn ngữ (locale) dựa trên HTTP Accept-Language header gửi từ client. Khác với CookieLocaleResolver và SessionLocaleResolver, nó không lưu locale trong session hoặc cookie.
    + Từ giá trị Locale locale lấy được từ controller -> sử dụng MessageSource để lấy giá trị message: messageSource.getMessage("param_1", new Object[]{name}, locale); (Nhớ phải cấu hình messageSource trước VD ![image](https://github.com/user-attachments/assets/e9ad98ea-fa42-41fb-9175-1858cc872ab7) ![image](https://github.com/user-attachments/assets/95c454b5-d103-459a-9892-854581ac0014)
)
    + Trường hợp ko muốn dùng locale thì chúng ta tự truyền biến &lang=vi"
   
## *** 7. AOP (Aspect-Oriented Programming) ***

**7.1 Khái niệm**
- AOP là gì?: AOP là một phương pháp lập trình bổ sung cho OOP (Object-Oriented Programming), tập trung vào việc tách biệt các mối quan ngại chéo (cross-cutting concerns) như logging, security, transaction management ra khỏi logic chính của ứng dụng.

**7.2 Các thuật ngữ quan trọng**
- Aspect
- Join Point
- Advice
  + Before
  + After
  + After Returning
  + After Throwing
  + Around
- Pointcut
- Target Object
- Weaving

**7.3 ứng dụng trong thực tế**
- Logging: Ghi log trước/sau khi thực thi method.
- Transaction Management: Tự động quản lý transaction (Spring đã tích hợp sẵn với @Transactional).
- Security: Kiểm tra quyền truy cập trước khi gọi method.
- Caching: Tích hợp với @Cacheable hoặc tự viết caching logic.
- Exception Handling: Xử lý ngoại lệ tập trung thay vì rải rác trong code.

**7.4 AspectJ**


## *** 8. Spring Transactions ***

## *** 9. Spring Bean Customization & Configuration ***
- @Configuration
- @ComponentScan
- @PropertySource
- @Import
- @Lazy
- Annotation khác: @Primary,@Conditional,@Profile,@DependsOn
- 
## *** 10. Spring Context Refresh & Lazy Initialization ***

## *** 11. Spring mvc ***
**11.0 DispatcherServlet**

**11.1 Annotation liên quan đến Controller**

**11.2 Annotation xử lý Request**

**11.3 Annotation xử lý Response**

**11.4 Annotation quản lý Model và View**

**11.5 Annotation cấu hình và Dependency Injection**

**11.6 Annotation xử lý Validation**

**11.7 Annotation liên quan đến REST**

**11.8 Annotation khác**










