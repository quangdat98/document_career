# ** ------ Tóm Tắt ------ **

1. Tài liệu tham khảo
2. Các đặc điểm
3. Các thành phần của JDK 
4. Cú pháp (biến, kiểu dữ liệu, vòng lặp, điều kiện, java string)
5. Các tính chất OOP
6. Các khái niện OOPs
7. Interface & abstract class
8. Exception handling


# **  ------ Nội dung chi tiết ------ **

## *** 1. Tài liệu tham khảo ***
### 1.1 Link khóa học online
  - Link all: https://www.codecademy.com/catalog/language/java
  - Link advanced: https://www.codecademy.com/learn/learn-advanced-java
  - Sơ đồ master java: https://coggle.it/diagram/X-dDo1Qdf7DCP2zg/t/how-to-master-java/a3c8bede6822097b7f3c6340b82eabd7986c57af4d42f11c122d5065479d5928
### 1.2 Link doc
  - https://www.geeksforgeeks.org/java/?ref=lbp
  - https://www.tutorialspoint.com/java_technology_tutorials.htm
  - https://itguru.vn/blog/cac-cong-nghe-lap-trinh-vien-java-nen-hoc/
  - Link doc oracle: https://docs.oracle.com/en/java/index.html
## ** 2. Các đặc điểm **
===> Tài liệu tham khảo <===
  - [Chưa có]
### 2.1 Các tính năng
  - Độc lập nền tảng (platform independence): java có thể chạy trên nhiều hệ điều hành khác nhau (windows, macos, linux) nhờ JVM
  - Hướng đối tượng: Luân tuân theo nguyên tắc OOP. Mọi thứ trong java đều là object (trừ các kiểu nguyên thủy)
  - Đơn giản và dễ học: Khá giống với C++ nhưng loại bỏ các phần phức tạm VD như con trỏ. Có thư viện phong phú giúp giảm bớt việc coding (lombok)
  - Hiệu suất cao: JIT Compiler (Just-In-Time Compiler) giúp biên dịch bytecode thành mã máy ngay lúc chạy, tăng tốc độ thực thi. Java hỗ trợ NIO (New Input/Output), Streams API, Lambda Expressions, giúp tối ưu xử lý dữ liệu.
  - Bảo mật: Java không sử dụng con trỏ, giúp tránh lỗi truy cập bộ nhớ trái phép. Cơ chế Garbage Collection giúp tránh lỗi rò rỉ bộ nhớ. (Con trỏ là một biến chứa địa chỉ bộ nhớ của một biến khác. Trong nhiều ngôn ngữ lập trình như C/C++, con trỏ có thể được sử dụng để thao tác trực tiếp với bộ nhớ, điều này có thể dẫn đến các lỗ hổng bảo mật như tràn bộ đệm (buffer overflow). Java không hỗ trợ con trỏ tường minh, nghĩa là lập trình viên không thể trực tiếp truy cập và thao tác địa chỉ bộ nhớ. Thay vào đó, Java sử dụng các tham chiếu để truy cập các đối tượng, giúp giảm thiểu nguy cơ bảo mật liên quan đến con trỏ.)
  - Java là ngôn ngữ vừa thông dịch vừa biên dịch. Mã nguồn(.java) được javac biên dịch thành mã bytecode(.class). JVM sẽ thông dịch bytecode thành mã cụ thể phù hợp với hệ điều hành.

