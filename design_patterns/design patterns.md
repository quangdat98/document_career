# **------ Tóm Tắt ------**
0. SOLID

1. Creational Patterns (Nhóm Tạo đối tượng)
Singleton
Prototype
Factory Method
Builder
3. Structural Patterns (Nhóm Cấu trúc)
Adapter
Decorator
Proxy
5. Behavioral Patterns (Nhóm Hành vi)
Strategy
Observer
Template Method

# **------ Nội dung chi tiết ------**

## 0 SOLID

## 1. Creational Patterns (Nhóm Tạo đối tượng)

### 1.1 Singleton
**1.1.1 Khái niệm**
- Mục đích: Tạo bản sao của 1 object gốc
- Dùng khi nào: Cần quản lý trạng thái chung: config, DB pool, logger...
- Ý nghĩa: Tránh tạo nhiều object không cần thiết, tiết kiệm tài nguyên
***1.1.2 Ví dụ***
- ![image](https://github.com/user-attachments/assets/733cf8a0-e671-4470-a4eb-e9b16101d954)
- 1 class singleton cần có: 1 là khai báo, 2 contructor là private để ko khởi tạo ở class bên ngoài được, 3 là hàm lấy.


### 1.2 Prototype
**1.2.1 Khái niệm**
- Mục đích: Tạo object mới bằng cách clone
- Dùng khi nào: Tạo nhiều object giống nhau, chi phí tạo mới cao
- Ý nghĩa: Tăng hiệu suất tạo object, dễ nhân bản

***1.2.2 Ví dụ***
- Chúng ta implements interface Cloneable để thực hiện clone
- ![image](https://github.com/user-attachments/assets/8bab0c30-aa6b-4c11-a8f9-c4ebb5df0304)


- ### 1.3 Factory
**1.3.1 Khái niệm**
- Mục đích: Ẩn logic khởi tạo object, trả về interface, Về cơ bản thì ta sẽ định nghĩa một interface hoặc Abstract class , các class con sẽ implements nó
- Dùng khi nào: Có nhiều loại object khác nhau cùng interface
- Ý nghĩa: Giảm sự phụ thuộc vào new, tăng mở rộng dễ dàng

***1.3.2 Ví dụ***
- ![image](https://github.com/user-attachments/assets/4780e3f2-9598-46c1-8195-b351d070015d)
- ![image](https://github.com/user-attachments/assets/690ef117-7928-4683-8e77-1574841cebaa)
- ![image](https://github.com/user-attachments/assets/bf1586dd-ca48-485f-9582-46f82a321ce3)

- ### 1.4 Builder
**1.4.1 Khái niệm**
- Mục đích: Tạo object phức tạp từng bước, dễ đọc. Tránh tạo nhiều contructor nhiều tham số
- Dùng khi nào: Object có nhiều field tùy chọn hoặc quá nhiều constructor
- Ý nghĩa: Dễ đọc, dễ maintain, phù hợp với immutable class
***1.4.2 Ví dụ***

## 2. Structural Patterns – Nhóm Cấu trúc

### 2.1 Adapter 
**2.1.1 Khái niệm**
- Mục đích: Chuyển đổi giao diện của một class thành một giao diện khác mà client mong muốn.
- Dùng khi nào: Bạn có một class/library không thể sửa (ví dụ: bên thứ ba), Giao diện của class đó không phù hợp với hệ thống hiện tại, Bạn muốn "bọc lại" (wrap) một class để dùng được như ý.
- Ý nghĩa: Tái sử dụng code, Giúp các module tương thích với nhau mà không cần chỉnh sửa gốc.

***2.1.2 Ví dụ***
- Ta có interface Payment có phương thức payment để thực hiện thanh toán: ![image](https://github.com/user-attachments/assets/38176a6e-cea4-4118-8b9d-9e54e87a222a)
- Nhưng tôi cần thanh toàn cho một bên thứ 3 có phương thức sendPay khác: ![image](https://github.com/user-attachments/assets/604cda2d-9d73-4546-ba8f-3c2e2640145a)
- => vậy làm sao để đồng bộ 2 loại trên thành 1. Chúng ta sẽ bọc sendPay của bên thứ 3 lại bên trong thằng payment.
- Tạo lớp adepter để bọc: ![image](https://github.com/user-attachments/assets/f31a6cad-5828-4795-8696-fee6c8fd290d)
- Cuối dùng gọi payment từ Lớp Payment ban đầu: ![image](https://github.com/user-attachments/assets/3654799c-d225-4a38-bf4b-1e26f46ec06c)


### 2.2 Decorator
**2.2.1 Khái niệm**
- Mục đích: Thêm hành vi cho object mà không sửa code gốc
- Dùng khi nào: Cần mở rộng chức năng runtime mà không kế thừa
- Ý nghĩa: Tuân thủ Open/Closed, mở rộng dễ dàng


### 2.3 Proxy
**2.3.1 Khái niệm**
- Mục đích: 	Kiểm soát truy cập object thật
- Dùng khi nào: 	Cần kiểm tra, cache, lazy load, log... trước khi gọi object
- Ý nghĩa: Bảo vệ tài nguyên, tách biệt phần logic xử lý phụ

## 3. Behavioral Patterns – Nhóm Hành vi
### 1.1 Strategy

**1.1.1 Khái niệm**
- Mục đích: Cho phép thay đổi thuật toán linh hoạt
- Dùng khi nào: Có nhiều cách thực hiện (sort, validate, tính toán...)
- Ý nghĩa: Giảm if-else, dễ thay đổi thuật toán


### 1.2 Observer
**1.2.1 Khái niệm**
- Mục đích: Tự động thông báo các thành phần liên quan khi có thay đổi
- Dùng khi nào: Cần hệ thống theo kiểu event-driven
- Ý nghĩa: Tăng tính phản ứng (reactive), tách biệt thành phần


- ### 1.3 Template Method
**1.3.1 Khái niệm**
- Mục đích: Định nghĩa khung logic, subclass tùy biến bước nhỏ
- Dùng khi nào: Logic có nhiều bước giống nhau, nhưng 1 số bước cần tuỳ chỉnh 
- Ý nghĩa: Tái sử dụng code, rõ ràng về trình tự xử lý


