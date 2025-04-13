## 1. Redis là gì?
**1.1 Khái niệm**
- Redis là một cơ sở dữ liệu nguồn mở lưu trữ dữ liệu theo dạng key-value.
- Redis cũng thường được gọi là server lưu trữ các cấu trúc dữ liệu (data structure server) do các khóa có thể bao gồm các dữ liệu kiểu strings, hashes, lists, sets và sorted sets.
- Redis được lưu trữ key-value trên RAM với hiệu năng cao, **redis còn hỗ trợ lưu trữ dữ liệu trên đĩa cứng (persistent redis) cho phép phục hồi dữ liệu khi gặp sự cố**
**1.2 Ưu điểm**
- Redis hỗ trợ add, update, delete dữ liệu một cách nhanh chóng.
- Dữ liệu được lưu trữ trên RAM giúp việc truy xuất dữ liệu một cách nhanh chóng. Ngoài ra bạn có thể cấu hình để Redis có thể lưu trữ dữ liệu trên ổ cứng.
- Bạn có thể cấu hình cho key tự động xoá trong khoảng thời gian nhất định(expire)
- Hỗ trợ Queue(hàng đợi) thông qua cơ chế PUB/SUB, chúng ta có thể dùng Redis để làm hệ thống queue cho website xử lý tuần tự từng request.
**1.3 Các kiểu dữ liệu**
- String
- List
- Set
- Hash
- Zset

## 2. Cài đặt Redis
- Cài đặt trên ubuntu: sudo apt update -> sudo apt install redis-server -y
- Kiểm tra redis đã cài thành công hay chưa: redis-cli ping (PONG là đã thành công)
- Kiểm tra trạng thái redis: sudo systemctl status redis
- Cho phép Redis khởi động cùng hệ thống: sudo systemctl enable redis-server
- Cấu hình redis: **/etc/redis/redis.conf**
  + Ví dụ để kết nối từ xa thì sửa dòng **bind 127.0.0.1 ::1 -> bind 0.0.0.0** và **protected-mode yes -> protected-mode no** => sau đó dùng redid từ xa sudo ufw allow 6379
  + Sau đó khơi động lại redis: sudo systemctl restart redis
  + protected-mode (chế độ bảo vệ) trong Redis là một tính năng bảo mật quan trọng được thiết kế để ngăn Redis bị truy cập trái phép từ mạng bên ngoài, đặc biệt khi bạn chạy Redis mà không đặt mật khẩu.![image](https://github.com/user-attachments/assets/6f8b550e-f3f4-433f-8b7f-ad8de5701483)

## 3. Các config redis
- requirepass: Bảo vệ Redis khỏi truy cập trái phép từ bên ngoài → tránh bị xóa toàn bộ dữ liệu hoặc chiếm quyền điều khiển Redis
- ![image](https://github.com/user-attachments/assets/d4d818a5-8b5e-4e90-98d3-d52e67d37573)
- ![image](https://github.com/user-attachments/assets/98045c21-0cbc-45ae-b829-06506af318bf)

## 4. Redis AOF và RDB

## 5. Các lệnh trong redis: vào redis: redis-cli
**LỆNH CƠ BẢN (KEYS)**
- ![image](https://github.com/user-attachments/assets/1291940b-3036-49a4-b20f-06ce677b1b02)
- VD: ![image](https://github.com/user-attachments/assets/96efbcae-6af1-4e1e-b909-3e41f17a0c8b)
**STRING (CHUỖI)**
- ![image](https://github.com/user-attachments/assets/77444dee-b68d-4b63-825c-99c735cad861)
**LIST (DANH SÁCH)**
- ![image](https://github.com/user-attachments/assets/64d5ae16-0c9e-4720-aca6-e94cbf839329)
**SET (TẬP HỢP KHÔNG TRÙNG)**
- ![image](https://github.com/user-attachments/assets/ac9fc4a5-0cac-43d1-8bd2-b1b5b8061856)
**HASH (BẢNG HASH: GIỐNG OBJECT)**
- ![image](https://github.com/user-attachments/assets/a83c1690-b780-43dd-bb82-73bcfe7b5a64)
**ZSET (SORTED SET)**
- ![image](https://github.com/user-attachments/assets/ee5d7333-b2df-4810-a1c1-e3380c0e9abe)
**PUB/SUB (GIAO TIẾP REAL-TIME)**
- ![image](https://github.com/user-attachments/assets/4dca6443-af16-4d87-8913-23e82d9d0a0a)
**AOF/RDB và QUẢN TRỊ**
- ![image](https://github.com/user-attachments/assets/6a4c0a63-88f2-4b41-a4b0-f2b8c49f1671)
**AUTH (BẢO MẬT)**
- ![image](https://github.com/user-attachments/assets/2be32984-6d04-4501-b4db-744b8c7748f9)








