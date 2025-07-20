# 1.1 Giới thiệu
- Trang web chính thức: https://www.python.org/

# 2. Hello world

## 2.1 cài đặt môi trường
- Kiểm tra version: python --version
- sudo apt update
- sudo apt upgrade -y
- sudo apt install python3 -y
- Cài đặt pip (trình quản lý thư viện của Python): sudo apt install python3-pip -y
-  Cài python-is-python3 (Để dùng lệnh python thay vì python3): sudo apt install python-is-python3 -y
-  Kiểm tra version: python --version

## 2.2 Cài đặt tool vs code
- chúng ta dùng Visual code

# 3 Cú pháp
- print 'hello world' -> file đôi .py -> để chạy python hello.py

## 3.1 Biến số
- Khai báo biến bằng 1 lệnh gán: a = 1
- Cũng có thể gán nhiều loại giá trị (số, chuỗi) cho một biến:
  + a = 1
  + a = 'hello'
  + a = [1,2,3,4]
  + a = [1,2, 'hello', 'w',2]
  + <img width="791" height="413" alt="image" src="https://github.com/user-attachments/assets/8792bbe8-c46f-4016-8bb4-6b627dc921b8" />

## 3.2 Toán tử số học, boolean, logic
- '+, -, *, /, %'
- <img width="856" height="221" alt="image" src="https://github.com/user-attachments/assets/384a06e8-a47f-4f8c-be3e-0e4ac6fbef88" />
- <img width="799" height="291" alt="image" src="https://github.com/user-attachments/assets/1a9df0b9-b540-41be-9f06-019bbfc5b17e" />
- <img width="779" height="316" alt="image" src="https://github.com/user-attachments/assets/b2233b43-e910-43b8-a789-44bdd67901e1" />

## 3.3.1 Cấu trúc điều kiển
 - Các cấu trúc điều khiển đều thụt đầu dòng để tạo thành 1 block xử lý thay vì sử dụng {}
 - if-elif-else:
 - <img width="859" height="375" alt="image" src="https://github.com/user-attachments/assets/54211b02-300d-4e35-877a-04bffbbeaaef" />

## 3.3.2 swtich case
- Trong python ko có switch case

## 3.3.3 for in 
- Tóm tắt: <img width="717" height="255" alt="image" src="https://github.com/user-attachments/assets/bf07731a-45e5-4929-8fdf-24fe03504228" />
- <img width="866" height="488" alt="image" src="https://github.com/user-attachments/assets/11db2eac-f67c-45ab-b109-ae2e91a789cd" />
- dùng enumerate để vừa lấy phần tử vừa lấy index: <img width="808" height="404" alt="image" src="https://github.com/user-attachments/assets/42e7fb7e-f970-4f67-9f4e-ba3ef7a08c74" />
  + <img width="840" height="358" alt="image" src="https://github.com/user-attachments/assets/8632f7ac-4d5b-45cf-8f9b-c20f31015996" />
## 3.3.4 while
- <img width="845" height="411" alt="image" src="https://github.com/user-attachments/assets/bddbfc64-88b1-495c-b856-efeb58b2ca47" />

## 3.4 Hàm
- Hàm là một khối mã có thể tái sử dụng, dùng để thực hiện một nhiệm vụ cụ thể. Bạn có thể định nghĩa hàm một lần và gọi lại nhiều lần.
- <img width="897" height="218" alt="image" src="https://github.com/user-attachments/assets/ee4f394a-a2ec-4abf-9ed4-e527f2bc473b" />
- Hàm không có kiểu trả về: <img width="882" height="441" alt="image" src="https://github.com/user-attachments/assets/e2e4a7d3-66e9-46d9-8916-b3e70f0a2811" />
- Hàm có kiểu trả về: <img width="868" height="329" alt="image" src="https://github.com/user-attachments/assets/ad6cb88e-a5ef-4fe4-b6dd-7cdd2a319d5d" />
- <img width="871" height="256" alt="image" src="https://github.com/user-attachments/assets/baeaf6f7-6309-48df-9f5c-f3de4468d4d6" />
- hàm có tham số mặc định: <img width="817" height="328" alt="image" src="https://github.com/user-attachments/assets/289aa7e2-ce22-4dab-a410-98d0d9659c67" />
- **Chú ý: Các tham số có mặc định phải đặt sau tham số không mặc định.**
- **Nếu không có mặc định thì bắt buộc phải truyền tham số**

# 3.5 xử lý chuỗi

- <img width="329" height="105" alt="image" src="https://github.com/user-attachments/assets/d8234ee2-6f0f-4ada-bd89-1dace0895cb4" />
- <img width="474" height="143" alt="image" src="https://github.com/user-attachments/assets/24e9cb68-0019-46b2-a79e-58f29ecb34be" />
- **Trích xuất chuỗi con**
  + [start:end]: start bắt đầu từ 0, end là đến vị trí cuối chuỗi <img width="812" height="276" alt="image" src="https://github.com/user-attachments/assets/adc48cc4-7cd1-419a-8dac-d6bd7b27a16e" />
-**Lấy độ dài của chuỗi: len()**
-**Tìm và thay thế nội dung: replace**
  + Dạng 1: dùng replace("","")
  + Dạng 2: set số lượng replace: .replace("text1,"text2",3) -> thay 3 text1 thành 3 text2. <img width="804" height="300" alt="image" src="https://github.com/user-attachments/assets/1e5b2fb6-a686-48b4-8b97-b0515fe4d28b" />
-**Tìm vị trí chuỗi con: find**
  + Băt đầu từ vị trí 0, nếu không tìm ra thì trả về -1. <img width="383" height="248" alt="image" src="https://github.com/user-attachments/assets/996450af-10a3-4d2e-97dc-120a41db1c31" />
-**Tìm vị trí cuối cùng chuỗi con: rfind**
  + <img width="615" height="190" alt="image" src="https://github.com/user-attachments/assets/6b24230b-8c54-4e3e-8423-93f856913fb4" />
-**Tìm vị trí chuỗi con: in**
  + <img width="805" height="307" alt="image" src="https://github.com/user-attachments/assets/e97679f0-9fda-49b1-94e0-dc3e93308768" />
-**Tìm vị trí chuỗi con: index** : giống với find nhưng nếu ko tìm thấy thì sẽ trả ra lỗi
-**Tìm vị trí chuỗi con:count**: đếm số lần xuất hiện của chuỗi con
  + <img width="734" height="224" alt="image" src="https://github.com/user-attachments/assets/3f6c9c8e-9266-4e40-b0de-d65a50d2fbe7" />
-**Tìm vị trí chuỗi con:re**: rìm bằng biểu thức chính quy
  + <img width="607" height="340" alt="image" src="https://github.com/user-attachments/assets/6a3ba507-0b52-42f5-9ae6-66cb20029ddc" />

=>**Tóm tắt:** <img width="786" height="387" alt="image" src="https://github.com/user-attachments/assets/87c40096-c53c-49d3-8216-4862d114fb0c" />




