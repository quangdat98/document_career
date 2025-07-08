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
- **Stream là một chiều: InputStream chỉ dùng để đọc, OutputStream chỉ dùng để ghi. Nếu muốn đọc và ghi, bạn phải mở 2 luồng riêng biệt. Mở stream thì phải close() nếu không thì Gây leak hoặc file lock**

### 1.3 Phân loại stream truyền thống
- **A. Byte Stream – Đọc/Ghi dữ liệu nhị phân.** chúng ta có 2 lớp abstract class: InputStream: đọc byte và OutputStream: ghi byte.
- Được sử dụng để xử lý dữ liệu nhị phân (như hình ảnh, âm thanh).
- Các lớp con phổ biến:
  + FileInputStream / FileOutputStream : 	Đọc/ghi file nhị phân
  + BufferedInputStream / BufferedOutputStream: Đọc/ghi có bộ đệm (tăng hiệu suất)
  + DataInputStream / DataOutputStream: Đọc/ghi dữ liệu nguyên thủy: int, double...
  + ObjectInputStream / ObjectOutputStream: Đọc/ghi object (serialization)

- **B. Character Stream – Đọc/Ghi ký tự (Unicode)** chúng ta có 2 lơp abstract class: Reader: đọc ký tự và Writer: ghi ký tự
- **Được sử dụng để xử lý dữ liệu văn bản (như chữ cái và số). **
- Các lớp con phổ biến:
  + FileReader / FileWriter: 	Đọc/ghi file text
  + BufferedReader / BufferedWriter: Có bộ đệm, hỗ trợ readLine()
  + PrintWriter: 	In text dễ như System.out
  + InputStreamReader / OutputStreamWriter: Chuyển đổi giữa byte và ký tự 

- Bộ đệm (buffer) là một vùng nhớ tạm thời dùng để lưu trữ dữ liệu trong quá trình truyền tải hoặc xử lý. Trong ngữ cảnh của I/O, bộ đệm giúp cải thiện hiệu suất theo các cách sau:
  + Giảm Số Lần Truy Cập Vào Đĩa. Thao tác với bộ đệm giúp giảm thời gian chờ đợi khi đọc hoặc ghi dữ liệu.
  + Tăng Tốc Độ Xử Lý. Truy cập dữ liệu trên RAM nhanh hơn nhiều so với trên đĩa cứng.
  + Bộ đệm (buffer) là một vùng nhớ tạm thời nằm trong RAM (bộ nhớ truy cập ngẫu nhiên)
- Hạn chế buffer: Tiêu Tốn Bộ Nhớ, Dữ Liệu Không Đồng Bộ (Nếu ứng dụng gặp sự cố trước khi bộ đệm được ghi vào đĩa, bạn có thể mất dữ liệu)