## *** 3. Các Thành phần của JDK ***
===> Tài liệu tham khảo <===
  - https://niithanoi.edu.vn/hieu-ngay-may-ao-java-jvm-va-kien-truc-cua-may-ao-java.html
  - Link setup: https://www.geeksforgeeks.org/download-and-install-java-development-kit-jdk-on-windows-mac-and-linux/
  - ![image](https://github.com/user-attachments/assets/6f3c024f-5cb6-4655-98bd-f9ed47774c05)
  - ![image](https://github.com/user-attachments/assets/87fb9c18-f8c5-41ac-afc8-2973843292b5)


### 3.1 JDK
  - JDK (Java Development Kit) là bộ công cụ giúp lập trình viên phát triển, biên dịch và chạy ứng dụng Java. Nó bao gồm JRE, trình biên dịch (javac), thư viện, công cụ gỡ lỗi, và các công cụ khác.
  - ![image](https://github.com/user-attachments/assets/b290f0e4-9fa4-431e-a349-741b549fae24)
  - JDK được triển khai trên các nền tảng java khác nhau do oracle corporation phát hành:
    + Java SE (Java Standard Edition): Là phiên bản cơ bản của Java Platform, chạy các ứng dụng Java trên các máy tính và máy chủ thông thường.
    + Java EE (Java Enterprise Edition): Là phiên bản được tối ưu hóa cho việc phát triển các ứng dụng doanh nghiệp lớn, có khả năng mở rộng và có tính sẵn dùng cao như ứng dụng web, ứng dụng phân tán hay các ứng dụng doanh nghiệp…
    + Java ME (Java Micro Edition): Được tối ưu hóa cho việc phát triển các ứng dụng di động và nhúng
    + Java Card: Là một phiên bản được thiết kế cho các thiết bị bảo mật như thẻ thông minh và các thiết bị mạng.
    + JavaFX: Là phiên bản để phát triển các ứng dụng đồ họa trên nền tảng Java
  - JDK cung cấp các công cụ quan trọng để lập trình Java:
    + `javac – Trình biên dịch Java, chuyển mã nguồn .java thành .class (bytecode).`
    + java – Chạy chương trình Java từ bytecode .class.
    + jar – Công cụ đóng gói file .class thành file .jar để phân phối.
    + javadoc – Sinh tài liệu API từ comment trong code (/** ... */).
    + jlink – Tạo JRE tùy chỉnh chỉ chứa những module cần thiết.
    + ...
  - JDK đi kèm với hàng nghìn class và API giúp lập trình viên viết ứng dụng nhanh chóng (Các thư viện này góp mặt trong JRE). Một số thư viện quan trọng:
    + java.lang – Chứa các class cơ bản như String, Math, Object.
    + java.util – Collection Framework (List, Set, Map), xử lý thời gian (LocalDate, DateTimeFormatter).
    + java.io & java.nio – Xử lý file, stream, I/O hiệu suất cao.
    + java.net – Hỗ trợ lập trình mạng (Socket, HTTP).
    + java.sql – Hỗ trợ kết nối database (JDBC).
    + java.security – Bảo mật, mã hóa dữ liệu.
    + ...
      
### 3.2 JRE (Java Runtime Environment) - Môi trường chạy Java
  - JRE giúp chạy các ứng dụng Java, bao gồm:
    + JVM (Java Virtual Machine): Máy ảo Java, thực thi bytecode.
    + Core Libraries (Thư viện cốt lõi): Chứa các class cần thiết như java.lang, java.util, java.io,...
    + Java Class Loader: Load các class vào JVM khi chạy.
    + (chú ý: nếu muốn chạy ứng dụng java chỉ cần JRE mà không cần JDK, Không có JRE riêng có thể tùy trỉnh bằng jlink - chưa tìm hiểu được)
  - Đầu vào của JRE thường là file jar.
    
### 3.3 JVM - máy ảo
===> Tài liệu tham khảo <===
  - https://viblo.asia/p/jvm-memory-structure-amoG84j6Gz8P
  - ![image](https://github.com/user-attachments/assets/2405758f-5d0c-48b2-8f44-90d25f1bfe91)
  - JVM (Java Virtual Machine) là một máy ảo giúp chạy các ứng dụng Java bằng cách chuyển đổi bytecode thành mã máy phù hợp với hệ điều hành.
  - Chức năng chính:
    + Biên dịch & thực thi mã Java (từ .class → mã máy)
    + Quản lý bộ nhớ (cấp phát & thu hồi bộ nhớ)
    + Tối ưu hiệu suất (JIT, Caching)
    + Đảm bảo tính độc lập nền tảng (Write Once, Run Anywhere - WORA)
    + Gồm 3 phần chính: Class Loader (Bộ nạp lớp), Runtime Data Area (Vùng dữ liệu thời gian chạy), Execution Engine (Bộ thực thi)
  - Class Loader (Bộ nạp lớp)
    + Nạp bytecode .class vào bộ nhớ (Bootstrap ClassLoader (nạp các thư viện chuẩn của Java), Extension ClassLoader (nạp các thư viện mở rộng), Application ClassLoader (nạp các class do lập trình viên viết))
    + Kiểm tra và xác minh tính hợp lệ của mã
  - Runtime Data Area (Vùng dữ liệu thời gian chạy)
    + Runtime data areas chính là Memory được phân khi máy ảo Java chạy trên hệ điều hành
    + Memory của JVM được chia làm 5 phân vùng khác nhau, đó là PC Registers, Java stacks, Native method stacks, Heap, và Method area
  - Execution Engine (Bộ thực thi)

  
### 3.4 Quá trình JRE làm việc như thế nào???
  - ![image](https://github.com/user-attachments/assets/0d1f0158-7e11-4442-bf7d-7cb658fcd4c0)
  - Load mã bytecode vào bộ nhớ:
    + JRE nhận file .class hoặc .jar (chứa bytecode) và tải chúng vào bộ nhớ RAM.
    + Class Loader đọc các .class từ file hệ thống, JAR, hoặc mạng. (Class Loader làm việc theo 3 giai đoạn chính: Loading: Tải bytecode của class vào JVM => Linking: Kiểm tra và chuẩn bị class để chạy => Initialization: Chạy các khối static (static {}) và cấp phát bộ nhớ.) 
  - JVM dịch bytecode sang mã máy (Just-In-Time Compilation - JIT):
    + JVM không chạy trực tiếp bytecode mà cần dịch nó sang mã máy phù hợp với hệ điều hành.
    + JVM dùng Interpreter để dịch từng dòng bytecode sang mã máy.Nếu một đoạn mã được chạy nhiều lần.
    + JIT Compiler sẽ tối ưu hóa và biên dịch thành mã máy để tăng tốc độ.
  - Quản lý bộ nhớ và Garbage Collection:
    + JVM cấp phát bộ nhớ cho đối tượng trong Heap Memory.
    + Khi một đối tượng không còn được sử dụng, Garbage Collector (GC) sẽ tự động thu hồi để tránh rò rỉ bộ nhớ.
  - Giao tiếp với hệ điều hành:
    + JVM sử dụng Java Native Interface (JNI) để gọi các hàm hệ thống như đọc/ghi file, quản lý luồng (thread), kết nối mạng.
    + VD: Khi chương trình cần in ra màn hình hoặc ghi vào file: VM gọi thư viện Java (System.out.println() → java.io.*). JVM dùng JNI để gọi API hệ điều hành (printf() trên Linux, WriteConsole() trên Windows).
### 3.5 JRE và Java Platform Independence
  - JRE giúp Java chạy trên nhiều nền tảng khác nhau nhờ JVM.
  - Java không biên dịch thành mã máy (Machine Code) trực tiếp như C/C++.
  - Thay vào đó, nó biên dịch thành bytecode (.class), chạy trên JVM.
  - JVM trên Windows, Linux, macOS khác nhau, nhưng tất cả đều hiểu bytecode chung.
=> Nhờ đó, chương trình Java có thể chạy trên mọi hệ điều hành mà không cần biên dịch lại. 🚀
### 3.6 Just-In-Time (JIT) Compilation
  - Là một kỹ thuật tối ưu trong JVM giúp tăng tốc độ thực thi của java bằng các biên dịch bytecode thành mã máy ngay khi chương trình chạy.
  - Khi JVM chạy thì nó thông dịch từng dòng bytecode nếu JVM phát hiện 1 đoạn code chạy nhiều lần (ví vụ vòng lăp) thì nó sẽ kích hoạt JIT compiler. JIT sẽ biên dịch bytecode thành mã máy một lần và JVM sẽ tái sử dụng mã này => chương trình chạy nhanh hơn.
  - Có thể tắt JIT compiler: java -Xint MyApp
  - ![image](https://github.com/user-attachments/assets/820eadf8-dab4-4669-8402-c6d235ecd4c8)
  - Chỉ định số lần 1 phương thức cần được gọi trước khi JIT biên dịch nó: java -XX:CompileThreshold=10000 MyApp (MyApp là tên lớp chứa hàm main)
  - Bật chế độ tối ưu hiệu suất cao. Có 2 loại chính : C1 (Client Compiler) và C2 (Server Compiler). Nếu không chọn gì thì JVM sẽ tự chọn
    + C1 (Client Compiler): Tối ưu hóa nhanh nhưng không quá sâu (dùng cho ứng dụng nhỏ): java -server MyApp
    + C2 (Server Compiler): Tối ưu hóa mạnh hơn (dùng cho ứng dụng lớn, server): java -client MyApp
  - Kích hoạt chế độ tối ưu nâng cao: java -XX:+TieredCompilation MyApp
    + JVM sẽ kết hợp cả C1 và C2 để tăng hiệu suất.
    + Ban đầu: Sử dụng C1 để khởi động nhanh.
    + Sau đó: Chuyển sang C2 để tối ưu mạnh hơn.
  - Tắt tính năng tối ưu hóa của JIT: java -XX:-DoEscapeAnalysis MyApp 

### 3.7 JVM Performance Tuning
### 3.8 ClassLoader & Dynamic Class Loading













































































