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
- Mục đích: Singleton là một mẫu thiết kế (design pattern) thuộc nhóm Creational Pattern, mục tiêu là đảm bảo rằng chỉ có một instance duy nhất của một class tồn tại trong toàn bộ ứng dụng
- Dùng khi nào: Cần quản lý trạng thái chung: config, DB pool, logger...
- Ý nghĩa: Tránh tạo nhiều object không cần thiết, tiết kiệm tài nguyên
***1.1.2 Ví dụ***
- ![image](https://github.com/user-attachments/assets/733cf8a0-e671-4470-a4eb-e9b16101d954)
- 1 class singleton cần có: 1 là khai báo, 2 contructor là private để ko khởi tạo ở class bên ngoài được, 3 là hàm lấy.
=> Các trên rất không an toàn trong môi trường đa luồng -> do nếu 2 hay nhiều luồng chạy song song thì sẽ tạo ra nhiều instance cho class đó: <img width="771" height="520" alt="image" src="https://github.com/user-attachments/assets/7430eb73-7102-48b7-b96f-3229bf9d735c" />
- Để fix chúng ta dùng synchronized: <img width="628" height="354" alt="image" src="https://github.com/user-attachments/assets/0db27891-a9c2-4802-b1fb-d942efa32177" />
- Ngoài ra còn cách: Static Inner Class
  + Do khối static chỉ chạy đúng 1 lần do đó: Chạy static block đúng một lần. Các thread khác nếu gọi sau sẽ không tái thực hiện static block. => Đảm bảo tính thread-safe tự nhiên.
  + <img width="578" height="401" alt="image" src="https://github.com/user-attachments/assets/bac46058-845c-4e7e-ae12-d006f7ab54ba" />
  + Giá trị lấy lúc nào cũng giống nhau: <img width="642" height="368" alt="image" src="https://github.com/user-attachments/assets/b5867779-ede1-4e2b-b8f6-636096a1f0ff" />
  + Lý do thì tìm hiểu lại cơ chế hoạt động của static
- Singleton có bị phá vỡ không?
  + Thông qua Reflection (Phản chiếu): <img width="853" height="527" alt="image" src="https://github.com/user-attachments/assets/4f5ca95f-5119-4748-8ccf-fdbd07b80269" />
  + <img width="939" height="546" alt="image" src="https://github.com/user-attachments/assets/7f1cfe19-a45f-460a-90f9-cdff3214c3ed" />
  + <img width="796" height="305" alt="image" src="https://github.com/user-attachments/assets/59dd6188-cda8-4165-8548-adb438aefac8" />



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
- Các triển khai là chúng tạo 1 inner class là builder và class này sẽ là nơi nhập tất cả thông tin. sau đó trong contructor của class gốc thì chúng ta chỉ cần chuyền vào là class builder
***1.4.2 Ví dụ***
- class user và inner class builder: ![image](https://github.com/user-attachments/assets/8cab9096-2938-4445-85c5-556579646a3e)
- Khi tạo object thì chỉ cần truyền vào builder, hạn chế dùng contructor nhiều tham số: ![image](https://github.com/user-attachments/assets/3f8932a9-b6d1-4169-8e17-a5cdcceb0c71)
- Sau thì có loobook thì ko cần làm thủ công ntn.

**1.4.3 Giải thích khác hoạt đông**
- Lý đo nó có thể **chain method** (xích chuỗi) => do trong mỗi hàm đểu có return về chính Build dó build là static nên nó có thể call trức tiếp đến hàm khác.
  + <img width="844" height="649" alt="image" src="https://github.com/user-attachments/assets/b1a91cb1-6f2d-450f-bf4c-04db24861fdd" />


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

***2.2.2 Ví dụ***
- interface gốc: ![image](https://github.com/user-attachments/assets/af9932e8-6183-4cac-9260-dc2237a37927)
- ![image](https://github.com/user-attachments/assets/63565087-933e-4df4-b14c-7020255a3ff0)
- ![image](https://github.com/user-attachments/assets/ec1d75ac-4ba5-4359-80eb-4d9ccdba1616)




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
- Mục đích: Định nghĩa khung logic, subclass tùy biến bước nhỏ. Phần đầu thì giống nhau còn phần cuối thì tùy biến
- Dùng khi nào: Logic có nhiều bước giống nhau, nhưng 1 số bước cần tuỳ chỉnh 
- Ý nghĩa: Tái sử dụng code, rõ ràng về trình tự xử lý

***1.3.2 Ví dụ***
- Chúng ta có 1 tiến trình, trong đó read và write giống nhau chỉ có phần thực hiện là khác nhau => phần khác thì sẽ là lớp trừu tượng để class con tự thực hiện: ![image](https://github.com/user-attachments/assets/89f4f484-52eb-412b-b979-bb48875ddd71)
- Khi các class con extend thì nó sẽ phải thực hiện lại thằng process: ![image](https://github.com/user-attachments/assets/b515d68f-6cbe-4d3d-94f6-d04aa3913b73)
- Kết quả: ![image](https://github.com/user-attachments/assets/48c146bc-3f0a-49e0-9677-263ab262cb63)





