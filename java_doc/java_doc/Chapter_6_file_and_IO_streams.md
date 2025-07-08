# ** ------ Tóm Tắt ------ **
1. Luồng vào ra (I/O)
2. Standard or Default Streams in Java


# **------ Nội dung chi tiết ------**

## 0 Link tham khảo 
- https://www.geeksforgeeks.org/java/java-io-input-output-in-java-with-examples/

## 1. Luồng vào ra (I/O)

### 1.1 Khái niệm
- ![image](https://github.com/user-attachments/assets/2f20032b-5cfc-4ffa-b8a0-6d2240476f7b)
- Luồng vào ra trong Java hay Input/Output (I/O) trong java được sử dụng để xử lý đầu vào và đầu ra trong java.

### 1.2 Stream truyền thống
- Có 2 stream có nghĩa hoàn toàn khác nhau:
  + Stream kiểu truyền thống: java.io.InputStream / OutputStream. Dùng để xử lý đọc ghi dữ liệu tuần tự.
  + Stream java 8: java.util.stream. Dùng để xử lý dữ liệu theo pipeline ("Pipeline" nghĩa là: xử lý theo chuỗi, từng bước nối tiếp nhau, như ống dẫn nước → nước chảy qua từng khúc, mỗi khúc làm một việc.)
  + ![image](https://github.com/user-attachments/assets/f3e793a3-d503-43ec-8dbb-d61cb45b30ea)


- Stream là gì? => **Stream truyền thống = các class trong gói java.io và java.nio dùng để đọc/ghi dữ liệu tuần tự qua luồng byte hoặc ký tự, từ/to các nguồn như file, mạng, bộ nhớ, console…**

### 1.3 Phân loại stream truyền thống
- **Byte Stream – Đọc/Ghi dữ liệu nhị phân.** chúng ta có 2 lớp abstract class: InputStream: đọc byte và OutputStream: ghi byte. Các lớp con phổ biến:
  + FileInputStream / FileOutputStream: 	Đọc/ghi file nhị phân
  + BufferedInputStream / BufferedOutputStream: Đọc/ghi có bộ đệm (tăng hiệu suất)
  + DataInputStream / DataOutputStream: Đọc/ghi dữ liệu nguyên thủy: int, double...
  + ObjectInputStream / ObjectOutputStream: Đọc/ghi object (serialization)

- **Character Stream – Đọc/Ghi ký tự (Unicode)** chúng ta có 2 lơp abstract class: Reader: đọc ký tự và Writer: ghi ký tự
  + FileReader / FileWriter: 	Đọc/ghi file text
  + BufferedReader / BufferedWriter: Có bộ đệm, hỗ trợ readLine()
  + PrintWriter: 	In text dễ như System.out
  + InputStreamReader / OutputStreamWriter: Chuyển đổi giữa byte và ký tự (encoding)

### 1.4.A chi tiết các lớp con Byte Stream 

### 1.4.B chi tiết các lớp con Character Stream

### 1.5 Kiến trúc luồng IO (decorator pattern) 
- Java IO dùng Decorator Pattern: Bạn có thể gói nhiều luồng lại với nhau để mở rộng tính năng.
  + ![image](https://github.com/user-attachments/assets/bb98b6aa-18a9-4ba3-9bec-942102b90df8)
- Kiến trúc luồng I/O trong Java là một hệ thống mạnh mẽ và linh hoạt, cho phép lập trình viên đọc và ghi dữ liệu từ nhiều nguồn khác nhau một cách hiệu quả, đồng thời cung cấp các lớp hỗ trợ giúp tối ưu hóa hiệu suất và xử lý dữ liệu phức tạp.

## 2. Standard or Default Streams in Java

### 2.1 Standard Streams 
- **Standard Streams (hay còn gọi là Default Streams) là ba luồng được JVM tự động cung cấp khi một chương trình Java bắt đầu chạy:**
  + Standard Input (System.in) -> đọc dữ liệu từ bàn phím (stdin)
  + Standard Output (System.out) -> Ghi dữ liệu ra màn hình (stdout)
  + Standard Error (System.err) -> Ghi lỗi ra màn hình (stderr)
