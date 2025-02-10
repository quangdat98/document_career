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
    + Nạp bytecode .class vào bộ nhớ (Bootstrap ClassLoader (nạp các thư viện chuẩn của Java java.lang.String, java.util.ArrayList, v.v.), Extension ClassLoader (tải các thư viện mở rộng của Java từ thư mục lib/ext.), Application ClassLoader (nạp các class do lập trình viên viết)), System ClassLoader (tải các lớp của ứng dụng bạn từ classpath (nơi bạn đặt các file .class hoặc .jar).)
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
  - Chỉ định số lần 1 phương thức cần được gọi trước khi JIT biên dịch nó: java -XX:CompileThreshold=10000 MyApp (MyApp là tên lớp chứa hàm main, hoặc có thể thêm vào câu lện build file jar: java -XX:-DoEscapeAnalysis -jar MyApp.jar)
  - Bật chế độ tối ưu hiệu suất cao. Có 2 loại chính : C1 (Client Compiler) và C2 (Server Compiler). Nếu không chọn gì thì JVM sẽ tự chọn
    + C1 (Client Compiler): Tối ưu hóa nhanh nhưng không quá sâu (dùng cho ứng dụng nhỏ): java -server MyApp
    + C2 (Server Compiler): Tối ưu hóa mạnh hơn (dùng cho ứng dụng lớn, server): java -client MyApp
  - Kích hoạt chế độ tối ưu nâng cao: java -XX:+TieredCompilation MyApp
    + JVM sẽ kết hợp cả C1 và C2 để tăng hiệu suất.
    + Ban đầu: Sử dụng C1 để khởi động nhanh.
    + Sau đó: Chuyển sang C2 để tối ưu mạnh hơn.
  - Tắt tính năng tối ưu hóa của JIT: java -XX:-DoEscapeAnalysis MyApp 

