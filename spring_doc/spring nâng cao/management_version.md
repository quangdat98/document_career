## 1. Nâng version
- Có một bài toán là khi chúng ta nâng cấp version của thư viện như là của spring boot thì cần phải tính đến ảnh hưởng tới dự án như thế nào?
- Công cụ kiểm tra: mvn dependency:tree -Dverbose=true => Sẽ liệt kê chi tiết các version, thông tin conflict, duplicate.
- mvn dependency:tree => version nào đã được spring chọn.

## 2. Mức độ thay đổi của version
- VD: 2.17.1
  + MAJOR = 2 → Thay đổi lớn, có thể phá vỡ tương thích (breaking changes)
  + MINOR = 17 → Tính năng mới, tương thích với bản trước
  + PATCH = 1 → Sửa lỗi (bug fix), không thay đổi hành vi

- ![image](https://github.com/user-attachments/assets/cf49de0e-fa5b-4b19-93fd-316764f164b0)
