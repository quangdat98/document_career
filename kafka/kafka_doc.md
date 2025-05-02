# **------ Tóm Tắt ------**
0. Tài liệu
1.  Kiến thức nền tảng
2. Kafka Cơ Bản – Làm quen và hiểu cách hoạt động
3. Kafka Intermediate – Làm việc thực tế
4. Kafka Advanced – Dành cho production và scale
5. Kafka Ops – Quản trị và vận hành
# **------ Nội dung chi tiết ------**

## *** 0. Tài liệu tham khảo ***
- https://kafka.apache.org/documentation/
- https://spring.io/projects/spring-kafka
- https://www.tutorialspoint.com/apache_kafka/index.htm
- https://viblo.asia/s/apache-kafka-tu-zero-den-one-aGK7jPbA5j2

## 1. Kiến thức nền tảng
**1.1 Hệ thống messaging (message queue, pub/sub là gì)**
- Message Queue (hàng đợi tin nhắn) là mô hình trong đó:
  + Producer (người gửi): gửi message vào hàng đợi.
  + Consumer (người nhận): lấy message ra từ hàng đợi để xử lý.
  + Mỗi message chỉ được một consumer xử lý (point-to-point).
  + Message được xử lý theo thứ tự FIFO (First In, First Out).

- Publish/Subscribe (Pub/Sub) là gì?
  + Publish/Subscribe, gọi tắt là Pub/Sub, là một mô hình truyền tin trong hệ thống phân tán, nơi người gửi (Publisher) không gửi trực tiếp cho người nhận cụ thể, mà gửi đến một kênh trung gian gọi là Topic. Các người nhận (Subscriber) sẽ đăng ký (subscribe) vào topic đó để nhận thông tin.
- Cách hoạt động của mô hình Pub/Sub:
  + Topic là nơi lưu trữ tạm thời các message.
  + Subscriber (người đăng ký) đăng ký theo dõi một hoặc nhiều topic.
  + Khi có message mới, tất cả các subscribers sẽ nhận được bản sao của message đó.

