# ** ------ Tóm Tắt ------ **
1. Functional Interfaces
2. Lambda Expressions
3. Stream API
4. Method References
5. Default Methods (Interface Enhancements)
6. New Date and Time API (java.time)
7. Optional Class
8. Nashorn JavaScript Engine
9. Consumer<T>
10. Predicate và BiPredicate
11. Supplier (java.util.function)
12. Higher Order Functions
13. Type Annotations and Repeating Annotations
14. Parallel Streams
15. New Collectors in Stream API

# **  ------ Nội dung chi tiết ------ **
## 1. Functional interface
**1.1 Khái niệm**
- Functional Interface là một interface trong Java chỉ chứa duy nhất một phương thức trừu tượng.
- Chúng được sử dụng chủ yếu trong lập trình hàm (Functional Programming) và có thể được triển khai bằng Lambda Expressions. => giảm số lượng code, dễ hiểu hơn.
- ![image](https://github.com/user-attachments/assets/c3f9434c-1e9d-449a-9c96-3bf6d05efc87)
- **@FunctionalInterface không bắt buộc nhưng nếu dùng, nó sẽ báo lỗi nếu interface có nhiều hơn một phương thức trừu tượng.**
- Một Functional Interface vẫn có thể chứa các phương thức default hoặc static, nhưng chỉ được có một phương thức trừu tượng duy nhất.![image](https://github.com/user-attachments/assets/845ddd03-9c33-4f97-9b19-4731723c05d5)
**1.2 Functional Interface có sẵn trong Java (java.util.function)**
- ![image](https://github.com/user-attachments/assets/5d99422a-e9fa-4593-a5a9-8fa88c388868)
- Consumer<T>:Input -> T, output -> ko có. Nhận một giá trị nhưng không trả về gì -> nó giống với 1 hàm void. Nó chỉ có 1 phương thức duy nhất là accept.
  + Nó đang được dùng trong forEeach để call 1 hàm kiểu void: ![image](https://github.com/user-attachments/assets/c7367cdc-c208-429d-b9d9-07071262aa87)
  +![image](https://github.com/user-attachments/assets/4a15ffa1-3338-4be3-ac9b-1a3a94b83cf8) ![image](https://github.com/user-attachments/assets/712a953d-6cfe-47db-9cb9-bff464376192)
- Supplier<T>: Input -> ko có, output -> T.Trả về một giá trị mà không cần tham số
  + ![image](https://github.com/user-attachments/assets/28f1a6dc-a9f4-4087-a5b1-ea55a399a883)
- Predicate<T>: Nó nhận một giá trị kiểu T và trả về boolean, thường dùng để kiểm tra điều kiện hoặc lọc dữ liệu trong Stream API.
  + Được sử dụng nhiều trong Stream API, Collection API, Optional, Filtering, Validation.
  + ![image](https://github.com/user-attachments/assets/a10f3d1e-c78d-4f96-bd78-c7b68c0ed526)
  + trong filler của stream cũng dùng predicate: ![image](https://github.com/user-attachments/assets/051836e0-46d3-4474-9e33-034342e61cae)
  + ![image](https://github.com/user-attachments/assets/2bab3dd0-05b9-4bc3-9db0-9f72cd68a65b)

- Function<T, R>: Nó nhận một giá trị kiểu T và trả về một giá trị kiểu R (tức là nó thực hiện một phép biến đổi từ T sang R). => nó được dùng thông dụng nhất là map trong stream.
  + ![image](https://github.com/user-attachments/assets/5551cd0d-d68d-47e5-8493-8d12da025d33)
  + Nó được dùng với map: ![image](https://github.com/user-attachments/assets/21f92ad7-fd25-467d-b008-d938f7290822)

- BiFunction<T, U, R>: Nó nhận hai tham số kiểu T và U, và trả về một giá trị kiểu R
  + ![image](https://github.com/user-attachments/assets/35143c6d-a819-410b-a73d-d9b86f16843d)
  + ![image](https://github.com/user-attachments/assets/5d733625-315d-46d8-9bdc-a22fad00aa81)
  + Áp dụng với reduce: là một phương thức của stream giúp gộp nhiều phần tử thành một giá trị duy nhất (thực chất là dùng BinaryOperator<T> nhưng BinaryOperator<T> là trước hợp đặc biết khi các input và output cùng kiểu dữ liệu -> thường trong stream là 1 kiểu dũ liệu duy nhất).


## 2. Lambda Expressions
**2.1 Khái niệm**
- có thể được định nghĩa là một hàm ẩn danh, cho phép người dùng chuyển các phương thức làm đối số. Điều này giúp loại bỏ rất nhiều mã soạn sẵn.
- Cú pháp:
  + ![image](https://github.com/user-attachments/assets/f772b35b-f2a1-4df2-a71f-33613828bca3)
- Chúng chủ yếu được sử dụng với các interface có một phương thức trừu tượng duy nhất (Functional Interface).
- **Lambda không thể thay đổi biến bên ngoài trừ khi là "effectively final".** ("Effectively final" là một thuật ngữ trong lập trình, đặc biệt trong ngữ cảnh của Java. Nó chỉ một biến mà không thể được gán giá trị mới sau khi nó đã được khởi tạo)
- Nếu muốn thay đổi 1 biến bên ngoài thì chúng ta phải dùng Atomic hoặc reduce.
- ![image](https://github.com/user-attachments/assets/7b5cff57-784b-446f-86af-77707f7af9e6)

## 3. Stream API
**3.1 khái niệm**
- Stream API được giới thiệu từ Java 8 nhằm xử lý dữ liệu một cách hiệu quả và dễ đọc hơn, thay thế cho các vòng lặp for, while, hoặc Iterator.
- Tất cả các class và interface của Stream API nằm trong gói java.util.stream
- Có thể chạy tuần tự (stream()) hoặc song song (parallelStream()).
- stream không  làm thay đổi dữ liệu gốc.
- Stream gồm 3 giai đoạn chính:
  + 1️⃣ Tạo Stream (Source) → Từ Collection, Array, File, Stream.of()
  + 2️⃣ Xử lý dữ liệu (Intermediate Operations) → filter(), map(), sorted() =>  Chúng không thực hiện bất kỳ hành động nào ngay khi được gọi mà chỉ tạo ra một Stream mới.![image](https://github.com/user-attachments/assets/79f4bbea-ec39-400a-ac93-bba454ac971a)

  + 3️⃣ Kết quả (Terminal Operations) → collect(), forEach(), reduce() => khi được gọi mới thực thi các xử lý dữ liệu gọi là **tính lazy của stream** ![image](https://github.com/user-attachments/assets/add1d7c3-dfc6-4c36-9f61-f4ddd4df9925)
- Lợi ích tính lazy: Chỉ những phần tử cần thiết mới được xử lý, giúp tiết kiệm tài nguyên.Xử lý dữ liệu lớn: Có thể làm việc với các nguồn dữ liệu lớn mà không cần tải toàn bộ vào bộ nhớ.
- **Không thể dùng lại sau khi gọi terminal operation.**
- **Không Dùng @Transactional Khi Dùng Stream Trong JPA** => vì stream có cơ chế lazy xong đột với transaction bị đóng khi ra hỏi phương thức.
**3.2 Các hàm trong stream**
- ![image](https://github.com/user-attachments/assets/3fa5aba9-73d0-4472-ab6b-d55cc0492d39)
- ![image](https://github.com/user-attachments/assets/7a89105e-7437-49c3-bb9b-5edc88ac503f)
- ![image](https://github.com/user-attachments/assets/93eaecfa-5920-414b-8885-59490362869a)
- ![image](https://github.com/user-attachments/assets/c37fdc13-6cae-4aab-aa0c-4aa7e63a2893)

## 4. Method References
**4.1 khái niệm**
- Method Reference là cách viết ngắn gọn hơn của Lambda Expressions, giúp code rõ ràng và dễ đọc hơn.
- ![image](https://github.com/user-attachments/assets/5bf9fe44-c6a2-440b-84a9-121693cb9daf)

## 5. Default Methods











