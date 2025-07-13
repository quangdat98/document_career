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

### 2.4.1 Tạo project memo -> command (xử lý dữ liệu)
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
- @CommandHandler: là một annotation trong Axon Framework, nơi thực hiện xử lý command, **hàm khai báo @CommandHandler phải là contructor - đùng cho void vào nhé sai đó**
  + AggregateLifecycle.apply: Gửi event tới event store => Gọi @EventSourcingHandler tương ứng để cập nhật trạng thái nội bộ ![image](https://github.com/user-attachments/assets/388abf00-2263-45ec-8394-9daf31a0581e)
  + @EventSourcingHandler: **lắng nghe AggregateLifecycle để nhận 1 event và cập nhận trạng thái các field của thằng aggregate**. ![image](https://github.com/user-attachments/assets/c13cd5c6-f770-4b00-9c45-0de98e17560c)
  + Trong aggregate bắt buộc phải có 1 hàm contructor không có tham số => Axon cần constructor không đối số để khôi phục Aggregate từ event store khi replay.
  +  Trong aggregate bắt buộc phải có 1 hàm contructor có tham số => Trong constructor này, bạn sẽ thường dùng AggregateLifecycle.apply(...) để phát sinh sự kiện.

**Event handler**
- Nó ở bức này: ![image](https://github.com/user-attachments/assets/5851346d-e3f9-48a8-9938-1dc316a294e5)
- Tạo class Event handler: ![image](https://github.com/user-attachments/assets/8c7348f4-391e-47d2-8f2f-60c5e804365a)
- @EventHandler: Nhận và xử lý Event sau khi nó đã được phát sinh (ví dụ, do một command tạo ra event và AggregateLifecycle.apply() gọi). Repository chúng ta tạo trong tầng data.
- Nếu có lỗi ném ra 1 throw nó sẽ làm gián đoạn 1 event nên khi start lại thì nó tự động gọi lại thằng event => ko đúng, chúng ta cần đặt try/catch và ghi log trong catch
- **@DisallowReplay**: chỉ định axon ko phát lại khi khởi động ứng dụng.
=> sau khi chạy project và axon thì chúng ta sẽ có thêm 1 note ![image](https://github.com/user-attachments/assets/0286100f-8b5c-4000-890e-5f71aee7578d)
- Có 2 command ![image](https://github.com/user-attachments/assets/fe7b98af-815c-4140-948b-919fbe0f3315)

- ![image](https://github.com/user-attachments/assets/b4f0125e-a78c-4b70-a0fc-30b0035c6835) tương đưng trong DB có ![image](https://github.com/user-attachments/assets/0d7b632a-bdc7-4ac2-8da6-fa08697fb9c6)

### 2.4.2 Tạo project memo -> query (lấy dữ liệu)
- https://docs.axoniq.io/axon-framework-reference/4.11/queries/
- **QueryGateway**: QueryGateway là một gateway (cổng giao tiếp) dùng để gửi các truy vấn (query) đến các @QueryHandler. Đây là một phần trong mô hình CQRS (Command Query Responsibility Segregation), nơi Command và Query được xử lý tách biệt. Nó trả ra 1 CompletableFuture. ![image](https://github.com/user-attachments/assets/eba3c80c-223c-40e6-9ca8-31e022786e55)

  + ![image](https://github.com/user-attachments/assets/e0770c97-9901-4fe2-a819-c1d1230a171a) -> GetAllMemoQuery là class filter ko có filter thì để nó rỗng
  + Các loại truy vấn với query: Single Result - Lấy một kết quả duy nhất (@QueryHandler trả về 1 object), Multiple Results - Trả về danh sách kết quả (List<T>), Subscription (stream) - 	Trả về dữ liệu dạng stream/subscribe, xử lý theo thời gian thực
  + **Single Result**: CompletableFuture<MemoResponse> result = queryGateway.query(new GetMemoQuery("memoId"), ResponseTypes.instanceOf(MemoResponse.class));
  + **Multiple Results**: CompletableFuture<List<MemoResponse>> result = queryGateway.query(new GetAllMemosQuery(), ResponseTypes.multipleInstancesOf(MemoResponse.class));
  + **Subscription (stream)**: ![image](https://github.com/user-attachments/assets/c35b7401-973a-48d8-8f04-09fdd0e08035)
  + ResponseTypes là class tiện ích (utility class) trong Axon Framework, dùng để chỉ định kiểu dữ liệu phản hồi (response type) khi bạn gửi query thông qua QueryGateway. ![image](https://github.com/user-attachments/assets/cf5878a4-cff4-41ee-88c1-39bd45b57c8b)

- **model**: ![image](https://github.com/user-attachments/assets/bfc1f4b0-8802-40ef-84ff-3a1a495913ea)
- **projection** lthành phần chuyên xử lý các sự kiện (events) để xây dựng và cập nhật mô hình đọc (read model) -> nó là nơi xử lý logic
  + ![image](https://github.com/user-attachments/assets/4c54f9c4-8d6f-4efc-87a1-0f8ed91548d0)
  + @QueryHandler: Nhận và xử lý truy vấn (query) để trả về dữ liệu từ read model. Khi dispatch cái GetAllMemoQuery ở controller thì nó sẽ tìm và chạy vào hàm này
=> ![image](https://github.com/user-attachments/assets/af02f784-7897-4830-9c25-9bcc0980f4ea)
- Event store là lưu những cái thai đổi trạng thái -> query thì chỉ truy vấn dữ liệu nên chúng ta sẽ ko tìm dk chúng trên axon
- ![image](https://github.com/user-attachments/assets/2c24ff3a-9e8f-4d39-b3d5-aecec7f3bde0)



### 2.4.3 custom library
- Custom Library là một thư viện do chính bạn viết (hoặc nhóm bạn) để dùng lại trong nhiều dự án Java/Spring Boot khác nhau. Thay vì copy-paste code vào mỗi project, bạn đóng gói logic dùng chung thành một module/thư viện riêng, sau đó import qua Maven hoặc Gradle.
- Chúng ta tạo ra 1 project common server => build project đó để lấy file jar => khai báo trong file pom của project cần dùng => ![image](https://github.com/user-attachments/assets/517d37ca-3f8a-4c62-b216-8769f09b83c1)
- Sau khi import thì chúng ta cần khai báo để thằng service có thể scan được nó: ![image](https://github.com/user-attachments/assets/021c228d-aa5a-47b7-bdb6-fedc9d25ad4b)

- DÙng để xử lý exception: chúng ta dùng spring AOP
- ![image](https://github.com/user-attachments/assets/59dbf8a3-aeea-43d0-9ee5-912bb3fe143b)

### 2.4.4 user service
- Tương tự như thằng memoservice

### 2.4.4 Cấu hình swagger trong spring doc openAI
- Thư viện springdoc-openapi-starter-webmvc-ui phải đi cùng thằng spring-boot-starter-validation không sẽ bị lỗi.

Phần 30- 32

## 2.5 api gateway
**2.5.1 Khái niện và lợi ích**
- 1 kiến trúc microservice có cả trăm service, => cả cả trăm endpoint
- **API Gateway là một thành phần trung gian đóng vai trò như cổng vào duy nhất (entry point) cho tất cả các request từ client đến hệ thống microservices phía sau.**
- Che dấu cấu trúc hệ thống với bên ngoài, vì client chỉ biết host và post của api gateway
- Một số công nghệ API Gateway phổ biến
  + Spring Cloud Gateway
  + Kong/ngix/Apigee/Zuul (Netflix)
  + AWS API Gateway
**2.5.2 Nhược điểm**
- Nhược điểm: tăng thời gian response do phải đi qua 1 server trung gian, thêm 1 tác nhân gây lỗi.
- Không config chuẩn sẽ gây tắc nghẽn
- Tốn tiền
**2.5.3 Triển khai**
- Chúng ta có thể dùng từ các nhà cung cấp sẵn có như aws, kong gateway
- Chúng ta có thể tự dựng 1 project api gateway
- Chúng ta dùng thư viện spring-cloud-starter-gateway, do dúng ta đang dùng eureka thì chúng ta cần thư viện: spring-cloud-starter-netflix-eureka-client
- ![image](https://github.com/user-attachments/assets/473c7fc2-0114-45dc-9c2a-7215b5ae684a)
- discovery.locator.enabled: true : Cho phép Spring Cloud Gateway tự động phát hiện các service đã đăng ký trên Eureka, tức chỗ uri chúng ta có thể tháy đổi từ localhost:9002 => chuyển thành lb://userservice (ở đây lb có nghĩa là load balancing, userservice tên service mà chúng ta đã đăng ký với discovery)
- routes: ấu hình thủ công từng route
  + id: userservice Định danh (tên) cho route này
  + uri: lb://userservice Gửi request đến service có tên userservice đăng ký trên Eureka (dùng load balancing). cách khách chỉ định đúng con instant cần chạy ![image](https://github.com/user-attachments/assets/5581f137-340b-4938-9398-ddc9572fb20f)

  + predicates: Định nghĩa điều kiện để route này được sử dụng: nếu URL bắt đầu bằng
  + Path=/api/v1/user/** : /api/v1/user/ thì sẽ map sang userservice
- **Khi chúng ta call đúng port và đường dẫn api gateway sẽ chuyển đến đúng service đích.**

## 2.5 Load balancing
- Load Balancing là kỹ thuật phân phối lưu lượng truy cập (traffic) hoặc tác vụ (requests) đến nhiều server/máy chủ khác nhau để đảm bảo:Không có server nào bị quá tải, Hệ thống hoạt động ổn định, nhanh và đáng tin cậy, Khả năng mở rộng dễ dàng khi có thêm người dùng.
- Để thực hiện balancing ở trong api gateway thì cúng ta sủ dụng: lb://userservice
- Để test chúng ta tạo thêm 1 application của thằng user và đặt point khác
  + ![image](https://github.com/user-attachments/assets/8044d899-71e1-410a-8777-6e23af033900)
  + ![image](https://github.com/user-attachments/assets/50f38525-41c1-477b-b832-4e4b3daae2b6)
- Thuật toán mặc định là Round Robin (chọn lần lượt, mỗi lần là 1 instant)

**2.5.1 Câc thuật toán nổi tiếng**
- https://viblo.asia/p/tim-hieu-ve-co-che-load-balancing-GrLZD0X2Zk0
- **Round Robin**:Gửi request đến các server theo thứ tự tuần tự., đơn giản là thuật toán mặc định, nhưng không ưu tiên được các server mạnh
- **Sticky round robin**: Nó dựa vào session, nếu cùng 1 sesson thì nó sẽ vào 1 server. => gom nhóm theo session. Nếu sesion có lưu lượng lớn thì cách này ko tối ưu
- ****: mỗi server gán 1 trọng số, thằng nào có trọng số cao thì sẽ được ưu tiên để phân số request. => nếu server nào mạnh thì mh có thể tùy trỉnh để nó xử lý nhiều việc
- **IP/url Hash**:Dựa vào địa chỉ IP của client để chọn server. 
- **Least Connections**: Phân phối dựa vào số lượng kết nối, máy chủ nào ít request thì sẽ phôi phối đến đó => quản lý ko 1 con server nào ko làm gì cả
- **Least time**: Dựa vào thời gian phản hồi. ưu tiên các máy chủ có thời gian phản hồi nhanh nhất mà ít kết nối nhất
- **Random**:Chọn server một cách ngẫu nhiên.

**2.5.2 Custom thuật toán trong spring gateway**
- Tham khảo: https://docs.spring.io/spring-cloud-commons/reference/spring-cloud-commons/loadbalancer.html
- ![image](https://github.com/user-attachments/assets/4e347e43-6cc0-4188-adfa-7f14b876916b)
- ![image](https://github.com/user-attachments/assets/f687e0df-cd0f-443c-813f-95d7a5a402e2)

**2.6 Rate limiting**
- Khi bị tấn công DDOS thì làm sao đây??
- Rate limiting (giới hạn tốc độ) là một kỹ thuật được sử dụng để kiểm soát số lượng request mà một client có thể gửi đến một server trong một khoảng thời gian nhất định.
- Ví dụ: Chỉ cho phép một người dùng gửi tối đa 100 request mỗi phút => Nếu người dùng gửi nhiều hơn, hệ thống sẽ:Trả về lỗi 429 Too Many Requests/Hoặc trì hoãn/delay các request tiếp theo
- ![image](https://github.com/user-attachments/assets/2e257b4e-35c9-4570-a00c-b6c1c7ea376a)
**2.6.1 Throttling**: Cho phép request nhưng sẽ làm chậm, trì hoãn, hoặc giảm tốc độ xử lý thay vì chặn hoàn toàn.
- ![image](https://github.com/user-attachments/assets/6050f3c9-a827-47a0-8b33-ccb4fc02293c)
- Ngoài thời gian ra, thì nó còn kiểu theo địa lý (geography-based rate limting)
**2.6.2 Thuật toán của rate limiting**
- Thuật toán token bucket: Có một “xô” chứa token, Token được thêm vào định kỳ (ví dụ: 1 token mỗi 100ms)., Mỗi request tiêu tốn 1 token. => nếu hết token thì request sẽ chờ hoặc bị từ chối
  + ![image](https://github.com/user-attachments/assets/f73793c9-7609-4805-b4bc-625c67db8704)
  + Khi 1 request tới thì nó sẽ kiểm tra token bucket còn ko, còn thì gán ko còn thì xử lý riêng, config riêng sau 1 khoảng thời gian sẽ nạp thêm token

- Fixed Window Counter:Mỗi khoảng thời gian (vd: mỗi phút), một bộ đếm sẽ được tạo. Mỗi request tăng bộ đếm lên 1.Nếu vượt quá giới hạn, request bị từ chối.
- Sliding Window Log: Ghi lại timestamp của từng request.Khi có request mới → xóa các timestamp cũ ngoài khung thời gian → kiểm tra còn bao nhiêu request trong khoảng thời gian.
- Sliding Window Counter: Chia thời gian thành các khung nhỏ (sub-window).Ghi số lượng request trong từng khung.Khi có request mới, tính trung bình có trọng số của các khung gần nhất.
- ![image](https://github.com/user-attachments/assets/19b3b7cc-bc26-4af2-955f-7f30bf7cde40)


**2.6.3 thực hành**
- Vậy chúng ta đặt rate limiter ở đâu? - client / server / middleware.
- ko đặt tại client vì hacker sẽ thao túng được. Đặt ở server thì tốn rất nhiều tài nguyên nếu có 100 server thì lại phải tạo 100 rate limiter, cần sửa thì phải sửa 100 thằng => triển khai rate limiter như 1 middleware
- ![image](https://github.com/user-attachments/assets/741cde8d-8324-44bc-84c6-9d44d37ac3f0)
- Người ta thường dùng Redis (cache memory) để lưu.=> connection là nhanh nhất
- ![image](https://github.com/user-attachments/assets/b4061916-6b22-4bd1-80d2-aa4a377dde24)
- https://spring.io/blog/2021/04/05/api-rate-limiting-with-spring-cloud-gateway

**2.6.3.1 config RequestRateLimiter**
- Dùng  RequestRateLimiter
- Trong file config api gateway, chúng ta config thêm filters ![image](https://github.com/user-attachments/assets/8592398b-b4b8-4a90-afd1-d1e9a845684f)
- **KeyResolver**: là thành phần dùng để xác định "key" cho từng request, để áp dụng giới hạn rate-limiting (giới hạn số lượng request) riêng biệt theo từng đối tượng, ví dụ: theo IP, theo user ID, theo API key...RequestRateLimiter cần biết “ai” đang gửi request, để giới hạn mỗi người dùng khác nhau (nếu không thì tất cả đều tính chung, rất không hợp lý).
- Ví dụ phổ biến của KeyResolver
  + ![image](https://github.com/user-attachments/assets/d7419f6d-b1a6-4c30-ba74-a833739a020f) 

**2.6.3.2 Config redis**
- Dùng redis để lưu thông tin ratelimiter
- khai báo thư viện: spring-boot-starter-data-redis
- ![image](https://github.com/user-attachments/assets/4a628cb5-c81d-4784-bfe9-86b72e8c606a)

**2.6.3.3 custom spring cloud gateway**
- https://spring.io/blog/2022/08/26/creating-a-custom-spring-cloud-gateway-filter
- AbstractGatewayFilterFactory<T> là class cha trừu tượng dùng để tạo các custom filter có thể cấu hình trong Spring Cloud Gateway.
- Tạo 1 Componentkế thừa **AbstractGatewayFilterFactory** để tạo một filter tùy chỉnh cho Spring Cloud Gateway. @Override lại hàm apply nơi sẽ viết xử lý chính. việc thực hiện lớp filter này phụ thuộc config của bạn trong file properties đang trỏ tới class: ![image](https://github.com/user-attachments/assets/d5cd8e8a-86c7-433c-9f41-c00a7f5f75a1)
- Ví dụ về việc check api key nếu có request đến: ![image](https://github.com/user-attachments/assets/0d35a1b2-4995-45dc-945c-ef65c97302fd)
- Tạo contructor: Constructor này bắt buộc phải có để gọi super(Config.class) — nhằm nói với Spring Cloud Gateway biết class Config nào sẽ được binding từ YAML.
- Class config: dùng để định nghĩa các cấu hình (chưa dùng trong ví dụ) được lấy từ file propertiesm do apiKey đã lấy trực tiếp lên ko dùng -> tự search
- hàm apply có 2 tham số là ServerWebExchange exchange, GatewayFilterChain chain
  + ServerWebExchange: đại diện cho toàn bộ HTTP request + response trong môi trường reactive. exchange.mutate() Là tạo 1 bản sao do ServerWebExchange ko thể thay đổi được. ![image](https://github.com/user-attachments/assets/276c84f0-5c17-432a-b136-cb5fe74ac8a8)
  + GatewayFilterChain: Đại diện cho chuỗi filter tiếp theo. Dùng chain.filter(exchange) để chuyển tiếp request đi tiếp (chain.filter(...) để chuyển request sang các filter hoặc route kế tiếp)



## 2.7 Message queue

## 2.7.1 Khái niệm
- Refer: https://github.com/quangdat98/document_career/blob/main/kafka/kafka_doc.md
- ![image](https://github.com/user-attachments/assets/0ac4b83a-ca75-4e4d-80ef-bef63f6f8c12)
- ![image](https://github.com/user-attachments/assets/3c1809f0-d91a-4541-a9fe-2fb155f1a61c)


## 2.7.2 Thực hành
- Cài đặt apache kafka: apache kafka docker compose
- Docker Compose là một công cụ của Docker dùng để định nghĩa và chạy nhiều container Docker cùng lúc thông qua một file cấu hình duy nhất (docker-compose.yml).
- https://hub.docker.com/r/apache/kafka
- 1 số ví dụ config docker compose: https://github.com/conduktor/kafka-stack-docker-compose => ở đây chúng ta sẽ làm giống với zk-single-kafka-single.yml
- Chạy docker compose tại folder chứa file: ![image](https://github.com/user-attachments/assets/0551bd5c-b5da-4282-aed7-1b9c229fb948)
- sau khi chạy thì chúng ta đã tạo được server kafka, và kafka UI - control center http://localhost:9021
- ![image](https://github.com/user-attachments/assets/4d0d8f74-b27d-43f9-b946-dd7835909167)
  + Đây là giao diện quản lý, chúng ta có thể gửi, nhận tạo message, topic ...
  + Cái này khá nặng nếu dùng dk cli thì có thể bỏ phần này ra khỏi docker compose

**2.7.2.1 Config kafka và commonserver**
- https://www.baeldung.com/spring-kafka
- commonserver thì chúng ta đang build ra file ra và dùng nhiều chỗ, do chúng đang đang dùng kafka để giao tiếp giữa các server nên sẽ config kafka ở đây
- Đầu tiên là khai báo thư viện kafka: org.springframework.kafka
- Tạo class config kafka:
  + ![image](https://github.com/user-attachments/assets/96758912-8202-414a-98be-d93011481921)
  + Biến bootstrapAddress Đây là địa chỉ Kafka cluster (có thể là nhiều broker, phân cách bằng dấu phẩy).
  + **KafkaTemplate<String, String> Bean** là 1 tempalte của kafka giúp chúng ta gửi được message
  + **KafkaAdmin** trong Spring Kafka dùng để quản lý các thành phần của Kafka, chủ yếu là tự động tạo topic khi ứng dụng khởi động.
  + KafkaAdmin không bắt buộc nếu bạn không cần tạo topic bằng code.
  + Nếu bạn tự tạo topic bằng lệnh kafka-topics.sh hoặc qua UI như Kafka Manager, thì không cần KafkaAdmin.
  + Ngoài ra chúng ta có thể tạo 1 topic mới: ![image](https://github.com/user-attachments/assets/de4be41e-f9e6-4384-a00d-8cd62a47fa7f)
- Tạo class config consumer (thường viết chung với class config kafka - nhưng để dễ hiểu thì tách ra cũng dk
  + ![image](https://github.com/user-attachments/assets/53abe031-3078-4140-a9e6-f2d85853e025)
  + bootstrapAddress => vẫn cần biến này để biết chúng ta đang thực hiện có server kafka nào
  + **@EnableKafka** Kích hoạt hỗ trợ Kafka Listener (các method dùng @KafkaListener sẽ bắt đầu hoạt động).
  + Tạo hàm ConsumerFactory: Tạo ra Kafka consumer với cấu hình cụ thể ![image](https://github.com/user-attachments/assets/33e9d19c-65a0-457c-ab7a-b7dc35bf9fbe)
  + Tạo hàm KafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory Dùng để tạo listener (container) thực tế. **Hàm này sẽ được kết nối với @KafkaListener đẻ lắng nghe event, ở class notification**
  + Ở hàm kafkaListenerContainerFactory   gắn các config ở  ConsumerFactory ở trên vào listener factory. ![image](https://github.com/user-attachments/assets/7e0535ab-2576-4625-820a-467872e8dbd4)

- Tạo class KafkaProducerConfig
  + ![image](https://github.com/user-attachments/assets/52d4878b-8999-492a-9098-a2c8e48716c0)
  + Đầu tiên là vẫn giải gửi địa chỉ của server kafka
  + **ProducerFactory<String, String>**: Factory tạo ra Kafka producer, với key và value đều là kiểu String.
  + ![image](https://github.com/user-attachments/assets/20049bff-070f-49c3-ac20-ca5f318d84cc)
  + **Đúng, StringSerializer (ở Producer) và StringDeserializer (ở Consumer) phải tương thích với nhau để bên Consumer đọc được dữ liệu mà Producer gửi.**
  + ở producer dùng StringSerializer thì ở consumer cũng phải dùng StringSerializer
- Tạo class server gửi message
  + ![image](https://github.com/user-attachments/assets/71ab2651-7227-435f-bcf7-c9cb11bcb833)
  + Autowired lại KafkaTemplate đã khởi tạo bean class KafkaConfig
  + kafkaTemplate.send(topic, message); => dùng để gửi message lên topic
  + Giờ thì chúng ta có thể tạo 1 api ở server nào đó rồi call đến hàm kafkaTemplate.send của server common để gửi message.
  + Ở ví dụ này là memoserver ![image](https://github.com/user-attachments/assets/7eea1301-77b8-46c3-8de5-a462b1cfd7b1)



**2.7.2.2 sửa đổi service notification để nhận message**
- Tạo class eventconsumer để nhận message
- ![image](https://github.com/user-attachments/assets/604b53a5-2dcd-48f4-a9bf-d7774b05830e)
- **@KafkaListener**dùng để đánh dấu một method là listener – tức là method đó sẽ tự động được gọi khi có message Kafka đến topic đã chỉ định.
  + topics = test -> là topic chúng ta tự tạo
  + containerFactory = "kafkaListenerContainerFactory" => trỏ tới hàm kafkaListenerContainerFactory ở KafkaConsumerConfig
- test thử: ![image](https://github.com/user-attachments/assets/1feaed00-7387-4398-beae-000c607e94ee)
  + ![image](https://github.com/user-attachments/assets/a70f33b5-2690-4393-9489-dc7f49dd242b)

**2.7.3 xử lý mất message trong kafka**
- Link tham khảo: https://docs.spring.io/spring-kafka/reference/retrytopic.html
- Lỗi logic nghiệp vụ thì ko thể retry được
- Giải pháp cơ bản: Cơ chế separate retry queue:
  + Tách biệt logic retry khỏi xử lý chính => đẩy ra 1 topic riêng các message sẽ vẫn tiếp tục xử lý để app ko bị block => nhưng cứ đẩy ra topic như vậy thì sẽ là tạo ra rất  nhiều topic

- Giải pháp tốt nhất: **Dead letter queue (DLQ)** => sao 1 số số lần retry (có thể config) mà ko xử lý được thì nó sẽ đẩy ra 1 topic riêng
  + ![image](https://github.com/user-attachments/assets/14172c7f-0f7d-40e7-b495-d0f174533926)
- FLOW:
  + Consumer nhận message từ orders.
  + Nếu xử lý lỗi → chuyển message sang orders-retry-1.
  + Một consumer khác lắng nghe orders-retry-1 (với delay 10s).
  + Nếu tiếp tục lỗi → chuyển sang orders-retry-2.
  + Sau N lần retry → chuyển đến orders-dlt (Dead Letter Topic).
- Nhờ cái DLQ topic giúp chúng ta có thể điều tra log, cảnh báo own về topic này có nhiều lỗi.

**2.7.3.1 implement xử lý message lỗi**
- ![image](https://github.com/user-attachments/assets/b3249809-896c-4eb1-a4b0-2bc611027e92)

- **@RetryableTopic**  để triển khai cơ chế retry queue (retry topic) cho Kafka một cách tự động. (có cách khác tự config các topic). Nó bổ trợ cho @KafkaListener ở eventconsumer
  + attempts: số topic tính cả topic DLQ
  + backoff = @Backoff(delay = 1000, multiplier = 2): Lần retry đầu sau 1 giây, lần 2 sau 2 giây, lần 3 sau 4 giây (1s * 2).
  + autoCreateTopics = "true" Spring Kafka sẽ tự động tạo các topic retry và DLT nếu chưa có.
  + dltStrategy = DltStrategy.FAIL_ON_ERROR 	Mặc định. Nếu gửi message vào DLT thất bại → throw exception và không xử lý tiếp nữa. Đây là cách tiếp cận an toàn, tránh mất message.
  + dltStrategy = DltStrategy.ALWAYS_RET Nếu gửi message vào DLT thất bại → retry lại việc gửi vào DLT theo cơ chế retry (không phải gửi lại vào topic chính). Điều này giúp tăng khả năng message không bị mất nếu lỗi mạng hoặc Kafka tạm thời unavailable.
  + dltStrategy = DltStrategy.NO_DLT  khi hết số lần retry mà message vẫn lỗi, message sẽ bị bỏ qua chứ không được gửi đến topic DLT.
  + include = {RetriableException.class, RuntimeException.class} Chỉ retry nếu gặp một trong các exception này.
- **@DltHandler** Khi một message đã retry hết số lần (ở đây là 3 lần) mà vẫn lỗi → nó sẽ được gửi đến topic DLT (test-dlt), Hàm này sẽ tự động được gọi để xử lý message từ DLT.
- **Trong trường hợp mà server bị stop thì khi gửi các message sẽ ko bị biết mất, lúc nào server start lại thì các message vẫn tự động gửi lại => cái hay của kafka
- Sau khi chạy thì các topic đã được tạo 1 các tự động ![image](https://github.com/user-attachments/assets/2396248d-0c26-4d70-83c7-cc5f0c3175bf)
- => Nếu muốn tự tạo các topic thì có thể check link sau: https://docs.spring.io/spring-kafka/reference/retrytopic/topic-naming.html

## 2.8 Spring email
- https://www.baeldung.com/spring-email
- **SMTP Gmail** SMTP Gmail là dịch vụ gửi email của Gmail thông qua giao thức SMTP (Simple Mail Transfer Protocol) – một giao thức chuẩn dùng để gửi thư điện tử từ ứng dụng (như Java, Spring Boot) tới máy chủ thư.Nó cho phép ứng dụng của bạn (ví dụ: backend Java) gửi email qua tài khoản Gmail, thay vì dùng hệ thống gửi thư riêng.
- Để dùng smtp mail thì chúng ta phải tạo **APP password của gmail**
  + https://myaccount.google.com/ -> "Security" ->  "Signing in to Google", bật 2-Step Verification
  + Tạo App Password -> https://myaccount.google.com/apppasswords
- Để cấu hình gửi mail thì chúng ta có thể config bằng file properties hoặc dùng bean để config
- Vì send mail có thẻ dùng nhiều chỗ chúng ta lên viết ở common
  + ![image](https://github.com/user-attachments/assets/90618b33-12c9-40d9-868d-4ac4356b3826)
  + JavaMailSender  là một interface của Spring Framework dùng để gửi email. Nó là một lớp wrapper xung quanh thư viện JavaMail API (chuẩn của Java để làm việc với email qua SMTP, IMAP, POP3...).
  + MimeMessage là một đối tượng đại diện cho email MIME (Multipurpose Internet Mail Extensions) trong JavaMail API. Cho phép gửi mail dạng văn bản hoặc html, file đính kèm... Được tạo ra từ JavaMailSender
  + MimeMessageHelper là một class hỗ trợ từ Spring giúp bạn thao tác với MimeMessage dễ dàng hơn. ![image](https://github.com/user-attachments/assets/3066c9d1-434c-4f21-99f7-cfdca6d95ab0)

- ![image](https://github.com/user-attachments/assets/0cfd4be2-bde5-422d-b31e-ac374fd10342)
- Tại server notification thì chúng ta thêm 1 topic "test_email" dùng đẻ call hàm sendmail khi có message(là 1 email) được gửi tới
  + ![image](https://github.com/user-attachments/assets/057bc69b-df0b-4dde-a64b-e04bce7c43fc)

**2.8.1 gửi mail có template**
- [https://stripo.email/](https://stripo.email/templates/) => chứa các template mail miễn phí
- chúng ta tạo file template emil dùng file .ftl
  + .ftl là viết tắt của FreeMarker Template Language.
  + Là file chứa mẫu văn bản với các biểu thức động như ${name}, <#if>, <#list>, v.v. và  Dữ liệu sẽ được inject vào file .ftl và render ra HTML/email/text hoàn chỉnh.
  + ![image](https://github.com/user-attachments/assets/863fec13-6576-491b-ac22-9bdcc5206246)

**2.8.1.1 cấu hình service common**
- Do chúng ta dùng file ftl nên phải cấu hình FreeMarker + thêm thư viện spring-boot-starter-freemarker
  + Trỏ cấu hình tới folder chứa file template ![image](https://github.com/user-attachments/assets/9f03f47b-cfda-41c4-8c69-a73a7ad348b9)
- Tạo hàm send mail template
  + ![image](https://github.com/user-attachments/assets/9248b495-6606-4a56-bd61-5f0214964800)
  + Tạo sao lại khởi tạo Configuration vì FreeMarkerConfigurationFactoryBean là implements FactoryBean<Configuration>, getObject() là hàm mặc định được gọi tự động khi Spring muốn lấy "đối tượng thực sự" mà một FactoryBean tạo ra. Do ![image](https://github.com/user-attachments/assets/f8e1a263-251b-4830-bce4-daa792e99e97) nên thực chất nó sẽ trả ra Configuration
  + Nếu muốn lấy FactoryBean thì @Qualifier("&mailFreeMarkerConfig")
  + ![image](https://github.com/user-attachments/assets/eafcae9c-41ae-49bb-86e6-1f80cb92ad51)

- FreeMarkerTemplateUtils.processTemplateIntoString là một hàm tiện ích của Spring hỗ trợ xử lý template FreeMarker.
  + Nhận vào một Template của FreeMarker (template chứa các placeholder, ví dụ ${username}, ${email}...)
  + Nhận vào một Map<String, Object> chứa dữ liệu thay thế cho các placeholder trong template
  + Trả ra 1 String html hoàn chỉnh
  + ![image](https://github.com/user-attachments/assets/e31c89ba-45fd-4c5d-a162-51d7bcb587d0)
  + ![image](https://github.com/user-attachments/assets/db296eea-5433-4171-8d85-b7f188ca5f9c)

**2.8.1.2 notification service**
- Tạo 1 topic để gửi mail template và truyền các giá trị, vào
- ![image](https://github.com/user-attachments/assets/54cb0675-a0f0-445a-a862-ed72cd423a37)

# 3. Post service
- Khởi tại project tương tự các service khác

## 3.1 Distributed transaction
- **Distributed transaction là một loại giao dịch liên quan đến nhiều hệ thống hoặc nhiều nguồn dữ liệu khác nhau, nhưng vẫn cần đảm bảo tính toàn vẹn (consistency) và nguyên tử (atomicity) giống như một giao dịch đơn.**
- **Dual Write Problem** xảy ra khi hai hệ thống độc lập (ví dụ: database và message queue) được ghi dữ liệu cùng lúc, nhưng không có cơ chế giao dịch đồng bộ giữa chúng. Kết quả là có thể dẫn đến mất đồng bộ dữ liệu, gây lỗi nghiêm trọng trong hệ thống.

**3.1.1 $ tính chất ACID của transaction**
- Atomicity (Tính nguyên tử) Toàn bộ hoặc không gì cả
- Consistency (Tính nhất quán) Dữ liệu phải luôn hợp lệ trước và sau transaction
- Isolation (Tính độc lập) Transaction không ảnh hưởng lẫn nhau khi chạy đồng thời
- Durability (Tính bền vững) Khi đã commit, dữ liệu sẽ không mất kể cả khi hệ thống bị crash

**3.1.2 Các cách giải quyết Distributed transaction**
- Tạo 1 thằng trung gian,phân tán thành các transaction nhỏ ![image](https://github.com/user-attachments/assets/48b68667-fe67-480b-ad47-884d2503d62f)
- Có nhiều thuật toán cớ chế implement thằng distributed transaction
  + two phase commit
  + three phase commit
  + saga pattern with orchestration / choreography
  + parallel pipeline

**3.1.3 SAGA orchestration pattern**
- **Saga Pattern là một mô hình quản lý giao dịch phân tán (Distributed Transaction), được dùng trong kiến trúc Microservices, nơi mà mỗi service có database riêng và không thể dùng transaction xuyên service như trong monolith.**
- Saga pattern ra đời để giải quyết vấn đề này bằng cách chia nhỏ giao dịch thành nhiều bước (local transactions), và nếu có lỗi, sẽ gọi "bù trừ" (compensation transaction).
- ![image](https://github.com/user-attachments/assets/f5f218b6-5fc7-4824-84ab-46732e5046cb)

- Saga pattern xử lý distributed transation với 2 cách thức:
  + **choreography (Điều phối phân tán)**: Không có service trung tâm điều phối. Mỗi service tự động lắng nghe các sự kiện (event) và phản ứng tương ứng. Nếu có lỗi ở giữa, từng service sẽ gửi event rollback tương ứng (ví dụ: ReleaseInventory).
  + **orchestration (Điều phối tập trung)**: Có một service trung tâm gọi là orchestrator (người điều phối).Orchestrator điều khiển luồng giao dịch bằng cách gọi từng service theo thứ tự và xử lý thất bại (gọi rollback nếu cần). ![image](https://github.com/user-attachments/assets/c2339ee2-8e16-4620-b55f-fcb782131d3e)

**3.1.4 exception handling**
- Có 2 cơ chế
  + Retry: thực hiện lại
  + Abort: xử lý rollback
- Ví dụ: ![image](https://github.com/user-attachments/assets/04253643-e262-4707-ab32-abaca115d671)
- Khi 1 service mới được thêm thì nó chỉ cần quan tâm 2 điều là 1 commit và rollback còn lại ko cần quan tâm gì => thằng orchestration sẽ chịu trách nhiệm controll
- **drawbacks-nhược điểm**:
  + orchestration nếu bị lỗi thì transaction thì sẽ bị ảnh hưởng -> tạo nhiều instance để đảm bảo nó ko bị chết
  + Độ chế do các server phải thông qua orchestration để quản lý chứ không phải giao tiếp trức tiếp

## 3.2 Sagas của axon framework
- https://docs.axoniq.io/axon-framework-reference/4.11/sagas/

**3.2.1 sagas trong axon**
- life cycle.
  + Start Một sự kiện xảy ra và được đánh dấu bằng @StartSaga để tạo ra một instance của Saga.
  + Running Saga đang hoạt động: tiếp nhận sự kiện, xử lý nghiệp vụ, gửi lệnh, chờ phản hồi…
  + End Khi công việc hoàn tất, gọi SagaLifecycle.end() hoặc đánh dấu sự kiện bằng @EndSaga để kết thúc Saga (giải phóng tài nguyên).
- **@SagaEventHandler**: Đây là annotation dùng để đánh dấu các method xử lý sự kiện trong Saga.
  + ![image](https://github.com/user-attachments/assets/9813d2b5-13a9-47a2-ba04-9ed7afd66367)
  + associationProperty: là tên property dùng để liên kết sự kiện với Saga đang tồn tại
- **AssociationValue**: Để biết Saga nào sẽ xử lý sự kiện nào, Axon dùng cơ chế Association.
  + Là cặp khóa-giá trị (key-value), ví dụ: ("orderId", "abc123")
  + Mỗi Saga instance sẽ được liên kết với một hoặc nhiều AssociationValue.
  + ![image](https://github.com/user-attachments/assets/73666c4b-df5b-425d-9634-a080b3a00d61)

- @EndSaga (SagaLifecycle.and()): Khi Saga hoàn thành, bạn phải kết thúc vòng đời của nó
  + ![image](https://github.com/user-attachments/assets/0ce2f2ba-c8e6-4e70-aedd-5c9d1d7b4016)

- @StartSaga: Dùng để đánh dấu sự kiện sẽ khởi tạo một Saga mới

- VD:
  + ![image](https://github.com/user-attachments/assets/e929c7cb-c9bb-43fa-a7ed-3ad990c3a53f)
  + ![image](https://github.com/user-attachments/assets/70cc045e-0c8f-4999-ad4d-64cef9102e46)
- Các hoạt động
  + Điều gì xảy ra khi bạn gọi associateWith(...)?
  + Axon ghi nhớ: "Saga này liên quan đến paymentId = xxx"
  + Khi sau này có một event đến và event đó có field tên là paymentId với giá trị trùng khớp, Axon sẽ route event đó vào Saga này
  + Nhưng nó không gọi handler ngay lập tức – phải đợi có sự kiện gửi tới sau đó.
- Luồng chạy:
  + Ở controller chúng ta có 1 api tạo post(luồng tạo post diễn ra như bt): ![image](https://github.com/user-attachments/assets/30d2e11e-7691-4d6f-82f3-9d92d681604f)
  + Ở class saga có set @SagaEventHandler(associationProperty = "id") và truyền vào hàm PostCreatedEvent => Axon tìm thấy saga handler có @SagaEventHandler và có class là PostCreatedEvent.  Tức là Axon lấy event.getId() rồi associate với key "id" → khởi tạo Saga mới.
  + Tương tự khi chúng ta sử dụng  commandGateway.sendAndWait(command); và axon nó tìm ra  @SagaEventHandler(associationProperty = "id") của hàm private void handler(PostUpdateStatusEvent event) => map nhau giá trị của class, giá trị associationProperty thì hàm @SagaEventHandler sẽ được chạy
  + ![image](https://github.com/user-attachments/assets/8cd01d30-bc6b-4358-8e4e-1630fcfaeaaf)

- KHi chạy chúng ra sẽ có một bảng sage trên BD tự vào và 1 bảng ASSOCIATION_VALUE_ENTRY => lưu trạng thái runtime của các Saga đang chạy. Khi Saga hoàn thành (kết thúc bằng SagaLifecycle.end()), Axon sẽ xóa nó khỏi bảng.
  + Nếu ko muốn xóa thì không dùng SagaLifecycle.end() hoặc search key word SagaStore
- **Tóm lại**
  + Khi chúng ta dùng saga thì sẽ quản lý được luồng transaction giữa các service.
  + STEP 1: Dùng SagaLifecycle.associateWith("id", event.getMemoId()); và thực hiện xong 1 tác vụ commandGateway.sendAndWait(command); ![image](https://github.com/user-attachments/assets/f48b0728-f53f-45bd-841a-afd2723a631e)

  + STEP 2: Lúc này thì theo luồng DDD nó sẽ nhảy vào @Aggregate => và chạy hàm   @CommandHandler và @EventSourcingHandler đẻ set giá trị vào 1 class event và tiêp tục xử lý dữ liệu. ![image](https://github.com/user-attachments/assets/db594024-5470-4185-a0ef-3c7f1d76fe0c)

  + STEP 3: Axon saga sẽ check hàm @SagaEventHandler(associationProperty = "id") có map giá trị key và value nào từ SagaLifecycle.associateWith("id", event.getMemoId()) ở step 1 hay hay ko, nếu có thì check tiếp xem class truyền vào có phải là class Event mà chúng ta đã truyền dữ liệu ở STEP 2 hay ko => nếu đúng thì hàm đó sẽ chạy => từ trong hàm đó chúng ta có thể set tiếp các SagaLifecycle mới ![image](https://github.com/user-attachments/assets/1a5d23d1-b218-47aa-80d1-26161de733da)

- **Rollback khi lỗi**: chúng ta phải tự xử lý bàng tay. Tưc là Gửi command để xóa dữ liệu đã tạo ở bước trước ![image](https://github.com/user-attachments/assets/0edb1cb9-a598-4b52-b64c-a817c230606c)

## 3.3 build project lên docker

 ### 3.3.1 Docker file
- Dockerfile là một tệp văn bản chứa các lệnh và chỉ thị được sử dụng để xây dựng một hình ảnh Docker. Hình ảnh này có thể chứa mọi thứ cần thiết để chạy một ứng dụng, bao gồm mã nguồn, thư viện, và các phụ thuộc khác.
- Thông tin chi tiết về docker thì tham chiếu: https://github.com/quangdat98/document_career/blob/main/docker/docker_doc.md
- Thực hiện tạo docker file cho server discoverserver: <img width="720" height="362" alt="image" src="https://github.com/user-attachments/assets/b3154f56-fcdb-45af-a27a-5bd60da42850" />
- Chú ý khi thực hiện chạy phải set cả post nếu ko sẽ ko truy cập dk web âu: docker run -p 8761:8761 discoverserver

 ### 3.3.2 Docker compose 
- Khi xây dụng ứng dụng microservice thì mỗi server chúng ta lại có 1 dockerfile thì rất khó để kiểm soát và thực thi => cần docker compose để quản lý tập trung  các dockerfile đó
- Điều lưu ý khi chạy docker compose là vị trí chạy file đã khác với chạy lẻ, nên trong file docker cần khai báo rõ thư mục:
  + Không nên dùng: COPY . ./discoverserver
  + Nên dùng: COPY ./discoverserver ./discoverserver


















