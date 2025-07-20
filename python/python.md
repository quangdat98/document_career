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
- Dùng: f-string: print(f'Xin chào {self.name}, bạn có tuổi là {self.age}')

## 3.5.1 Trích xuất chuỗi con
  + [start:end]: start bắt đầu từ 0, end là đến vị trí cuối chuỗi <img width="812" height="276" alt="image" src="https://github.com/user-attachments/assets/adc48cc4-7cd1-419a-8dac-d6bd7b27a16e" />
## 3.5.2 Lấy độ dài của chuỗi: len()
- <img width="408" height="103" alt="image" src="https://github.com/user-attachments/assets/6c7d1aa5-6b8d-440d-911b-9949ef109363" />

## 3.5.3 Tìm chuỗi 
-**Tìm và thay thế nội dung: replace**
  + Dạng 1: dùng replace("","")
  + Dạng 2: set số lượng replace: .replace("text1,"text2",3) -> thay 3 text1 thành 3 text2. <img width="804" height="300" alt="image" src="https://github.com/user-attachments/assets/1e5b2fb6-a686-48b4-8b97-b0515fe4d28b" />
-**Tìm vị trí chuỗi con: find**
  + Băt đầu từ vị trí 0, nếu không tìm ra thì trả về -1. <img width="383" height="248" alt="image" src="https://github.com/user-attachments/assets/996450af-10a3-4d2e-97dc-120a41db1c31" />
  + <img width="854" height="219" alt="image" src="https://github.com/user-attachments/assets/85dd830a-0009-46b6-8fcc-5162661e443d" />

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

## 3.5.3 Trim và tách chuỗi
-**tách chuỗi**
 + <img width="745" height="168" alt="image" src="https://github.com/user-attachments/assets/4bd1f3f4-ffcd-4ea7-91cd-67024ff234f8" />

-**Trim ky tự khoảng trắng**
 + <img width="852" height="212" alt="image" src="https://github.com/user-attachments/assets/05ccf34e-304b-471a-ae77-fceec3cf6dbe" />
 + strip() -> loại bỏ 2 đầu
 + lstrip() -> loại bỏ phía trước
 + rstrip() -> loại bỏ phía sau

## 3.5.4 Mộ số hàm xử lý chuỗi
- **isnumeric()**:  kiểm tra một chuỗi có phải là chuỗi số hay ko
  + <img width="852" height="212" alt="image" src="https://github.com/user-attachments/assets/a39532a9-9f45-459a-b18c-50e1e8bf1a12" />

- **lower()**: chuyển chuỗi thành chữ thường
- **upper()**: chuyển chuỗi hết thành chữ hoa


# 3.6 List
- list là kiểu dữ liệu dạng mảng có thể chứa nhiều phần tử và có thể thay đổi được (mutable).
- Đặc biệt trong truy suất là có thể truy xuất âm, phần tử cuối là -1 lần lượt -2,-3: <img width="852" height="212" alt="image" src="https://github.com/user-attachments/assets/1f577d12-4f77-431a-bb6f-a08b5437632f" />
- Duyệt list: <img width="486" height="220" alt="image" src="https://github.com/user-attachments/assets/12fcbb91-d7f9-4550-8834-9b5bb33bd80d" />
- my_list.reverse()	Đảo ngược
- my_list.clear()	Xóa hết phần tử
- "a" in my_list	Kiểm tra có "a" hay không -> ngược lại dùng "not in"
- Nối 2 mảng: <img width="428" height="167" alt="image" src="https://github.com/user-attachments/assets/a4904d0d-0171-4ce4-9c6e-ee6dfc1a8c04" />


## 3.6.1 Thêm phần tử
- Thêm vào cuối danh sách: my_list.append(5)
- Thêm theo vị trí: my_list.insert(2, 10)     # Thêm 10 vào vị trí index = 2 <img width="852" height="212" alt="image" src="https://github.com/user-attachments/assets/c3b5354d-7938-4fd4-bd46-e0134e29a93f" />

## 3.6.2 xóa phần tử
- my_list.remove(3)     # Xóa giá trị 3 đầu tiên gặp
- my_list.pop()         # Xóa phần tử cuối (lấy phần tử và xóa nó ra khỏi mảng)
- my_list.pop(1)        # Xóa phần tử tại index = 1
- del my_list[0]        # Xóa phần tử index 0
- del number[start:end] # xóa phần tử dựa theo start và end

## 3.6.3 copy list
- <img width="309" height="90" alt="image" src="https://github.com/user-attachments/assets/21d13413-73e2-4d89-9d8c-27819c64df98" />

## 3.6.4 trích xuất bảng con
- <img width="512" height="239" alt="image" src="https://github.com/user-attachments/assets/b30c94a9-bdd6-4115-b587-f484b398a085" />

## 3.6.5 sắp xếp mảng 1 chiều
- <img width="434" height="255" alt="image" src="https://github.com/user-attachments/assets/52c504e6-3ef6-4e10-a30d-50ee4f9e5af8" />
- dùng sorted để tạo 1 mảng sắp xếp khác: <img width="494" height="336" alt="image" src="https://github.com/user-attachments/assets/98d24fd6-d2f3-469b-9ef3-019773f0b5b4" />
- **Sắp xếp theo tiêu chí tùy chọn**
  + đội dài len: <img width="467" height="98" alt="image" src="https://github.com/user-attachments/assets/479fa507-ff6d-4377-bb03-d66660a63416" />
  + sắp xếp ko phân biệt hoa thường: <img width="493" height="94" alt="image" src="https://github.com/user-attachments/assets/011b9949-de89-4355-b815-31052e43f681" />

# 3.7 Tuple
- Tuple là một kiểu dữ liệu dạng danh sách cố định, giống như list nhưng không thể thay đổi sau khi tạo ra. VD: my_tuple = (1, 2, 3)
- <img width="418" height="265" alt="image" src="https://github.com/user-attachments/assets/e329b590-8c1a-4951-961a-b1d2e07b798b" />

# 3.8 Dictionary
- Dictionary (gọi tắt là dict) là kiểu dữ liệu ánh xạ (key -> value) — giống như một từ điển thật: bạn tra từ khóa (key) để lấy nghĩa (value). (nó giống với json)

## 3.8.1 khởi tạo
- <img width="268" height="134" alt="image" src="https://github.com/user-attachments/assets/53ef79f1-8cdb-4667-8c23-aac621ad1fde" />
- Tạo dict bằng dict() hoặc từ list of tuple: <img width="322" height="60" alt="image" src="https://github.com/user-attachments/assets/3bb89268-f7c3-46fd-bdaf-8f2e0a6e17cf" />
- fromkeys(): tạo 1 dict mới từ danh sách key với cùng một giá trị mặc định
  + <img width="481" height="315" alt="image" src="https://github.com/user-attachments/assets/6e17dec5-5a85-4d5f-b03f-ef0bb6e906d6" />
  + <img width="381" height="344" alt="image" src="https://github.com/user-attachments/assets/fcd212be-972d-46a7-9635-bf498856057b" />



## 3.8.2 truy cập giá trị theo key
- print(person["name"])
- Truy cập an toàn bằng .get(): print(person.get("name"))       # 👉 Dat
- Thêm hoặc cập nhật phần tử:
  + person["email"] = "dat@example.com"  # Thêm mới
  + person["age"] = 26                   # Cập nhật
- Xóa phần tử:
  + del person["city"]         # Xóa theo key
  + person.pop("email")        # Xóa và trả về giá trị
  + person.clear()             # Xóa hết

## 3.8.2 Duyệt
- <img width="405" height="268" alt="image" src="https://github.com/user-attachments/assets/9f94451c-2e48-4da8-952b-a41740ad0fef" />

## 3.8.3 Dict lồng nhau
- <img width="404" height="127" alt="image" src="https://github.com/user-attachments/assets/c65af675-187d-43d6-885c-de7d46becb00" />

# 4. Phân chia module
- **Sơ cấp**: chúng ta dùng import [ten file]
  + <img width="308" height="107" alt="image" src="https://github.com/user-attachments/assets/75f02147-8716-4f5d-9f20-254c916acdad" /> <img width="419" height="145" alt="image" src="https://github.com/user-attachments/assets/990afe4b-5a3e-47bc-9744-379d5140f3a6" />
- Các cách import: <img width="651" height="175" alt="image" src="https://github.com/user-attachments/assets/cb2db809-954b-4ba7-8aef-76fea547aeca" />
-**Phân chia thành nhiều file/module**
  + cách 1: import utils.math_utils as t  => chỉ cần t.method là dùng được
  + Cách 2: là import cả hàm và chung ta chỉ cẩn gọi hàm là dk => from utils.string_utils import calLen
  + <img width="463" height="189" alt="image" src="https://github.com/user-attachments/assets/493eb516-299c-4ad8-94d6-8d370eac2f80" />
- Cách liệt kê các thuộc tích của các đối tượng:
  + print(dir("hello"))     # liệt kê thuộc tính của string
  + print(dir([]))          # list
  + print(dir({}))          # dict

# 5. Class
- Cú phám <img width="604" height="368" alt="image" src="https://github.com/user-attachments/assets/eafab76a-cd9f-49ec-ab88-5fa586e934a5" />
  + __init__: là contructor, chạy tự động khi tạo object
  + self: giống this trong java
- <img width="358" height="107" alt="image" src="https://github.com/user-attachments/assets/f6f5de8e-43e4-4e92-8435-e13edd7da6c2" />

# 5.1 kế thừa 
- Cú pháp: class child(patent):
- VD: <img width="889" height="431" alt="image" src="https://github.com/user-attachments/assets/270d7596-8c36-45a7-9fce-5d21c30ae11e" />

# 6. Xử lý tệp tin
# 7. xử lý hình ảnh
# 8. xử lý json
# 9. xử lý xml
# 10. Kết nối sql
# 11. Kết nối redis
# 12. Kết nối Memcached
# 13 Kết nối RabbitMQ
# 14. Restful client
# 15. Gửi mail với SMTP
# 16. Socket programming



