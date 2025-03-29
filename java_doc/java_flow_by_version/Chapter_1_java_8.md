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
- Consumer<T>: Nhận một giá trị nhưng không trả về gì -> nó giống với 1 hàm void. Nó chỉ có 1 phương thức duy nhất là accept.
  + Nó đang được dùng trong forEeach để call 1 hàm kiểu void: ![image](https://github.com/user-attachments/assets/c7367cdc-c208-429d-b9d9-07071262aa87)
  +![image](https://github.com/user-attachments/assets/4a15ffa1-3338-4be3-ac9b-1a3a94b83cf8) ![image](https://github.com/user-attachments/assets/712a953d-6cfe-47db-9cb9-bff464376192)
- 





## 2. Lambda Expressions
**2.1 Khái niệm**
- có thể được định nghĩa là một hàm ẩn danh, cho phép người dùng chuyển các phương thức làm đối số. Điều này giúp loại bỏ rất nhiều mã soạn sẵn.
- Cú pháp:
  + ![image](https://github.com/user-attachments/assets/f772b35b-f2a1-4df2-a71f-33613828bca3)
- Chúng chủ yếu được sử dụng với các interface có một phương thức trừu tượng duy nhất (Functional Interface).



