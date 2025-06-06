# memo
1. Link tham khảo
2. Sealed Classes (Lớp đóng)
3. Pattern Matching cho instanceof
4. Switch Expressions (đã ổn định từ Java 14)
5. New Foreign Function & Memory API (Preview)
6. Text Blocks (Java 15)
7. Enhanced pseudo-random number generators (JEP 356)
8. ..

# Content

## 1. link tham khảo
- https://javatechonline.com/java-17-features/

## 2. Sealed Classes (Lớp đóng)
**Lý thuyết**
- Mục đích của nó là kiểm soát sự kế thừa
- Tăng tính an toàn, tránh bị mở rộng ngoài ý muốn
- Tối ưu cho pattern matching

** Ví dụ**
- ![image](https://github.com/user-attachments/assets/9ea60fb1-3f19-4041-9486-a36ff27eaf45)
- sealed → Đánh dấu lớp Animal là "lớp đóng".
- permits Cat, Dog → Chỉ Cat và Dog được phép kế thừa.
- Ngược lại với sealed thì non-sealed cho phép kế thừa tự do.
- Khi dùng switch với Pattern Matching:
  + ![image](https://github.com/user-attachments/assets/99ee659a-0ac9-4627-b6f9-90297adc00fb)

## 3. Pattern Matching cho instanceof

**Lý thuyết**
- Mục đích là cải thiện instanceof, trước đó sau khi dùng instanceof thì phải ép kiểu ![image](https://github.com/user-attachments/assets/9c9ed9f6-7a69-483c-a14b-26317b89b43e)
- Đến java 17 nâng cấp thành: ![image](https://github.com/user-attachments/assets/1892a82c-2bc0-413c-b957-80fcbd692c54)
- ![image](https://github.com/user-attachments/assets/86c83e94-16ea-4d15-ad82-a8a522fe5ab6)
- An toàn hơn: biến s chỉ tồn tại trong khối if. và dễ đọc hơn

## 4. Switch Expressions (đã ổn định từ Java 14)
- -> thay cho :
- switch cũ:
  + ![image](https://github.com/user-attachments/assets/6965418d-9070-4589-8b30-d449fce70026)
- Swtich mới
  + Gom nhiều nhánh: ![image](https://github.com/user-attachments/assets/2f45e612-cf63-4f74-99ad-706f05788b5c)
  + Thêm từ khóa **yield**: được dùng như một biểu thức (tức là có trả về giá trị), Và nhánh case có nhiều dòng lệnh (phải dùng { } block).![image](https://github.com/user-attachments/assets/c2d88dd5-cce6-4fed-8345-77c855192822)

## 5. New Foreign Function & Memory API (Preview)
- Dùng để Gọi hàm native (C/C++) một cách an toàn và dễ dàng hơn so với JNI
- Trước đây, nếu muốn gọi hàm từ thư viện C/C++ trong Java → phải dùng JNI (Java Native Interface), nhưng:
  + JNI khó viết, dễ lỗi
  + Không an toàn về bộ nhớ
  + Hiệu suất thấp, khó bảo trì
- FFM API là nỗ lực của Java để thay thế JNI bằng một API an toàn, hiệu quả và rõ ràng hơn.

## 6. Text Blocks (Java 15)
- Nó chính là đoạn String trong """"""
- Trước đây: ![image](https://github.com/user-attachments/assets/46165956-7f92-44bb-8b62-e3d5e149d684)
  + khi muốn tạo 1 chuỗi spring thì phải thêm \n, \t các kiểu
- Với java 17: Viết chuỗi nhiều dòng như thật, Không cần \n, \", +, Dễ đọc, dễ bảo trì
  + ![image](https://github.com/user-attachments/assets/f26260d7-1fc9-4a6b-b643-940e9f1ba26c)
  + Ứng dụng nhiều chỗ, quan trọng là có thể viết native query trong jpa liền mạch ![image](https://github.com/user-attachments/assets/3dbc32e0-9913-40c5-ad07-36f9c3856e26)

## 7. Enhanced pseudo-random number generators (JEP 356)
- Giới thiệu Giới thiệu API Random mới: java.util.random => nhanh mạnh hơn, nhiều tính năng hơn
- ![image](https://github.com/user-attachments/assets/cd50403c-888e-4572-9b86-90705480c55c)