- ![image](https://github.com/user-attachments/assets/31b27e13-de63-495f-8999-1aad32c9ba3d)

**1.2 Kiến trúc phân tán (distributed systems cơ bản)**
- Distributed System: Là một hệ thống gồm nhiều máy tính độc lập (nodes), kết nối qua mạng và cùng phối hợp để thực hiện một tác vụ chung, như thể chúng là một hệ thống duy nhất.
- Các đặc điểm chính của Distributed System:
  + ![image](https://github.com/user-attachments/assets/8d4a0cdd-7235-42ff-ac92-4c75eaf09bdb)
  + ![image](https://github.com/user-attachments/assets/6627145a-0333-4cec-a057-c874355804cc)
- Message broker: thay vì client giao tiếp trực tiếp với server thì sẽ thông qua message broker
  + ![image](https://github.com/user-attachments/assets/f6877c65-7652-4c04-bdb5-734f304f3627)
  + Producer/Publisher: nơi gửi message.
  + Message broker: hệ thống điều hướng message.
  + Consumer/Subcriber: nơi nhận message.
  + có 2 patter là Point-to-point messaging và Broadcast messaging: ![image](https://github.com/user-attachments/assets/e18522f9-d281-4ebf-8a03-63dd35dbc8d3)
  + Dễ hiểu cho 2 patter trên là: Nhắn tin hai người có thể dùng queue. Khi nhắn tin trong group thì dùng topic.
  + ![image](https://github.com/user-attachments/assets/a33676f1-d334-4724-a8b6-041d320472c4)
- Message broker theo cách thức hoạt động: ![image](https://github.com/user-attachments/assets/c3ce3d2c-364f-4782-8818-8d8ee7993993)



**1.3 Networking cơ bản (port, TCP/IP, DNS)**
- Port là gì?
  + Port là cổng giao tiếp phần mềm trên máy tính. Cùng một IP có thể mở nhiều port cho các ứng dụng khác nhau.
- TCP/IP là gì?
  + IP (Internet Protocol): dùng để xác định địa chỉ máy (IP address). VD: 192.168.1.5
  + TCP (Transmission Control Protocol): đảm bảo truyền dữ liệu tin cậy, đúng thứ tự, không mất gói.
- DNS là gì?
  + DNS (Domain Name System) giúp chuyển domain thành IP.

**1.4 Hiểu về logging system (log format, tail, append-only, v.v.)**

## *** 2. Kafka Cơ Bản  ***

**2.1 Kafka là gì?**
- Apache Kafka là một nền tảng streaming phân tán (distributed streaming platform) dùng để truyền tải, lưu trữ và xử lý dòng dữ liệu (stream of records) theo thời gian thực, với khả năng mở rộng rất cao.
- 4 Tính của kafka:
  + **High scalable:** Kafka là hệ thống phân tán - distributed system, có khả năng mở rộng rất nhanh và dễ dàng với zero downtime - mọi thứ vẫn hoạt động bình thường khi thêm hoặc bớt broker.
  + **High durable:** message được lưu trên disk, đảm bảo nếu mất điện.. data vẫn còn nguyên. Ngoài ra, một message sẽ có nhiều bản sao lưu trên nhiều broker khác nhau, phụ thuộc vào config và set up. Nếu một broker die, flow vẫn hoạt động bình thường không bị ngắt quãng.
  + **High reliable:** giống durable, lưu trữ message ở nhiều nơi. Ngoài ra có cơ chế cân bằng request trong trường hợp gặp sự cố về các broker. Đại khái là đáng tin cậy hơn các message broker hiện có trên thị trường.
  + **High performance:** high throughput cho cả đầu gửi và nhận message với khả năng scale tuyệt vời. Nhờ vậy nó có thể xử lý hàng TB data mà không gặp nhiều vấn đề về performance.

**2.1 Thành phần trong Kafka**
- Topic: Topic là một kênh dữ liệu trong Kafka, nơi mà các producer gửi message vào và consumer lấy message ra.
  + Giống như table trong database, mỗi topic chứa dữ liệu thuộc một loại cụ thể.
- Partition: Mỗi topic được chia thành nhiều partition → giúp phân tán dữ liệu và xử lý song song.
  + ![image](https://github.com/user-attachments/assets/68efc929-7ced-47c8-a79f-288e8681f1dc)
- Offset: Offset là chỉ số thứ tự duy nhất của từng message trong một partition. Mỗi partition sẽ tự đánh số offset riêng, bắt đầu từ 0.
  + ![image](https://github.com/user-attachments/assets/432a5e54-0b21-4a52-aeb5-90190c92c2d6)
- Tương quan giữa Topic, Partition, Offset:
  + ![image](https://github.com/user-attachments/assets/fa66dae4-e38c-4842-924b-03e0ae4fbcba)
  + ![image](https://github.com/user-attachments/assets/cd133532-35d4-447c-9b03-231abbf8df9d)
  + Lưu ý: ![image](https://github.com/user-attachments/assets/3cced992-efd7-40e2-b9ff-a05a8396b446)

- Rebalancing là gì?
  + Rebalancing là quá trình mà Kafka phân phối lại các partition của topic cho các consumer trong cùng một group, khi có sự thay đổi cấu trúc group như: Consumer tham gia group mới, Consumer rời khỏi group, Partition tăng lên trong topic, Kafka broker bị mất kết nối/tái khởi động
  + Mục tiêu của rebalancing: đảm bảo rằng mỗi partition chỉ được xử lý bởi một consumer duy nhất trong group, và đảm bảo cân bằng tải.
  + ![image](https://github.com/user-attachments/assets/75d0318a-0369-4698-9e1b-419fb82d3da8)

- Consumer Group:
  + Một Consumer Group là tập hợp các consumer (ứng dụng đọc message) cùng chia sẻ một Group ID.
  + Mỗi partition trong một topic sẽ được gán duy nhất cho 1 consumer trong group đó → tránh xử lý trùng lặp.
  + ![image](https://github.com/user-attachments/assets/87805eb3-e35f-4af6-9f22-d583df7308ea)

- Broker: Topic được lưu trữ trên file, trên disk, và tất cả đều được lưu trữ trên server. Và server là một Kafka broker trong Kafka cluster.
  + Kafka Broker là một server trong hệ thống Kafka có nhiệm vụ: Lưu trữ message trong các topic, Xử lý yêu cầu gửi (produce) và nhận (consume) message, Quản lý partition, duy trì offset, Đảm bảo replication giữa các broker (nếu có nhiều broker)
  + ![image](https://github.com/user-attachments/assets/a8f6382d-1979-4c9a-b81c-d70103e4f2f2)
  + Để đảm bảo high reliable, Kafka tự động phân tán các partition trên tất cả broker đang có. Mỗi partition nằm trên một broker. Topic-A partition 1 có thể nằm trên bất kì broker nào mà không phụ thuộc thứ tự.
  + ![image](https://github.com/user-attachments/assets/d3d586fd-cebf-4812-9dae-1e3dacebbc7e)

- Topic replication:
  + ![image](https://github.com/user-attachments/assets/2baab8d9-7e49-4360-b98d-03813c3de1de) => nếu broker 103 chết thì không sao nhưng 102 hoặc 101 chết thì có vấn đề => cần replication để giải quyết vấn đề này **tạo ra nhiều bản sao cho partition và lưu trên những broker khác nhau thông qua replication factor**
  + ![image](https://github.com/user-attachments/assets/9af042c3-273c-409d-8d21-77d521a31032)
  + 1 broker giữ vai trò Leader cho partition đó → Consumer & Producer chỉ làm việc với leader này.
  + n broker khác giữ bản sao (Follower) → gọi là replica.
-  replica là bản sao của một partition được lưu trữ trên một broker khác với mục đích đảm bảo dữ liệu không bị mất và hệ thống luôn sẵn sàng. Có 2 loại replica:
  + Leader: Replica chính, nhận ghi từ Producer, gửi dữ liệu cho Consumer (Các replication còn lại được gọi là ISR)
  + Follower: Các replica còn lại, chỉ sao chép dữ liệu từ Leader
  + Cơ chế hoạt động của replica: ![image](https://github.com/user-attachments/assets/da19317d-ba26-4ccb-8d58-fea896bd0887)
  +  replication leader của partition 1 không còn hoạt động => thì  Ai là người quyết định replication nào trở thành Leader hay ISR? đó chính là ZooKeeper
- Producer: Producer là người gửi message đến Message broker. Cụ thể với Kafka, producer write data vào partition của topic.
  + Trong trường hợp gửi message đến topic mà không chỉ định partition, producer sẽ gửi message đến broker theo cơ chế round-robin = "Message đầu tiên đi vào broker 101, message thứ hai đi vào broker 102, message tiếp theo đi vào broker 103... cứ như vậy, các message được write balance giữa các broker."
  + Producer biết message đã ghi thành công như thế nào?
     + Kafka Producer nhận được ACK (Acknowledgment) từ Kafka broker khi message được ghi thành công vào partition leader và (nếu cấu hình yêu cầu) đã được replicate sang các follower.
     + Producer gửi message đến Leader Partition của Kafka broker.
     + Leader ghi message vào commit log (dưới dạng append).
     + Kafka kiểm tra điều kiện ACK (tùy theo cấu hình acks của Producer): Nếu thỏa mãn điều kiện → Kafka gửi lại ACK (thành công) cho Producer, Nếu không → Kafka không gửi ACK → Producer biết là thất bại (hoặc timeout).
  + Cấu hình acks trong Kafka Producer: ![image](https://github.com/user-attachments/assets/6798a76b-c319-468f-816a-9309290607c9)

- Message key: Trong Kafka, Message Key đóng vai trò rất quan trọng trong việc kiểm soát phân phối message đến partition, và hỗ trợ sắp xếp, phân nhóm dữ liệu. **Message nào sẽ được gửi vào partition nào của topic.**
  + ![image](https://github.com/user-attachments/assets/b9d1e2ec-dfaf-4ce4-8cea-0c58e2fb33ca)
  + Không cần quá quan tâm message thực sự đi vào partition nào. Chỉ cần biết cùng message key sẽ vào cùng partition.
  + Kafka sử dụng key để xác định partition theo công thức: partition = hash(key) % số partition của topic
  + ![image](https://github.com/user-attachments/assets/e60257f3-133c-4d25-ae3b-2e42e19d8812)

- Consumer: Có gửi thì có nhận, và consumer là đầu nhận message.
  + ![image](https://github.com/user-attachments/assets/ec7aad62-4101-4c5b-bc0c-45ccd5c17f21)
  + Việc đọc message trong một partition diễn ra tuần tự để đảm bảo message ordering. Có nghĩa là consumer không thể đọc message offset=3 khi chưa đọc message offset=2.
  + Consumer có cơ chế tự hồi phục
  + Một consumer cũng có thể đọc message từ một hoặc nhiều hoặc tất cả partition trong một topic.
  + Message ordering chỉ đảm bảo trong một partition. Việc đọc ghi message giữa nhiều partition không đảm bảo thứ tự. Message offset=5 ở partition 0 có thể được đọc trước message offset=2 ở partition 1.

- Consumer group: Message offset=5 ở partition 0 có thể được đọc trước message offset=2 ở partition 1.Mỗi partition chỉ được gán cho 1 consumer duy nhất trong nhóm → tránh xử lý trùng lặp. Consumer Group được định danh bởi group.id.
  + ![image](https://github.com/user-attachments/assets/c6645a2b-49a7-48f5-b75a-280e38890ecf)
  + Nếu số lượng consumer trong consumer group lớn hơn số lượng partition thì những consumer dư thừa có trạng thái inactive - không nhận bất kì message nào từ topic.
  + ![image](https://github.com/user-attachments/assets/a81fa634-d975-4bbd-a747-78518fb5f560)

- Queue và Topic trong Apache Kafka
  + Point-to-Point Messaging – Queue: Một message được gửi đến một hàng đợi (queue) và chỉ được một consumer xử lý.
  +  Broadcast Messaging – Topic (Pub/Sub):Một message được phát đồng thời đến tất cả subscriber (người đăng ký). Các hệ thống xử lý message độc lập, không ảnh hưởng nhau.
- Offset:
  + ![image](https://github.com/user-attachments/assets/b678e95e-da81-4d74-8d60-66a31e6af6d5)
- broker discovery: Kafka brokers bao gồm rất nhiều broker. Mỗi topic có thể có nhiều partition, mỗi partition được lưu trên các broker khác nhau. Tuy nhiên consumer chỉ cần connect tới một broker bất kì là có thể connect với toàn bộ Kafka cluster. Điều đó giúp consumer có thể đọc được message của topic nằm trên bất kì một broker nào.
  + ![image](https://github.com/user-attachments/assets/ec45e66e-f856-4a83-8a61-b5fd9c2da688)
  + Đi vào chi tiết, cùng đi tìm hiểu kĩ hơn về cách thức hoạt động của broker discovery, client connect tới Broker 102 để lấy message ở Broker 101 như thế nào. Đầu tiên, client connect đến Broker 102 và request metadata.
  + ![image](https://github.com/user-attachments/assets/6cd6b22c-7028-4717-acdc-c9f576a1f364)
  + Broker 102 trả về thông tin metadata và danh sách toàn bộ các broker hiện có trong mạng Kafka cluster.
  + ![image](https://github.com/user-attachments/assets/ebe2136c-fb92-4da3-9c3c-90e36ac109ee)
  + Sau khi có thông tin của toàn bộ broker và metadata, client sẽ quyết định connect tới broker nào để produce hoặc consume message.
  + ![image](https://github.com/user-attachments/assets/122c555c-fc56-4041-a9ca-a789dbc63a1a)


- Cluster: Có thể hiểu Kafka cluster là nhiều server tập trung lại thành một cụm làm việc với nhau - multi-brokers (multi-servers)
- Zookeeper: ZooKeeper là một "người quản lý trung tâm" trong hệ thống phân tán.
Nó giống như một cuốn sổ tay dùng chung, nơi các hệ thống (như Kafka) có thể:
  + Ghi lại thông tin quan trọng (ai là leader, ai đang online...).
  + Tra cứu thông tin để biết cách phối hợp với nhau.
  + Thông báo cho nhau khi có thay đổi.
  + ![image](https://github.com/user-attachments/assets/4c5e0e0c-25bd-42ef-adfb-9976676ba17b)
  + Kafka giao tiếp với ZooKeeper như thế nào?
    + Kafka broker kết nối với ZooKeeper khi khởi động.
    + Broker đăng ký trạng thái của mình vào ZooKeeper.
    + Khi có thay đổi, Kafka tự điều chỉnh dựa trên thông tin trong ZooKeeper.

- KRaft: KRaft (viết tắt của Kafka Raft) là cơ chế quản lý metadata nội bộ mới của Apache Kafka,
giúp Kafka hoạt động mà không cần ZooKeeper nữa.
  + ![image](https://github.com/user-attachments/assets/e586dc67-3135-4fd9-a528-8e6325db090b)
  + KRaft sử dụng thuật toán Raft consensus để đảm bảo dữ liệu metadata đồng bộ, nhất quán và có thể phục hồi trong Kafka cluster.
  + ![image](https://github.com/user-attachments/assets/56a1cd87-8c3f-46fe-9013-2db22ca95ab4)
  + ![image](https://github.com/user-attachments/assets/91f6fed2-e34c-4312-97c6-6744cea0e4af)


**2.1 Topic & Partition**

**2.1 Kafka là gì?**
