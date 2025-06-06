# Memo
1. Link tham khảo
2. String Templates (Incubator)
3. Record Patterns
4. Pattern Matching for switch (Preview)
5. Sequenced Collections (Preview)
6. Virtual Threads (Preview)
7. Structured Concurrency (Preview)

# Content

## 1. Link tham khảo
- https://www.baeldung.com/java-lts-21-new-features

## 2. String Templates (Incubator)
**Lý thuyết**
- String Templates là một tính năng mới (Incubator) trong Java 21 (JEP 430), cho phép nhúng biến và biểu thức trực tiếp vào chuỗi một cách rõ ràng, sạch sẽ và an toàn thay vì nối chuỗi thủ công.
- Trước java 21 để nối chuỗi thủ công chúng ta phải dùng "" +;
  + ![image](https://github.com/user-attachments/assets/540adbc4-8f2b-4388-a2fc-26267b7668cb)
- Java 21 dùng java.util.FormatProcessor:
  + ![image](https://github.com/user-attachments/assets/dfe96626-fcb4-4613-acdc-9b10aca9c936)
  + STR (cho nội suy chuỗi đơn giản). ![image](https://github.com/user-attachments/assets/25527dab-9c07-4df4-89d8-bec552116173)

  + FMT (cho định dạng giống String.format). ![image](https://github.com/user-attachments/assets/bd19a6c4-5e15-420b-9674-9be83e2c3f96)

  + RAW (dành cho xử lý tùy chỉnh) => cái này vip pro hơn. 

## 3. Record Patterns
- cho phép bạn trích xuất thành phần của một record một cách dễ dàng và ngắn gọn khi dùng với instanceof, switch, hay if.
- Record giúp đơn giản hóa việc tạo các lớp dữ liệu không thể thay đổi (immutable data classes). Chúng là một loại lớp tự động tạo ra các phương thức phổ biến như hàm tạo, equals(), hashCode()và toString()dựa trên các trường của lớp. Nó khá giống với thằng Lombok
- Code cũ: ![image](https://github.com/user-attachments/assets/0152366f-2093-41a8-8b9f-80ddf8d53924)
- Dùng Record: ![image](https://github.com/user-attachments/assets/f99e53fb-91a4-4a06-b7af-669a1cbbd3cf)
- Trong record, mọi field đều là private final mặc định — tức là:
  + private → không truy cập trực tiếp từ bên ngoài.
  + final → chỉ được gán một lần duy nhất, không thể thay đổi sau khi tạo. => là luống an toàn
  + ![image](https://github.com/user-attachments/assets/f27636d2-8b2d-45c1-a65b-1511c10fc390)


**Ứng dụng**
-  Làm DTO (Data Transfer Object) trong Spring Boot API, gọn gàng, immutable
-  Map kết quả truy vấn trong JPA ![image](https://github.com/user-attachments/assets/be872012-3945-4425-bd49-5597ee023196)

-  Tạo các response cố định: return new ApiResponse<>(200, "Success", userDto);

## 4. Pattern Matching for switch (Preview)
- Hợp nhất instanceof và switch: Không cần if instanceof rồi lại ép kiểu.
- Hỗ trợ phân nhánh theo kiểu (type).
- Cho phép thêm điều kiện với when guard.
- Xử lý được null một cách an toàn.
- ![image](https://github.com/user-attachments/assets/40912386-8c7b-47aa-af52-272f7de8bda8)
- => kết quả: ![image](https://github.com/user-attachments/assets/7fdd672d-dcc3-478f-9c7d-af4bdd0cd54b)

## 5. Sequenced Collections (Preview)
- Giới thiệu giao diện mới trong Collections API để truy cập phần tử theo thứ tự tuần tự (sequence order): từ đầu đến cuối và ngược lại.
- Trước Java 21, các cấu trúc như List, Set, Map không có API thống nhất để:
  + Lấy phần tử đầu tiên/cuối cùng
  + Duyệt thuận và ngược chiều
  + Thao tác đầu/cuối danh sách
 
- Giao diện mới:
  + SequencedCollection:	List, Set
  + SequencedSet:	Set có thứ tự
  + SequencedMap:	Map có thứ tự
- Các phương thức bên trong SequencedCollection: ![image](https://github.com/user-attachments/assets/2e12c15e-5f49-4173-bf26-2b0908b2116c)
- VD ![image](https://github.com/user-attachments/assets/41295c1f-468c-4581-9482-1b1a7f869bad)


## 6. Virtual Threads (Preview)
- Trong kiến trúc máy tính, thread (luồng) là phần con của process (tiến trình). Thread được tạo ra và quản lý thời gian xử lý bởi hệ điều hành.
- Ngược lại, virtual thread (luồng ảo) là thread được tạo và quản lý bởi một platform thay vì được tạo và quản lý bởi hệ điều hành như thread thông thường
- Do virtual thread được tạo ra bởi platform nên về lý thuyết platform có thể tạo ra số lượng virtual thread gần như vô tận, không bị giới hạn bởi số lượng thread của hệ điều hành. Ngoài ra tạo virtual thread cũng tốn ít tài nguyên hệ thống hơn thread thông thường nhiều lần, giúp cho việc tạo và quản lý virtual thread trở nên dễ dàng hơn.
- ![image](https://github.com/user-attachments/assets/604e8248-c17d-44f8-a34f-1d6d8c0d4307)
**So sánh hiệu năng**
- ![image](https://github.com/user-attachments/assets/0197b918-7fcd-445a-879d-14d7765eca32)
- Kết quả: Run time with virtual thread: 100, Run time without virtual thread: 4917 => chạy với virtual thread sẽ nhanh hơn rất nhiều.

**Lý do tốt hơn**
- Platform Thread (luồng truyền thống) ↔ mỗi thread Java tương ứng 1 OS thread → tốn bộ nhớ (1MB+/thread), chi phí tạo và context switch cao.
- Virtual Thread ↔ được Java quản lý bởi Java scheduler, không cần OS thread riêng → nhẹ hơn rất nhiều (khoảng vài KB/thread).
- Cần tìm hiểu thêm ![image](https://github.com/user-attachments/assets/8896cefc-7bb5-484b-b647-85df3f6d4b62)
**Cách dùng**
- Tạo Virtual Thread đơn giản ![image](https://github.com/user-attachments/assets/1a86f47d-8fbb-42ec-af5c-af7fa713f30c)
- Dùng Executor với Virtual Threads ![image](https://github.com/user-attachments/assets/4ea053f2-a63a-48c3-ba08-cd9db3e3aa69)
- Ví dụ chạy song song nhiều Virtual Threads ![image](https://github.com/user-attachments/assets/2c405368-6afa-4b0b-9135-740f8cf6b452)
- Kiểm tra Virtual Thread hay không ![image](https://github.com/user-attachments/assets/66aacdd1-b0cf-4b9e-8eaf-7b8fe931db06)

## 7. Structured Concurrency (Preview)
- Vấn đề của lập trình bất đồng bộ cũ
  + Khi bạn tạo nhiều Thread, Future, CompletableFuture để chạy song song, rất khó: Hủy tất cả khi 1 cái fail. Theo dõi luồng cha–con.Debug stack trace.
  + => **Structured Concurrency giải quyết vấn đề đó bằng cách gom các luồng con lại vào 1 cấu trúc có tổ chức và tự động hủy nếu cần.**
- Tham khảo https://www.baeldung.com/java-structured-concurrency
