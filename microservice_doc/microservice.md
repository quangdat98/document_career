- Làm 1 ví dụ memo post
- Tham khảo design sau: ![image](https://github.com/user-attachments/assets/54104dcd-fd3d-4e3e-9549-bd4ab1590145)


# 1. Hiểu rõ về microservice architecture
- mộ số kiểu kiến trúc:
  + ![image](https://github.com/user-attachments/assets/e792f450-1a11-4773-95e0-abb6f8b46129)
  + ![image](https://github.com/user-attachments/assets/035a19b0-1673-42a9-aae7-4a3edbab8c93)
  + ![image](https://github.com/user-attachments/assets/bacc9061-e81e-4e21-ad19-5f596202f829)
  + ![image](https://github.com/user-attachments/assets/be329cd7-8007-4cb3-ad06-6d97bbfadbbb)
  + ![image](https://github.com/user-attachments/assets/06cb9657-b2ae-4be2-a4ac-e9d76178f98d)





## 1.1 Microservice architecture
**1.1.1 khái niệm***
- Monolithic: 1 khối thực hiện UI, logic, DB ...
- Microservice: tách riêng thành nhiều service ( mỗi project có 1 DB tương ứng với dịch vụ, mỗi server độc lập có thể triển khai với các ngôn ngữ khác nhau)
- ![image](https://github.com/user-attachments/assets/0c4d8278-1e7f-43c1-8a3d-ca919d7a1453)
  + docker host: vì mỗi dịch vụ có thể dùng các thư viện khác nhau, java, notejs.. nên cần 1 docker để đóng gói
  + 
**1.1.2 comunication microservice**
- Hạn số call trực tiếp giữa các server -> vì nếu lỗi thì sẽ ảnh hưởng tới thằng service khác => chúng ta phải thông qua 1 thằng là api gateway
**1.1.3 circuit breaker**
- Circuit breaker là một mẫu thiết kế (design pattern) dùng để ngăn hệ thống thực hiện các cuộc gọi đến một dịch vụ bên ngoài đang gặp lỗi.![image](https://github.com/user-attachments/assets/b5e477d7-fe06-4bd0-b3d0-5be3c47699a2)
- Nó đóng vai trò như cầu trì (ngắt mạch nếu lỗi)
- ![image](https://github.com/user-attachments/assets/915d159c-8d76-4898-a1e0-9ab7bb7dea13)

**1.1.4 Event Bus**
- Event bus là một kênh trung gian dùng để truyền tải các sự kiện giữa các microservice. Nó hoạt động như một message broker trung gian — nơi một dịch vụ có thể phát (publish) sự kiện, và các dịch vụ khác có thể lắng nghe (subscribe) sự kiện đó để xử lý.
- ![image](https://github.com/user-attachments/assets/499521cd-e4fc-456a-988a-b2043804cc83)
- Cơ chế hoạt động:
  + Publish (Phát sự kiện): Một service tạo ra sự kiện khi có hành động nào đó xảy ra.
  + Event Bus (trung gian): Event sẽ được gửi vào một hệ thống message broker như: kafka, rabitMQ, NATS...
  + Subscribe (Đăng ký lắng nghe): Một hoặc nhiều microservice khác lắng nghe sự kiện đó để thực hiện hành động tiếp theo (ví dụ: gửi email, cập nhật số liệu...).
- VD 👉 Giả sử có 3 microservices:
  + AuthService: đăng ký người dùng.
  + EmailService: gửi email chào mừng.
  + AnalyticsService: ghi nhận user mới.

**1.1.5 service discovery**
- Trong hệ thống microservice, một service thường chạy nhiều bản sao (instance) để:Tăng hiệu năng (chia tải),Tăng độ tin cậy (nếu 1 instance chết, còn lại instance khác chạy).Làm sao một service (hoặc gateway) biết phải gọi đến instance nào? => **Giải pháp: Service Registry**
- Service Registry là một nơi trung gian để các service tự khai báo (đăng ký) vị trí của mình, và để các service khác có thể tra cứu vị trí đó khi cần giao tiếp.![image](https://github.com/user-attachments/assets/9f2a027d-b1d9-4ed5-a54b-c9a28ebecdbb)
-  Công cụ thường dùng: Eureka (Phổ biến với Java/Spring Boot, dễ tích hợp.), Zookeeper (Mạnh nhưng phức tạp, thường dùng với Kafka.), Kubernetes DNS (Hệ thống tự động có sẵn trong K8s (ClusterIP).)
- **Service Discovery = “Tra cứu service”**
  + Cơ chế 1: Client-side discovery
    + Service tự hỏi registry để tìm service khác rồi gọi trực tiếp (thường dùng với Ribbon + Eureka).
  + Cơ chế 2: Server-side discovery
    + API Gateway (hoặc Load Balancer) hỏi registry, chọn instance, rồi gọi (dùng với Zuul, Spring Cloud Gateway, Istio...).
    
## 1.2 Java microservice with spring cloud

## 1.3 DDD layered architecture
- https://www.youtube.com/watch?v=WFlIoNHD_Yo
- https://viblo.asia/p/gioi-thieu-design-pattern-domain-driven-design-ddd-Qbq5Q423lD8
- DDD (Domain-Driven Design) là cách thiết kế phần mềm xoay quanh logic nghiệp vụ (business logic). Thay vì chỉ tập trung vào cơ sở dữ liệu hay API, DDD chú trọng vào việc mô hình hóa nghiệp vụ thực tế vào trong code.
- DDD sẽ gồm  tầng cơ bản:
- **Presentation layer**:  chứa controller, view, Chịu trách nhiệm giao tiếp với người dùng hoặc hệ thống bên ngoài.
- **Application**: Điều phối các hành động từ domain và Infasstructure.
- **Domain**: chứa tất cả quy tắc nghiệp vụ cốt lõi..Trái tim của DDD – nơi chứa logic nghiệp vụ cốt lõi.
  + Entity: đối tượng có danh tính riêng (vd: User, Order…)
  + Value Object: đối tượng không có danh tính (vd: Address, Money)
  + Aggregate: tập hợp các entity liên quan
  + Domain Service: chứa logic nghiệp vụ không thuộc riêng entity nào
- **Infasstructure layer**: Giao tiếp với thế giới bên ngoài như:Database, File, hệ thống khác (Redis, S3, v.v.), mail..
## 1.3.1 Ví dụ
- ![image](https://github.com/user-attachments/assets/96a2ba51-a4fc-498f-8a20-b35ea436c88e)
- ![image](https://github.com/user-attachments/assets/4f58ea82-044d-4dca-a2f6-706867fd7b35)
- DOMAIN LAYER: chúng ta khai báo 2 class Money và Order
  + ![image](https://github.com/user-attachments/assets/4eaee3f8-84b3-4214-949e-328470022b8b) có check value
  + ![image](https://github.com/user-attachments/assets/0c03d74c-2548-48da-8dab-417a0677d2c1)
  + Domain server: ![image](https://github.com/user-attachments/assets/0d81cfae-7cfe-47a3-907d-dffaa3c7846c)
- INFRASTRUCTURE LAYER: chứa interface giao tiếp với DB
  + ![image](https://github.com/user-attachments/assets/dbcc277d-8aef-40be-95f2-fbdc0b620158)
  + ![image](https://github.com/user-attachments/assets/0262a6aa-0b14-4460-adbe-ce1a32efeb94)
  + ![image](https://github.com/user-attachments/assets/8534ac7f-560d-4917-b7ec-fbbbc679e609)
- APPLICATION LAYER: điều phối domain layer và infrastructure
  + ![image](https://github.com/user-attachments/assets/e0690db2-ec09-47fd-9897-ec18de901384)
- PRESENTATION LAYER: chứa controller giao tiếp với client
  + ![image](https://github.com/user-attachments/assets/1673411b-3f96-49c3-8151-f1138850c8b2)

=> ưu điểm: 
  + Với testing thì chúng ta chỉ cần test với domain(logic) ko cần mock tầng DAO,
  + doamin model thì chủ động validate.Nếu entity đã được khởi tạo → đảm bảo là valid. Không cần kiểm tra lại ở tầng khác, ko phải viết validate ở nhiều chỗ
  + Tách biệt nên là sửa logic ko ảnh hưởng tầng DB, Khi sửa nghiệp vụ → chỉ sửa ở domain.
- Bạn có thể hiểu như một “người thật” tự chịu trách nhiệm hành động của mình, đang thực hiện các tác vụ theo nghiệp vụ (ubiquitous language (ngôn ngữ chung): là ngôn ngữ chung để khác hàng cùng devlop cùng dễ hiểu)

## 1.4 CQRS
- CQRS viết tắt của Command and Query Responsibility Segregation
- **Tách biệt trách nhiệm giữa Đọc (Query) và Ghi (Command)**
-✏️ Command: xử lý các hành động thay đổi dữ liệu (tạo, cập nhật, xóa).
-🔍 Query: xử lý các yêu cầu đọc dữ liệu (hiển thị, tìm kiếm, thống kê...).
- So sánh với mô hình CRUD
  + ![image](https://github.com/user-attachments/assets/9f24a9a8-da45-4326-af88-152d6f00e407)
- ![image](https://github.com/user-attachments/assets/12d60525-3fcf-42c5-955a-765734f971bf)
- Thông thường sẽ tách biệt thành 2DB, nhưng nhỏ thì dùng chung cũng dk ![image](https://github.com/user-attachments/assets/e1aa720b-8294-40e0-9291-7e8d8b0fe778) ![image](https://github.com/user-attachments/assets/086abbe7-81bb-4dff-bfbd-b6d4fc0121d5)

- Cái này hay dùng cho các ứng dụng lớn, ví dụ như đặt hàng shoppe chúng ta có thể sclae độc lập
- Hoạt động là lồng đọc sẻ ở DB riêng và luồng write sẽ ở 1 server riêng => 2 DB sẽ có 1 cơ chế để liên kết và đồng bộ nhau. => từ đó luồng đọc có thể triển khai noSQL để triển khai nhanh đọc, còn write thì sẽ  là PSQL hoặc MySQL để toàn vẹn dữ liệu

## 1.5 Event Sourching architecture
- Event Sourcing là mô hình lưu trữ toàn bộ các sự kiện (events) đã xảy ra trong hệ thống để xây dựng nên trạng thái hiện tại.
- Thay vì lưu trạng thái cuối cùng (state), ta lưu chuỗi các thay đổi (events).
- ![image](https://github.com/user-attachments/assets/316dbe78-30de-4b7e-83bb-e919614ed667)


## 1.6 SAGA: quản lý transation


-------------------------------------------------------------------------------------------------------------------------------

# 2. Thực hành
## 2.1 Tạo 1 discovery server => dùng với eureka
- https://cloud.spring.io/spring-cloud-netflix/reference/html/
- Cần cài thư viện spring-cloud-starter-netflix-eureka-server
- Bật anntation @EnableEurekaServer ![image](https://github.com/user-attachments/assets/a3289f4d-5f81-4d41-9d0b-ac8ad8a0aae2)
- spring.application.name=discoverServer => khai báo service này là 1 service discovery
- server.port=8761
- eureka.client.register-with-eureka=false khai báo thằng này là server rồi ko cần đăng ký nữa, true với mấy thằng client thôi
- eureka.client.fetch-registry=false ko cần load eureka client -> do thằng này sẽ lưu các danh sách client
- Sau khi run localhost:8761 thì chúng ta sẽ có giao diện sau: ![image](https://github.com/user-attachments/assets/8bde0c30-525e-4292-907a-736e75d44435)

## 2.2 Tạo 1 discovery client
- Tải thư viện: eureka discovery client
- DÚng ta dùng h2 database cho nhanh và spring jpa đê thao tác với sql
- Để mở project eureka client thì click chuột phải vào project -> click open module setting. ![image](https://github.com/user-attachments/assets/9347c4a5-d4ba-4956-ac6b-91dc6fcbd78a)
- Ấn dấu cộng -> import module -> tìm và ấn vào file pom: ![image](https://github.com/user-attachments/assets/8d3f1d30-5d01-458a-a141-353c19ce3a2f)
- Khai báo @EnableDiscoveryClient để đánh dấu đây là 1 discover client
- spring.application.name=memoService -> đặt tên cho service
- server.port=9001 => port của server này
- eureka.client.service-url.defaultZone=http://localhost:8761/eureka => để biết đã đăng ký với eureka địa chỉ nào.
- => sau khi chạy thì trên eureka sẽ thêm 1 service memo: ![image](https://github.com/user-attachments/assets/bf12c5e9-499a-4e17-ab12-dabe59b7c02b)

- 



