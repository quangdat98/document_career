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
- Producer:
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

- Consumer:
- Consumer Group:
  + Một Consumer Group là tập hợp các consumer (ứng dụng đọc message) cùng chia sẻ một Group ID.
  + Mỗi partition trong một topic sẽ được gán duy nhất cho 1 consumer trong group đó → tránh xử lý trùng lặp.
  + ![image](https://github.com/user-attachments/assets/87805eb3-e35f-4af6-9f22-d583df7308ea)

- Broker: Topic được lưu trữ trên file, trên disk, và tất cả đều được lưu trữ trên server. Và server là một Kafka broker trong Kafka cluster.
  + Kafka Broker là một server trong hệ thống Kafka có nhiệm vụ: Lưu trữ message trong các topic, Xử lý yêu cầu gửi (produce) và nhận (consume) message, Quản lý partition, duy trì offset, Đảm bảo replication giữa các broker (nếu có nhiều broker)
  + ![image](https://github.com/user-attachments/assets/a8f6382d-1979-4c9a-b81c-d70103e4f2f2)
  + Để đảm bảo high reliable, Kafka tự động phân tán các partition trên tất cả broker đang có. Mỗi partition nằm trên một broker. Topic-A partition 1 có thể nằm trên bất kì broker nào mà không phụ thuộc thứ tự.
- Topic replication:
  + ![image](https://github.com/user-attachments/assets/2baab8d9-7e49-4360-b98d-03813c3de1de) => nếu broker 103 chết thì không sao nhưng 102 hoặc 101 chết thì có vấn đề => cần replication để giải quyết vấn đề này **tạo ra nhiều bản sao cho partition và lưu trên những broker khác nhau thông qua replication factor**
  + ![image](https://github.com/user-attachments/assets/9af042c3-273c-409d-8d21-77d521a31032)
  + 1 broker giữ vai trò Leader cho partition đó → Consumer & Producer chỉ làm việc với leader này.
  + n broker khác giữ bản sao (Follower) → gọi là replica.

- Leader partition concept
- Message key
- Consumer group
- Queue và Topic trong Apache Kafka
- 
- Offset:
- Cluster: Có thể hiểu Kafka cluster là nhiều server tập trung lại thành một cụm làm việc với nhau - multi-brokers (multi-servers)
- Zookeeper / KRaft:

**2.1 Topic & Partition**

**2.1 Kafka là gì?**
