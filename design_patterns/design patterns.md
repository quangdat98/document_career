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


### 1.2 Prototype
**1.2.1 Khái niệm**
- Mục đích: Tạo object mới bằng cách clone
- Dùng khi nào: Tạo nhiều object giống nhau, chi phí tạo mới cao
- Ý nghĩa: Tăng hiệu suất tạo object, dễ nhân bản


- ### 1.3 Factory
**1.3.1 Khái niệm**
- Mục đích: Ẩn logic khởi tạo object, trả về interface
- Dùng khi nào: Có nhiều loại object khác nhau cùng interface
- Ý nghĩa: Giảm sự phụ thuộc vào new, tăng mở rộng dễ dàng

- ### 1.4 Builder
**1.4.1 Khái niệm**
- Mục đích: Tạo object phức tạp từng bước, rõ ràng
- Dùng khi nào: Object có nhiều field tùy chọn hoặc quá nhiều constructor
- Ý nghĩa: Dễ đọc, dễ maintain, phù hợp với immutable class

## 2. Structural Patterns – Nhóm Cấu trúc

### 2.1 Adapter 
**2.1.1 Khái niệm**
- Mục đích: Chuyển đổi giao diện của một class thành một giao diện khác mà client mong muốn.
- Dùng khi nào: Bạn có một class/library không thể sửa (ví dụ: bên thứ ba), Giao diện của class đó không phù hợp với hệ thống hiện tại, Bạn muốn "bọc lại" (wrap) một class để dùng được như ý.
- Ý nghĩa: Tái sử dụng code, Giúp các module tương thích với nhau mà không cần chỉnh sửa gốc.

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


