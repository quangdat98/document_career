# Memo
- https://www.digitalocean.com/community/tutorials/java-11-features
1. New String Methods (Phương thức mới cho String)
2. Local-Variable Syntax for Lambda Parameters
3. Nest-Based Access Control
4. HTTP Client API (Standardized)
5. Launch Single-File Source-Code Programs
6. Removed Java EE and CORBA Modules
7. ...




# Chi tiết
## 1. New String Methods (Phương thức mới cho String)
- line(): trả về một Stream<String> các dòng con, tách theo dấu xuống dòng (\n, \r\n)
- strip(): Loại bỏ khoảng trắng đầu và cuối chuỗi, tương tự trim() nhưng dùng Unicode whitespace (hiện đại hơn, hỗ trợ nhiều loại khoảng trắng).
- stripLeading(): Loại bỏ khảng trắng ở đầu chuỗi
- stripTrailing(): Loại bỏ khoảng trắng ở cuối chuỗi
- repeat(int count): lặp lại số lần count cho trước
## 2. Local-Variable Syntax for Lambda Parameters
- var dùng để khai báo biến thông thường đã có từ java 10, từ java 11 Cho phép dùng var trong tham số của biểu thức lambda mà trước đó với lambda ko dùng được var
- chúng ta có thể thêm các annotation cho tham số lambda
  + ![image](https://github.com/user-attachments/assets/1ed8fc2d-fbbf-476b-b23e-c2229dae27b9)


## 3. Nest-Based Access Control
- Sự khác biệt nằm ở cấp độ bytecode JVM (Java Virtual Machine), không phải code.
- ![image](https://github.com/user-attachments/assets/428c772e-6864-431c-a222-a2640af8a66e)

## 4. HTTP Client API (Standardized)
- Gói api mới java.net.http.*
- Mặc định hỗ trợ HTTP/2
- Hỗ trợ CompletableFuture để gọi async
- Trước java 11 phải dùng HttpURLConnection cồng kềnh: ![image](https://github.com/user-attachments/assets/1a478604-f361-461b-9e97-8e0fa3c69c49)
- Từ java 11 có HttpClient  gọn gàng: ![image](https://github.com/user-attachments/assets/430e48a9-7ef9-43c4-9f66-15d5ce0587b2)


## 5. Launch Single-File Source-Code Programs
- chạy một file .java mà không cần biên dịch trước bằng javac.
- ![image](https://github.com/user-attachments/assets/2213e4d2-a9dd-49f1-a439-dde20b309a99)
- ![image](https://github.com/user-attachments/assets/e8e2b1e8-effa-4271-8d38-f4ae873e6c72)


## 6. Removed Java EE and CORBA Modules
- xóa bỏ một số thư viện liên quan đến xử lý xml
- Nếu bạn đang dùng các API Java EE như JAXB, JAX-WS, hoặc CORBA, thì chúng sẽ không còn có sẵn trong JDK 11 nữa. -> thay vào đó phải dùng thưu viện bên ngoài( vd dùng maven, gradle) 