### 3.7 JVM Performance Tuning
  - Là quá trình tinh chỉnh các thông số của JVM để cải thiện hiệu suất ứng dụng java
  - Tối ưu Just-In-Time Compiler (mục 3.6)
  - Tối ưu Garbage Collection (Chapter 4)
  - Tối ưu bộ nhớ JVM (Heap Size)
    + ![image](https://github.com/user-attachments/assets/f8d0848b-3869-4dc9-be12-4afbbef430cb)
  - Tối ưu Thread và CPU Usage
    + ![image](https://github.com/user-attachments/assets/c6446124-245a-431c-a80e-cb0ef7213a23)

### 3.8 ClassLoader & Dynamic Class Loading
  - ClassLoader chịu trách nhiệm tải các lớp vào bộ nhớ khi JVM cần.
    + Khi bạn chạy ứng dụng Java, JVM sẽ không tự động biết lớp nào cần được sử dụng ngay lập tức. Vì vậy, khi JVM gặp một lớp mới (ví dụ bạn gọi một lớp MyClass trong mã), ClassLoader sẽ chịu trách nhiệm đi tìm và nạp lớp này vào bộ nhớ.
    + ClassLoader sẽ tìm lớp này trong classpath (nơi chứa các file .class hoặc file .jar).
    + Nếu lớp không có trong classpath, ClassLoader sẽ không thể tải và JVM sẽ báo lỗi (ClassNotFoundException).
  - Dynamic Class Loading giúp ứng dụng tải lớp khi cần thiết, tối ưu hóa bộ nhớ và hiệu suất.
    + Java hỗ trợ phương thức Class.forName() để thực hiện việc tải lớp động, khi bạn biết tên lớp trong thời gian chạy.
    + ![image](https://github.com/user-attachments/assets/575dde89-a5be-47ee-be8b-5423f37fafdd)
    + Bình thường khi run thì nếu để là new Dog() thì sau khi run lớp đó sẽ đk tải, còn dùng forName thì chạy đến mới tải (tải ở đây là ClassLoader tải vào JVM)
  - Custom ClassLoader cho phép bạn tự định nghĩa cách tải lớp từ các nguồn khác nhau (file, mạng, cơ sở dữ liệu).
    + Ngoài các loại mặc định ra (Bootstrap ClassLoader, Extension ClassLoader, System ClassLoader) thì cũng có thể tạo riêng 1 classloader
    + Phục vụ cho tính bảo mậ, muốn kiểm soat quá trình tải lớp và ngăn không cho lớp không mong  uốn được tải
    + Để tạo Custom ClassLoader, bạn cần kế thừa lớp ClassLoader và override phương thức findClass().
### 3.9 Tìm hiểu thêm
  - Máy ảo GraaIvm: https://www.oracle.com/hk/java/graalvm/what-is-graalvm/
  - Lý do phải cài các biến môi trường (java home)

## *** 4. Cú pháp ***
### 4.1 Cấu trúc cơ bản của một chương trình Java
  - Vì sao hàm main() phải là public static void:
    + public: Để JVM có thể gọi phương thức từ bên ngoài lớp.
    + static: Cho phép JVM gọi main() mà không cần tạo đối tượng của lớp chứa main()
    + void: Vì main() không trả về giá trị nào cho JVM.
    + String[] args: Để truyền tham số dòng lệnh vào chương trình.
  - Nếu không có main() thì chương trình java không chạy được
  - Lớp chứa main() có thể là final, nhưng điều này không ảnh hưởng đến hoạt động của chương trình.
  - String[] args (String... args) bắt buộc có để JVM nhận diện phương thức main(). Nếu không tìm thấy phương thức này, JVM sẽ không biết bắt đầu chạy chương trình từ đâu và sẽ báo lỗi. Bên cạnh đó thì nó còn để truyền biến vào chương trình, kiểu strinh dễ dàng ép kiểu sang kiểu khác.
### 4.2 Biến
  - Biến trong Java là một vùng nhớ được đặt tên, dùng để lưu trữ dữ liệu. Giá trị của biến có thể thay đổi trong suốt thời gian chạy chương trình.
  - ![image](https://github.com/user-attachments/assets/2356abe6-00d7-4649-b5cc-9f70d3634c70)
  - Biến local (biến cục bộ)
    + Biến local được tạo bên trong các phương thức, contructor, block và sẽ bị phá hủy khi kết thúc các phương thức, contructor và block.
    + Không được sử dụng "access modifier" khi khai báo biến local, các biến local được lưu trên vùng nhớ stack của bộ nhớ.
    + Cần khởi tạo giá trị mặc định cho biến local trước khi có thể sử dụng.
  - Biến instance (biến toàn cục)
    + Được khai báo bên trong lớp nhưng bên ngoài phương thức, biến instance được lưu trong bộ nhớ heap. Bộ nhớ được cấp phát riêng cho từng đối tượng
    + Biến instance có giá trị mặc định phụ thuộc vào kiểu dữ liệu của nó. Ví dụ nếu là kiểu int, short, byte thì giá trị mặc định là 0, kiểu double thì là 0.0d, ... Vì vậy, bạn sẽ không cần khởi tạo giá trị cho biến instance trước khi sử dụng.
  - Biến static (biến tĩnh)
    + Biến static được khai báo trong một class với từ khóa "static", phía bên ngoài các phương thức, constructor và block
    + Sẽ chỉ có duy nhất một bản sao của các biến static được tạo ra, dù bạn tạo bao nhiêu đối tượng từ lớp tương ứng
    + Biến static được lưu trữ trong bộ nhớ static riêng. Biến static được tạo khi chương trình bắt đầu chạy và chỉ bị phá hủy khi chương trình dừng.
  - Biến volatile: volatile đảm bảo biến luôn đọc từ bộ nhớ chính, tránh cache trong CPU.
    + ![image](https://github.com/user-attachments/assets/4f909473-63e9-4951-adc5-28443f569b22)
  - Biến transient: transient dùng trong Serializable để bỏ qua biến khi ghi đối tượng vào file.
  - Biến final: là hằng số, sau khi gán giá trị lần đầu tiên thì không thể thay đổi nữa. (không thế kế thừa và ghi đè phương thức final)

### 4.3 Kiểu dữ liệu
  - Java chia kiểu dữ liệu thành 2 nhóm chính là **Kiểu dữ liệu nguyên thủy (Primitive Data Types) ** và ** Kiểu dữ liệu tham chiếu  (Reference Data Types) **
  - ** Kiểu dữ liệu nguyên thủy **:
    + Có 8 kiểu dữ liệu nguyên thủy: boolean, byte, char, short, int, long, float, double.
    + bộ nhớ stack (ngăn xếp), lưu trữ giá trị thực thế -> truy xuất nhanh hơn
    + ![image](https://github.com/user-attachments/assets/dfcef19b-f77b-405c-aa74-3783c49f5c7f)
    + 1 byte = 8 bit
    + ![image](https://github.com/user-attachments/assets/f5f5e60f-d3cb-488e-af4b-2d4587e359ad)
    + Mỗi kiểu dữ liệu nguyên thủy đều có 1 lớp bao - wrapper class tương ứng cho phép bạn làm việc với các giá trị nguyên thủy như thể chúng là các đối tượng (ví dụ có thể null).
  - VD tính phạm vi: short là số nguyên 16 bit (2 byte). Máy tính lưu trữ số nguyên bằng hệ bù 2, nghĩa là : Nếu bit đầu tiên (MSB) = 0, số đó là dương.Nếu bit đầu tiên (MSB) = 1, số đó là âm.
    + Số lớn nhất, Khi tất cả 15 bit còn lại đều là 1, ta có: 0111 1111 1111 1111  (15 bit 1, MSB = 0) -> tính ra là 32767 (2^14+2^13+...2^0)
    + Số nhở nhất tính théo hệ bù 2(16 bit): 1000 0000 0000 0000. Đảo bit (bù 1) 0111 1111 1111 1111 cộng thêm 1 (bù 2) 1000 0000 0000 0000. => -32768
  -  ** Kiểu dữ liệu tham chiếu ** : các đối tượng, string, mảng, lớp trừu tượng và giao điện interface
    + Kiểu tham chiếu lưu trữ địa chỉ của đối tượng thay vì giá trị trực tiếp
    + ![image](https://github.com/user-attachments/assets/05b6b924-b785-4c9f-a161-89fa15a577b8)
    + == trong tham chiếu là so sánh địa chỉ bộ nhớ chứ ko phải nội dung, chúng ta phải dùng equals
    + Nếu tạo string bằng "" thì có thể dùng == vì giá trị "" mà giống nhau thì được lưu cùng địa chỉ, còn lại thì đều ko được. Vì dùng new là tạo đối tượng mới trên heap.
    + Nếu 2 object trỏ cùng 1 đại chỉ trên heap thì cả == và equals đều true: ![image](https://github.com/user-attachments/assets/037fba34-d027-4499-bae8-e0023bb512b8)
    + Với các class thì equals có kiểm tra cả địa chỉ lên nếu muốn dùng equals trong so sánh 2 object class thì nhớ override lại nha.
    + Cẩn thận với từ hóa new sẽ làm tốn nhiều bộ nhớ. Hãy tận dụng string pool.
  - Nếu chuyền tham chiếu và tham trị vào 1 hàm void có biến đổi thì chỉ có tham chiếu là thay đổi nội dung còng lại là ko đổi gì cả. (đây gọi là pass by value)
### 4.4 Ép kiểu
  - Với kiểu nguyên thủy: Ép kiểu tự động (widening casting): từ kích thước nhỏ sang to - không phải làm gì. Và Ép kiểu tường minh (Narrowing casting) là từ kích thước lớn sang nhỏ - có sai lệch.
    + ![image](https://github.com/user-attachments/assets/ff86d60b-bc6e-4dc7-a8db-80142219fbd9)
  - Với kiểu tham chiếu: Ép kiểu ngầm định - upcasting và ép kiểu tường minh - downcasting: 
    + upcasting - từ thằng con sang cha (kiểu là từ kích thứoc bé sang lowns0 -> luôn an toàn.
        + ![image](https://github.com/user-attachments/assets/ee447d9e-dd08-429f-8750-4bb6086be7e2)
    + downcasting - từ kiểu cha về con, yêu cầu cú pháp rõ ràng và cần kiểm tra instanceof nếu ko sẽ lỗi ClassCastException
        + ![image](https://github.com/user-attachments/assets/c49c19a1-6d0a-4195-9f59-0ca34c2e6b68)
  - boxing và Unboxing
    + Boxing(autoboxing) là kiểu nguyên thủy -> wrapper 1 cách tự động ![image](https://github.com/user-attachments/assets/d090f749-8ea3-448d-8eca-571753a107cd)
    + Unboxing chuyển đổi một đối tượng của lớp bao (wrapper class) thành giá trị kiểu dữ liệu nguyên thủy (primitive type) cần chú ý giá trị null có thể bị lỗi ![image](https://github.com/user-attachments/assets/0cca9ff5-a031-4ec9-98a1-0f629d3b11b1)
### 4.5 String && Toán Tử
  - String là một class trong Java nằm trong java.lang. Là Immutable (bất biến - nếu gán bằng giá trị khác thì giá trị cũ vẫn còn trong bộ nhớ -> rất an toàn với đa luồng), nghĩa là một khi tạo, giá trị của nó không thể thay đổi. Được lưu trong String Pool để tiếp kiệm bộ nhớ.
  - ![image](https://github.com/user-attachments/assets/089f5db6-816b-46da-a0b2-187aae935560)
  - String là một lớp đối tượng (object) thuộc gói java.lang, nhưng nó được thiết kế đặc biệt để có thể hoạt động như một kiểu dữ liệu nguyên thủy trong một số tình huống.(String str = "Hello"; -> ko dùng từ khóa new).
  - StringBuilder
    + Có thể thay đổi. append -> ko tạo object mới mà chỉ thay đổi nội dung
    + Không đồng bộ (not Thread-Safe)
    + Nhanh hơn StringBuffer và ko đồng bộ
    + Được sử dụng khi ko cần đa luồng và hiệu suất cao
  - StringBuffer: giống với build nhưng khác ở chỗ là đồng bộ cho đa luồng.
  - ![image](https://github.com/user-attachments/assets/c8e03900-e813-4e2f-b029-1786d6c0947c)
### 4.6 Toán tử
  - Toán tử (tập trung vào toán tử bit): ![image](https://github.com/user-attachments/assets/1127ae87-992e-4302-ab74-f888af84da2d)
  - Toán tử AND (&) bitwise:
    + So sánh từ bit của 2 số,** nếu cùng là 2 cùng là 1 thì kết quả là 1 **, ngược lại là 0: ![image](https://github.com/user-attachments/assets/a471dabe-61c6-49ed-b0c8-97ed798d7e74)
    + ** ứng dụng trong tình số chắn lẻ **:![image](https://github.com/user-attachments/assets/6fab6c92-6351-4233-ad28-dea395ec27f3)
    + Giải thích: số chắn là số chia hết cho 2 cho nên trong hệ nhị phân thì bit cuối luôn là 0 => Dựa theo quy tắc and bit thì 0 với 1 luôn là 0 => số 0 là chẵn còn số 1 là lẻ.
  - Toán tử OR (|)
    + ** Nếu ít nhất một bit là 1 thì kết quả là 1 **: ![image](https://github.com/user-attachments/assets/38573003-130b-4592-9921-447f7d1fb05d)
    + ứng dụng: ![image](https://github.com/user-attachments/assets/678677bd-3255-46ac-985b-e49562fa8210)
    + Giải thích: khi dùng or thì mọi bit số 1 của role write đã được thêm vào permission1, và khi dùng and lại với write thì (1 với 1 thành 1) => luông sẽ khác 0
  - Toán tử XOR (^)
    + ** Nếu 2 bit khác nhau thì kết quả là 1 **: ![image](https://github.com/user-attachments/assets/c6b2a289-c5b2-471b-97ba-12419f4a5c82)
    + Dùng làm mã hóa: ![image](https://github.com/user-attachments/assets/305d8992-d8f8-4378-b197-6888c7a90455)
    + Giait hích: giả mã là ngược lại của quá trình mã hóa ![image](https://github.com/user-attachments/assets/769f4917-6271-4f64-8e48-cdb791367150)
    + Tìm phần tử khác nhau trong 2 mảng -> ít dùng: ![image](https://github.com/user-attachments/assets/91848957-453c-41b6-b366-848cc2497fb1)
    + Kiểm tra chẵn lẻ: ![image](https://github.com/user-attachments/assets/d38797b8-f031-4a90-a31d-e836e7094d65)
    + Giải thích là vì XOR với 1 cũng giống như là +1 đổi với các số chắn do số chắn đuôi cuối bằng 0
  - Toán tử NOT Bitwise (~) : đảo ngược số bit -> tính số bù 2
  - Toán Tử Dịch Bit Trái (<<)
    + ** x << n dịch các bit sang trái n lần, điền 0 vào bên phải.**
    + ![image](https://github.com/user-attachments/assets/6d4517c8-b752-4df6-a8a0-b07d2f3371ae)
    + ** Mỗi lần dịch trái tương đương nhân 2^n. ** ứng dụng cho phép nhân: a * 2 == a << 1.
    + ![image](https://github.com/user-attachments/assets/ba40baf8-87cb-4e4c-9f59-a0e8ef50cf07)
  - Toán tử Dịch bít phải (>>) ** ngược lại với dịch trái **
  - Toán tử dịch bit phải không đấu
    + x >>> n dịch phải n lần, luôn chèn 0 vào bên trái.Không giữ nguyên dấu, nên số âm thành số rất lớn.
    + ![image](https://github.com/user-attachments/assets/2ff51ab0-d66f-4eca-ac6b-0e2e8c65728c)
  - Hệ 8 và 16: ![image](https://github.com/user-attachments/assets/08723ffa-da1e-4988-8a15-ef416f3676c8)
  - ![image](https://github.com/user-attachments/assets/7592c126-fb31-4f30-817d-2e69fd06f77b)
  - Hệ cơ số 32 (base32)
    + Quy tắc mã hóa: Chuyển đổi sang mã ASCII-> chuyển sang dạng nhị phân -> chia thành nhóm 5 bit (nhóm cuối ko đủ thì thêm 0 vào) -> tra bảng Base32 (tự search) để lấy ký tự tương  ứng -> Nếu không đủ nhóm 5bit thì thêm dấu = để padding tương ứng với số 0 mà thêm vào nhóm 5 bit
    + Base32 có được dùng trong mã hóa dữ liệu, OTP, không khuyến khích với ảnh thì ko tối ưu bằng base64 do dài hơn nhiều, và không phải trình duyệt nào cũng hỗ trợ Base32 Data URI (data:image/png;base32,...).
    + NguyễnQ123!@#
       + chuyển sang mã ASCII/UTF-8 (do chữ ễ cần chuyển UTF8): N → 78,ễ → C4 83 (bảng mã UTF-8 tự cha) ...
       + chuyển sang hệ nhị phân:78 → 01001110, C4 → 11000100, 83 → 10000011, .... (C4 -> chuyển C trongg hệ lục phân(Hexadecimal) là 12 : 1100 + số bit trong hệ nhị phân: 0100 )
       + nhóm theo thứ tự 5 bit một: 01001, 11001, 10011,... (nhóm cuối ko đủ thì thêm số 0)
       + Dựa bảng Base32: 01001 → J, 11001 → C... (thêm dấu = nếu chúng ta đã thêm 1 bit 0 vào )
       + Kết quả là: JCLVOHCBPMVMDMMNJGEGEMIAED=
       + Base32 là ký tự in hoa + '=' (32 ký tự (A-Z, 2-7))
  - Hệ cơ số 64 (base64)
    +  Về cơ chế giống với base32 nhưng khác là chia thành nhóm 6 bit (-> ít nhóm -> ngắn hơn base32) -> dùng bảng mã base64.(64 ký tự (A-Z, a-z, 0-9, +, /))
    +  Có thể dùng base64 hiện thị ảnh nhưng kích thước ảnh lớn sẽ làm chậm tốc độ tải (base32 nhiều trình duyệt ko hỗ trợ) <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAA==" alt="Image">
### 4.7 Vòng lặp (Loops)
  - Vòng lặp for – Duyệt dữ liệu có giới hạn
    + for không điều kiện (chạy mãi mãi) ![image](https://github.com/user-attachments/assets/55138d77-5d5a-4a51-8228-634bfda7279e)
    + Vòng lặp for nhiều biến ![image](https://github.com/user-attachments/assets/77f7cb55-4b41-4c25-b714-b6c69b31ee7e)
  - Vòng lặp while – Khi không biết trước số lần lặp
  - Vòng lặp do-while – Chạy ít nhất 1 lần
  - Vòng lặp foreach (Enhanced for) – Duyệt Collection tối ưu
  - Vòng lặp stream().forEach() – Cách hiện đại
  - Từ khóa break: thoát khỏi vòng lặp ngay lập tức
  - Từ khóa continue: Bỏ Qua Lần Lặp Hiện Tại, Chạy Tiếp Lần Kế Tiếp
  - Nhãn - label: là một tên được đặt trước một vòng lặp, giúp chúng ta điều khiển việc thoát (break) hoặc bỏ qua (continue) vòng lặp cụ thể.
    + ![image](https://github.com/user-attachments/assets/35b8f517-92ff-4244-9b2c-05413f2ae7b0)
    + ![image](https://github.com/user-attachments/assets/e27e8c5c-7cc6-4a12-9143-b9f5f14bae06)
### 4.8 Phương thức (Methods)
  - Dùng varargs (...) khi cần truyền số lượng tham số không xác định. ![image](https://github.com/user-attachments/assets/ec0c082f-2460-4104-ad80-0d2ab7ec3838)
  - ![image](https://github.com/user-attachments/assets/36bb1ef5-378d-4a32-9490-9f8582a5f3d2)
### 4.9 Câu lệnh điều kiện (if-else / switch-case)
  - Toán tử ba ngôi (? :) 
  - Dùng thay thế if-else if-else khi có nhiều điều kiện với cùng một biến.
  - Chỉ hỗ trợ kiểu số nguyên (int), char, String, enum. (Không hỗ trợ kiểu double, float, boolean.)
  - switch - case trong java14: ![image](https://github.com/user-attachments/assets/0dc59102-f68d-46f3-bca2-2f4723a9bcca)
### 4.10 Mảng (Arrays)
  - mảng có kích thước cố định khi được khởi tạo
  - Mảng trong Java là một đối tượng trên Heap. Khi bạn khởi tạo một mảng, Java cấp phát một vùng nhớ cố định để chứa tất cả các phần tử của mảng.
  - Không thể thay đổi kích thước vì vùng nhớ cấp phát liên tiếp. Nếu muốn có thêm phần tử, bạn cần tạo một mảng mới với kích thước lớn hơn và sao chép dữ liệu cũ. (System.arraycopy)
  - Sau dùng để linh hoạt khi làm việc: ArrayList. Mạng thì hiệu suất cao(vì dùng chỉ mục index để truy cập phần tử trực tiếp) nhưng lại ít phương thức thao tác.
  - Mảng 2 chiều int[][] matrix = new int[3][3]; ![image](https://github.com/user-attachments/assets/3cbfdda9-fe8e-4b5e-af1c-6219fee4f476)
### 4.11 Từ khóa (this, super, final)
  - Từ khóa this có thể được dùng để tham chiếu tới biến instance (toàn cục) của lớp hiện tại.
  - Dùng để gọi constructor trong cùng class
  - Trả về chính đối tượng hiện tại (return this) để hỗ trợ chaining method ![image](https://github.com/user-attachments/assets/3f6f5382-a0e7-4371-b4fc-77b433454d5b)
  - Super: Dùng để gọi constructor của lớp cha,Gọi phương thức bị override trong lớp cha (super.method()),Truy cập biến của lớp cha nếu bị che khuất (super.variable) ![image](https://github.com/user-attachments/assets/3744eb34-1322-4515-8ca1-65a71383a8c0)
  - final: Ngăn chặn thay đổi: Dùng với biến: Biến chỉ được gán giá trị một lần (constant),  Dùng với method: Ngăn chặn override (final method), Dùng với class: Ngăn chặn kế thừa (final class) ![image](https://github.com/user-attachments/assets/00b365ef-f5d2-4092-9d56-c195f98e0771)

### 4.12 Java Packages
  - Package là một nhóm các class, interface, sub-package liên quan được tổ chức theo một thư mục logic.
  - Dùng để tránh xung đột tên, bảo mật, dễ dàng bảo trì.
  - có 2 loại: Built-in Package - Các package có sẵn trong Java (e.g. java.util, java.io, java.net). User-defined Package - dev tự định nghĩa.
  - fully qualified name(không cần import): ![image](https://github.com/user-attachments/assets/176d312e-3bd2-4dee-947b-0f98ef6b07f3)
  - Java 5+ có Import trực tiếp method & biến static: ![image](https://github.com/user-attachments/assets/9c8e5cd8-0192-4484-aae6-11111972398d)

## *** 5. Các tính chất OOP ***
### 5.1 Encapsulation - Đóng gói
  - Ẩn chi tiết bên trong và chỉ cho phép truy cập thông qua phương thức cụ thể. (Vì vậy, nó còn được gọi là data hiding (nghĩa là che giấu dữ liệu).)
  - Dùng private cho biến và Dùng public getter/setter để truy cập.
### 5.2 Inheritance – Kế thừa
  - Class con có thể sử dụng lại code của class cha. Giảm trùng lặp code, giúp hệ thống mở rộng dễ dàng.
  - Trong Java, chúng ta có 3 dạng kế thừa chính đó là: kế thừa từ Class, kế thừa từ lớp trừu tượng (Abstract class) và kế thừa từ Interface.
  - Trong java không có đa kế thừa (1 con kết thừa 2 cha) : ![image](https://github.com/user-attachments/assets/58fccb9e-122e-4125-9a7c-57373d8f3c2a)
  - Nhưng ta có kế thừa phân cấp, 1 classs cha có nhiều class con kế thừa
  - Kế thừa đa cấp: Một class kế thừa từ một class khác, và class đó lại kế thừa từ một class khác nữa: ![image](https://github.com/user-attachments/assets/b19c378f-c76d-4e45-af00-200221610b36)
  - Kế thừa Abstract:
    + Khi một class kế thừa (extends) một abstract class, thì bắt buộc phải override tất cả các phương thức trừu tượng của class cha.![image](https://github.com/user-attachments/assets/dc380bf9-576c-4795-baf0-072b615c11ca)
  - Kế thừa Interface:
    + Interface là một hợp đồng (contract) chỉ định rằng một class nào đó phải triển khai các phương thức cụ thể.
    + Hỗ trợ đa kế thừa (một class có thể implements nhiều interface).
    + ![image](https://github.com/user-attachments/assets/97a58f19-34cb-4f23-8d92-87059b4de2e0)
    + Khi implement một interface (implements), phải override tất cả các phương thức, trừ khi có default method hoặc class con là abstract.![image](https://github.com/user-attachments/assets/2ebe8696-049c-4cf2-ac2b-1bf92734825e)
    + Khi nào nên dùng default method? Khi muốn thêm hành vi mặc định mà không làm ảnh hưởng đến các class cũ.
### 5.3 Polymorphism – Đa hình
  - Polymorphism là khả năng của một biến, phương thức hoặc đối tượng có thể có nhiều hình thái khác nhau.
  - Đa hình lúc biên dịch (Compile-time Polymorphism) → Method Overloading
  - Đa hình lúc chạy (Runtime Polymorphism) → Method Overriding
  - ![image](https://github.com/user-attachments/assets/97722c8a-7aab-42c8-aeac-d36e2e482476)
  - Tính Đa Hình Với Interface
  - Kế Thừa Abstract Class vs. Interface Trong Đa Hình
  - Upcasting - Ép Kiểu Lên. (an toàn)
    + 
  - Downcasting - Ép Kiểu Xuống
    + 
### 5.4 Abstraction – Trừu tượng

## *** 6. Các khái niện OOPs ***
## *** 7. Interface & abstract class ***
## *** 8. Exception handling ***
















































































