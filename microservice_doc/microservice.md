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

## 1.5 Event driven architecture (EDA)
**1.5.1 Khái niệm**
- EDA là kiến trúc phần mềm trong đó các thành phần giao tiếp và phản ứng với nhau thông qua các sự kiện (event), thay vì gọi trực tiếp nhau.
- 
**1.5.2 Các thành phần**
- Event Producer: TThành phần phát sinh và gửi sự kiện (ví dụ: OrderService)
- Event Consumer: Thành phần nhận và xử lý sự kiện (ví dụ: InventoryService, NotificationService)
- Event: Thông tin mô tả một hành động đã xảy ra (VD: OrderCreated, UserRegistered)
- Event Bus / Broker: Hệ thống trung gian truyền tải event (Kafka, RabbitMQ, ActiveMQ,...)

**1.5.3 quy trình hoạt động**
- Producer phát sinh event (VD: tạo đơn hàng). ![image](https://github.com/user-attachments/assets/ceda9c88-2fe2-4ab9-8219-5cd7d9b1ea95)
- Event được gửi tới event bus.
- Consumer lắng nghe bus và xử lý event phù hợp. ![image](https://github.com/user-attachments/assets/0147e4f4-aa59-46d6-893f-4b82e91265de)

## 1.6 Event sourcing
**1.6.1 khái niện**
- Event Sourcing là một kỹ thuật lưu trữ trạng thái hệ thống bằng cách ghi lại tất cả các sự kiện (events) đã xảy ra, thay vì chỉ lưu trạng thái cuối cùng vào database.
- 📌 Tức là: Thay vì cập nhật và lưu trạng thái hiện tại của đối tượng (entity), bạn lưu mọi sự kiện thay đổi trạng thái.
→ Sau đó, bạn replay (chạy lại) toàn bộ sự kiện đó để dựng lại trạng thái hiện tại.
![image](https://github.com/user-attachments/assets/c032fd06-07c4-480c-a6fb-8c607372ecde)
- Trường hợp 1 đối tượng đã bị thao tác rất nhiều và chúng ta muốn replay lại trạng thái ban đầu => event sourcing giúp chúng ta làm điều đó
- ![image](https://github.com/user-attachments/assets/acad8f81-7146-4043-8e84-be23a97f6a81)
- Dúng framework Ãon để triển khai với thàng event sourcing

**1.6.2 Các thành phần**
- Command: Yêu cầu hành động thay đổi trạng thái
- Event: Diễn tả hành động đã xảy ra
- Aggregate: Xây dựng lại trạng thái từ danh sách event
- Event Store: Kho lưu trữ danh sách events (có thể là DB, Kafka, Redis…)
- ![image](https://github.com/user-attachments/assets/f10f72e9-ae16-49c2-95fe-af6f810bc811)

## 1.7 SAGA pattern: quản lý transation
-  là một mẫu thiết kế (design pattern) dùng để xử lý giao dịch phân tán (distributed transaction) trong kiến trúc microservices. Nó đảm bảo tính nhất quán dữ liệu giữa các service khi không thể sử dụng một giao dịch truyền thống xuyên suốt nhiều cơ sở dữ liệu.
-  Saga là một chuỗi các hành động (local transactions) được thực thi bởi các service khác nhau. Nếu một hành động nào đó thất bại, các hành động trước đó sẽ bị rollback thông qua các hành động bù trừ (compensating actions).
-  ![image](https://github.com/user-attachments/assets/2bb4e50f-1164-48fd-b8a4-6c3e8de78fc6)


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

## 2.3 axon framework

**2.3.1 axon framework là gì**
- https://www.axoniq.io/products/axon-framework
- Axon Framework là một framework mã nguồn mở trong Java dùng để xây dựng các hệ thống Event-Driven, CQRS và Event Sourcing. Nó giúp bạn dễ dàng áp dụng các kiến trúc phức tạp như DDD (Domain Driven Design) trong các ứng dụng hiện đại, đặc biệt là microservices.
- Link hướng dẫn: https://docs.axoniq.io/axon-server-reference/v2025.0/
- cái đặt axon server: ![image](https://github.com/user-attachments/assets/07e8aa50-ce46-4be8-acef-f9e9097961a5), axon chạy trên tomcat
- Sau khi download axon server -> giải nén -> chạy file axonserver.jar để khởi động axon: ![image](https://github.com/user-attachments/assets/8432fda9-b015-4f5d-afab-24c4ff7a6400)
- axon chạy cổng 8024: ![image](https://github.com/user-attachments/assets/e6155dcc-457c-478f-94c4-16dee35ba2c1)
- chúng ta sẽ có ![image](https://github.com/user-attachments/assets/5b6521ae-de9a-4b4e-9a6b-391d1320729f)
- Cài đặt axon trên docker: chủ yếu là clone image của axon và chạy nó.
  + https://hub.docker.com/r/axoniq/axonserver/
  + Tải image: ![image](https://github.com/user-attachments/assets/18dac5c2-45a6-4dd3-91c6-aea15c974d08)
  + Run image: ![image](https://github.com/user-attachments/assets/d5bb7cc1-75b5-40b7-b172-6787784105cc)

**2.3.2 thông tin trên UI của axon**
-

## 2.4 Xây dựng dự án theo pattern CQRS (có sự kêt hợp với DDD và event sourcing)
- Để nhúng thằng axon thì chúng ta sẽ tiến hành theo mô hình sau: ![image](https://github.com/user-attachments/assets/0685198d-d36c-4125-81bc-bec883968784)

- CQRS chúng ta phải chia write và real tương ứng với command và query: ![image](https://github.com/user-attachments/assets/ee4c72d3-d5ab-495f-b6db-4cf795f469f4)
- Command(write):
  + command: Chứa các Command object – đại diện cho các hành động (tạo, xóa, cập nhật...). Dữ liệu trong Command được gửi đến Aggregate.
  + aggregate: Chứa các Aggregate Root – trung tâm xử lý logic nghiệp vụ và state. Đây là nơi nhận Command, xử lý logic và phát sinh Event.
  + controller: Giao diện REST/API nhận từ phía client (UI, app).
  + data: Lưu trữ hoặc ánh xạ dữ liệu gốc (nếu cần), hoặc cấu hình persistence (nếu không dùng Event Sourcing toàn phần).
  + event: Chứa các Event class – đại diện cho những gì đã xảy ra trong hệ thống.
  + model: Chứa các domain model dùng cho xử lý nghiệp vụ (khác với DTO). Dùng bởi Aggregate hoặc domain service.
- query(real):
  + controller: Nhận các HTTP GET từ phía người dùng để truy vấn dữ liệu.
  + model: Chứa Read Model, hoặc View Object, phục vụ cho API layer.
  + queríe: Chứa các Query object – yêu cầu dữ liệu (tương tự DTO nhưng chỉ để truy vấn).
  + projection: Nơi xử lý các event từ command/event, để xây dựng Read Model (Projection).
- ![image](https://github.com/user-attachments/assets/d7f3873f-7695-4381-a548-480715baec24)

- Dùng H2 database: base trên console rất nhẹ và nhanh
  + ![image](https://github.com/user-attachments/assets/54d0db20-7c7e-4a26-baab-f44bcfdf91f9)
  + Link console sau chạy dụ án: http://localhost:9001/h2-console/ ![image](https://github.com/user-attachments/assets/09e3c60c-3020-48e0-a884-8803b0629859)

### 2.4.1 Tạo project memo
- **data**: chứa class entity -> là 1 thực thể ánh xạ đến 1 bảng trong DB
  + ![image](https://github.com/user-attachments/assets/20a3b19c-66bb-449d-89a9-2751022ab1f1)
- **command (yêu cầu)**: https://docs.axoniq.io/axon-framework-reference/4.11/axon-framework-commands/
  + Command là một mệnh lệnh (yêu cầu) được gửi từ người dùng (hoặc hệ thống khác) để thực hiện một hành động có ảnh hưởng đến dữ liệu.
  + Nó không trả về dữ liệu (trong CQRS đúng nghĩa), mà chỉ báo thành công/thất bại. VD: CreateUserCommand, UpdateOrderStatusCommand
  + Mỗi Command thường chỉ làm một việc cụ thể.
  + Để tạo 1 memo thì chúng ta cần các trường sau ![image](https://github.com/user-attachments/assets/a207d809-47d5-4de0-87f4-aded00abd07d)
  + @TargetAggregateIdentifier: Annotation này được dùng trong axon framwork để đánh dấu trường trong Command object, nhằm chỉ định Aggregate nào sẽ xử lý Command đó.
**Controller- nơi phát ra yêu cầu -(command)**: Nơi phát ra controller
  + ![image](https://github.com/user-attachments/assets/43e6d193-0f69-4bd3-bbdb-3be67d2fa2a3)
  + ***CommandGateway***:  là một thành phần trong Axon Framework dùng để gửi (dispatch) Command đến Aggregate hoặc Command Handler.
  + commandGateway.sendAndWai: send và đợi kết quả trả về, sendAndWai nhận đối tượng là 1 command (class commad thì phải chứa @TargetAggregateIdentifier)
  + 
**Aggregate**: nơi chịu trách nghiệp xử lý command
- ![image](https://github.com/user-attachments/assets/581f1024-76e6-4b84-8dae-fe9197e2615e)
- @Aggregate: à annotation để khai báo rằng class này là Aggregate Root — nơi xử lý các Command và phát sinh Event.
- Arragate chứa các thuộc tính nằm trong nó,
- @AggregateIdentifier: là một annotation trong Axon Framework, được dùng để đánh dấu trường (field) làm ID của Aggregate. **Ánh xạ với giá trị trong @TargetAggregateIdentifier của Command**
- @CommandHandler: là một annotation trong Axon Framework, nơi thực hiện xử lý command
  + AggregateLifecycle.apply: Gửi event tới event store => Gọi @EventSourcingHandler tương ứng để cập nhật trạng thái nội bộ ![image](https://github.com/user-attachments/assets/388abf00-2263-45ec-8394-9daf31a0581e)
  + @EventSourcingHandler: **lắng nghe AggregateLifecycle để nhận 1 event và cập nhận trạng thái các field của thằng aggregate**. ![image](https://github.com/user-attachments/assets/c13cd5c6-f770-4b00-9c45-0de98e17560c)
  + Trong aggregate bắt buộc phải có 1 hàm contructor không có tham số => Axon cần constructor không đối số để khôi phục Aggregate từ event store khi replay.
  +  Trong aggregate bắt buộc phải có 1 hàm contructor có tham số => Trong constructor này, bạn sẽ thường dùng AggregateLifecycle.apply(...) để phát sinh sự kiện.

**Event handler**
- Nó ở bức này: ![image](https://github.com/user-attachments/assets/5851346d-e3f9-48a8-9938-1dc316a294e5)
- Tạo class Event handler: ![image](https://github.com/user-attachments/assets/8c7348f4-391e-47d2-8f2f-60c5e804365a)
- @EventHandler: Nhận và xử lý Event sau khi nó đã được phát sinh (ví dụ, do một command tạo ra event và AggregateLifecycle.apply() gọi). Repository chúng ta tạo trong tầng data.

=> sau khi chạy project và axon thì chúng ta sẽ có thêm 1 note ![image](https://github.com/user-attachments/assets/0286100f-8b5c-4000-890e-5f71aee7578d)
- Có 2 command ![image](https://github.com/user-attachments/assets/fe7b98af-815c-4140-948b-919fbe0f3315)

- ![image](https://github.com/user-attachments/assets/b4f0125e-a78c-4b70-a0fc-30b0035c6835) tương đưng trong DB có ![image](https://github.com/user-attachments/assets/0d7b632a-bdc7-4ac2-8da6-fa08697fb9c6)















