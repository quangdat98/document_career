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
**2.1 Thành phần trong Kafka**
**2.1 Topic & Partition**
**2.1 Kafka là gì?**
