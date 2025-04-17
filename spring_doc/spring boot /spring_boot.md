# **------ Tóm Tắt ------**
1. Tài liệu tham khảo
2. Giới thiệu
3. Prerequisite (Spring Core Concepts)
4. Spring boot Annotations
5. Spring Boot Core
6. Spring Boot with REST API
7. Spring Boot with Database and Data JPA
8. Spring Boot with Microservices
9. Spring Boot with Kafka
10. Spring Boot with AOP
11. Spring Boot Testing
12. What You Can Do with Spring Boot
13. Spring Boot Features
14. Spring Boot Advantages
15. Limitations of Spring Boot


# **------ Nội dung chi tiết ------**

## ***1. Tài liệu tham khảo***
- https://docs.spring.io/spring-boot/index.html
- https://www.geeksforgeeks.org/spring-boot/?ref=ml_lbp
- Tiếng việt: https://kungfutech.edu.vn/khoa-hoc/spring-boot

## 2. Giới thiệu
**2.1 Spring Boot là gì?**
- Spring Boot Architecture: ![image](https://github.com/user-attachments/assets/fb60b6e4-d8c9-4276-933b-8128944cd297)

- Auto-Configuration
- Modular Architecture & Separation of Concerns
  + Modular Architecture: Mỗi module là một khối độc lập về chức năng (feature-based), có thể phát triển riêng, build riêng, thậm chí deploy riêng. ![image](https://github.com/user-attachments/assets/d405782c-74dc-4494-b440-6f00a680cc9e)

  + Separation of Concerns (SoC): Là nguyên lý lập trình cơ bản, **"Mỗi module/class/folder/… nên chỉ quan tâm đến một mối lo duy nhất."**
  + Như là là Nhận request => controller, Xử lý logic => service...
- Hiểu rõ Spring Boot lifecycle & Bean Scopes
- Spring Profiles – Cấu hình theo môi trường
- Dependency Management – Starter vs Custom
- Packaging & Deployment – DevOps friendly
- Microservice & Cloud-Native Readiness
  + Hiểu pattern: Service Discovery, Circuit Breaker, Rate Limiting, Retry, Timeout.
  + Tích hợp với các tool như: Spring Cloud (Eureka, Config Server, Gateway), Resilience4j, AWS/GCP integrations.
- Embedded Tomcat Server

## 3. Prerequisite (Spring Core Concepts)**
- Nội dùng về spring core được tổng hợp trong page: **[spring_doc/spring core/spring_code_and mvc.md](https://github.com/quangdat98/document_career/blob/64f484cfe91c4203ca03c6da489d0cfc5448221a/spring_doc/spring%20core/spring_code_and%20mvc.md)**

## 4. Spring boot Annotations
**4.1 Annotation cấu hình & khởi động**
-  *@SpringBootApplication*: là điểm khởi đầu chính của một ứng dụng spring boot. Nó tổng là **tổ hợp** của ba annotaion thường dùng: @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan. => bạn có thể thay thế @SpringBootApplication thành bộ 3 trên(như bản chỉ muốn scan 1 package riêng).
- *@SpringBootConfiguration*: Là phiên bản mở rộng của @Configuration, dùng để đánh dấu class là nguồn cấu hình chính của ứng dụng Spring Boot

- *@EnableAutoConfiguration*: việc chúng ta không phải config thủ công dùng xml như spring mvc là nhờ tình năng này.
   + Khi sử dụng @EnableAutoConfiguration, sprint boot Tự động phân tích các thư viện mà bạn đã thêm vào (ví dụ như các dependencies trong pom.xml hoặc build.gradle).
   + Ví dụ như datasource, transaction manager, etc.), Spring Boot sẽ làm việc đó tự động.
   + Cấu hình tùy chọn: exclude => loại bỏ cấu hình tự động. VD: cấu hình datasource riêng @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

- *@ComponentScan*: Dùng để quét các component (@Component, @Service, @Repository, @Controller) và đưa chúng vào Spring container (applicationcontext).
   + Nếu đặt @ComponentScan trên class trong package gốc (root package), nó sẽ quét tất cả các sub-package luôn.
   + chỉ định package cần quét: @ComponentScan(basePackages = {"com.example.service", "com.example.repo"})
   + chỉ định package cần quét(theo class): @ComponentScan(basePackageClasses = {ServiceA.class, RepoB.class})
   + filter để chọn hoặc loài trừ component: ![image](https://github.com/user-attachments/assets/1d65000c-aa3f-4f24-8a0f-df27e76db92e)
   + Với filter chúng ta có các type hỗ trợ: ![image](https://github.com/user-attachments/assets/273ccf94-da28-486f-9033-ca2cb8551b55)


**4.2 Conditional**
- Là một annotation cho phép bạn chỉ định điều kiện để Spring quyết định có nên đăng ký một bean hoặc cấu hình nào đó vào ApplicationContext hay không.
- Dùng khi nào:
  + khi bạn muốn tùy chọn bean dựa theo môi trường (dev, prod, test)
  + Các điều kiện bạn tự custom. VD như là chỉ chạy trên môi trường linux: ![image](https://github.com/user-attachments/assets/df3c3c34-86f2-4348-b1a8-1f11784f3e22) ![image](https://github.com/user-attachments/assets/aa954047-65e9-46da-90d7-d80cddb78b76)
  + Các phiên bản mở rộng: ![image](https://github.com/user-attachments/assets/14483e3d-6132-44ee-aa6d-46052b1ed89e)




**4.3 Annotation liên quan đến Bean & Dependency Injection**
- Khai báo quản lý bean: ![image](https://github.com/user-attachments/assets/13108028-6126-45ac-9ebf-44624e7b7c14)
- Inject Bean (DI – Dependency Injection):
  + @Autowired
  + @Qualifier("beanName") chỉ định tên bean cụ thể: ![image](https://github.com/user-attachments/assets/c2e336bb-d786-4eb9-b752-2d5d43894a0f) => dùng kèm với Autowired/Inject vì qualifier nó chỉ để phân biệt tên
  + @Primary giống mới Qualifier, nếu bạn có nhiều bean giống tên nhau thì bean nào đực đánh dấu với @Primary sẽ được dùng.
  + @Inject tương tự như @Autowired nhưng nó là của thằng java chứ ko phải spring
  + @Named("beanName") giống với Qualifier nhưng là java thuần
  + @Resource(name="beanName")
  + @Lazy trì hoãn khởi tạo bean, bean sẽ ko khởi tạo ngay lúc container khởi động mà chỉ khi thật sự cần, tiếp kiệm bộ nhớ nhưng lúc gọi thì rất chậm (cẩn thận trong thread). Chỉ dùng với thằng bean nào lớn
  + @Value("${config.key}")
  + Tóm tắt ![image](https://github.com/user-attachments/assets/926b4ed7-b7ca-4de1-9649-216bc30e3b25)

- Scope và Lifecycle của Bean
  + https://github.com/quangdat98/document_career/blob/64f484cfe91c4203ca03c6da489d0cfc5448221a/spring_doc/spring%20core/spring_code_and%20mvc.md

**4.4 Annotation cho Web & REST API**
- @Controller
- @RestController
- @RequestMapping
- @RequestParam
- @PathVariable
- @RequestBody
- @ResponseBody
- @ModelAttribute

**4.5 Annotation liên quan tới Validation**
- Dùng thư viện: jakarta.validation.constraints.*
  + @NotNull	Không được null (nhưng có thể rỗng, áp dụng cho Object)
  + @NotBlank	Không null và không rỗng sau khi trim (áp dụng cho String)
  + @NotEmpty	Không null và không rỗng (áp dụng cho String, Collection)
  + @Size(min=, max=)	Kiểm tra độ dài String / Collection
  + @Min(value=)	Giá trị tối thiểu (số nguyên)
  + @Max(value=)	Giá trị tối đa (số nguyên)
  + @Email	Định dạng email hợp lệ
  + @Pattern(regexp=)	Regex để kiểm tra định dạng
  + @Positive / @PositiveOrZero	Số dương / hoặc >= 0
  + @Negative / @NegativeOrZero	Số âm / hoặc <= 0
  + @Digits(integer=, fraction=)	Số với giới hạn phần nguyên và thập phân
  + @AssertTrue / @AssertFalse	Biểu thức boolean phải đúng / sai
  + @Past, @PastOrPresent	Ngày trong quá khứ / quá khứ hoặc hiện tại
  + @Future, @FutureOrPresent	Ngày trong tương lai / tương lai hoặc hiện tại

- Annotation hỗ trợ nâng cao
  + @Validated	Từ Spring, dùng trên class để bật validation nâng cao
  + @Valid	Từ Javax/Jakarta, dùng cho param hoặc field
  + @Valid trong @RequestBody	Dùng để validate JSON payload

- Custom Validation (ConstraintValidator)
  + //todo... có 2 trường hợp là custom và dùng phân tầng @Validated

**4.6 Annotation về JPA (nếu dùng database)**

**4.7 Annotation khác (bổ sung nếu cần)**