- EOF:  EOF viết tắt của: End Of File. Nghĩa là "Kết thúc tập tin". Nó là tín hiệu logic do hệ thống file hoặc stream trả về
  + Khi bạn đọc dữ liệu từ một nguồn tuần tự như file, Java sẽ đọc từng byte hoặc ký tự liên tiếp.
  + Khi đọc tới cuối file, Java không còn dữ liệu để đọc nữa → trả về -1 để báo hiệu EOF.
  + ![image](https://github.com/user-attachments/assets/6be75376-a13e-45e8-9168-c326e9ade41c)


### 1.4.A chi tiết các lớp con Byte Stream 

**FileInputStream** FileInputStream là một lớp trong gói java.io dùng để đọc dữ liệu nhị phân (byte) từ một file.
- FileInputStream không xử lý ký tự/encoding. Nếu muốn đọc file text phải kết hợp với InputStreamReader
- Các phương thức quan trọng: ![image](https://github.com/user-attachments/assets/142ae0e9-441f-47d2-af8d-dc79a9e934f5)
- Cách đọc file từ byte ( kém hiệu quả) do Mỗi lần read() như vậy, JVM phải gọi hàm hệ điều hành (OS call) để đọc 1 byte → rất tốn thời gian nếu file lớn.: ![image](https://github.com/user-attachments/assets/d134691c-f8a2-43a0-bab7-c93426efefc4)
- **Đọc nhiều byte cùng lúc vào mảng**: chúng ta khởi tạo 1 mảng byte[] buffer = new byte[1024]; (1kb dũ liệu - đây là ví dụ chúng ta có thể tăng lên) và đọc theo từng "khối" (chunk) cho đến khi hết file.  ![image](https://github.com/user-attachments/assets/705c5816-e406-4b46-9afc-b2f70490f81e)

**FileOutputStream**

**BufferedInputStream / BufferedOutputStream**
- Tăng tốc độ đọc/ghi dữ liệu bằng cách sử dụng bộ nhớ đệm (buffer) trong RAM, thay vì thao tác trực tiếp với thiết bị (ổ cứng, mạng, v.v.) từng byte một.
- Như ở trên thì chúng ta tăng tốc độ của đọc ghi file bằng chắc chunk ta gọi là FileInputStream + byte[] buffer. => Bạn tự tạo bộ đệm 1024 byte (ví dụ), Mỗi lần read(buffer) → JVM gọi hệ điều hành để đọc tối đa 1024 byte vào RAM. **Nhưng vẫn phải gọi hệ điều hành mỗi lần read()**
- **Khi bạn dùng BufferedInputStream :Nó có buffer nội bộ riêng (mặc định 8192 byte). Khi bạn gọi bis.read(buffer):Nếu buffer nội bộ còn dữ liệu → đọc từ RAM (siêu nhanh). Nếu buffer nội bộ hết → Java mới đọc từ FileInputStream (IO chậm) => Như vậy, nó giảm tối đa số lần truy cập ổ cứng**
   ![image](https://github.com/user-attachments/assets/ccc41d0b-e720-46a5-93a5-12649e67d903)

 **ObjectInputStream**
- **ObjectOutputStream: Ghi (serialize) một đối tượng Java vào file/stream**
- Tạo ra dữ liệu nhị phân đặc trưng của Java -> phải dùng ObjectInputStream đẻ đọc
- Serialization quá trình biến đối tượng Java thành dòng byte để lưu vào file, gửi qua mạng, ghi xuống database…
- Deserialization = quá trình phục hồi dòng byte thành lại đối tượng gốc
- **Điều kiện để đối tượng có thể ghi/đọc bằng 2 class này phải implements Serializable**
  + ![image](https://github.com/user-attachments/assets/f819887b-e56b-4865-9235-a971974c08b6)
  + **transient: Không serialize các field tức các file đó sẽ ko lưu dưới file**

**ObjectInputStream**
-  **ObjectInputStream: Đọc (deserialize) một đối tượng từ file/stream**

### 1.4.B chi tiết các lớp con Character Stream

### 1.5 Kiến trúc luồng IO (decorator pattern) 
- Java IO dùng Decorator Pattern: Bạn có thể gói nhiều luồng lại với nhau để mở rộng tính năng.
  + ![image](https://github.com/user-attachments/assets/bb98b6aa-18a9-4ba3-9bec-942102b90df8)
- Kiến trúc luồng I/O trong Java là một hệ thống mạnh mẽ và linh hoạt, cho phép lập trình viên đọc và ghi dữ liệu từ nhiều nguồn khác nhau một cách hiệu quả, đồng thời cung cấp các lớp hỗ trợ giúp tối ưu hóa hiệu suất và xử lý dữ liệu phức tạp.
- FileInputStream không xử lý ký tự/encoding -> do đó khi đọc file thì lại cần kết hợp cả Character Stream và Byte Stream.
- 
  
## 2. Standard or Default Streams in Java

### 2.1 Standard Streams 
- **Standard Streams (hay còn gọi là Default Streams) là ba luồng được JVM tự động cung cấp khi một chương trình Java bắt đầu chạy:**
  + Standard Input (System.in) -> đọc dữ liệu từ bàn phím (stdin)
  + Standard Output (System.out) -> Ghi dữ liệu ra màn hình (stdout)
  + Standard Error (System.err) -> Ghi lỗi ra màn hình (stderr)
