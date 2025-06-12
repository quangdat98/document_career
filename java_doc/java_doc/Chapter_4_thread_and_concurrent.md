# ** ------ Tóm Tắt ------ **
1. Đa luồng (multithreading)
2. Tạo và Quản lý Thread
3. Synchronization và Thread Safety
4. CompletableFuture -lập trình bất đồng bộ
5. Concurrent Programming Utilities
6. I/O-bound vs. CPU-bound
7. Shutdown Hook
8. Performance Tuning and Optimization
9. Các vấn đề trong Multithreading

# **------ Nội dung chi tiết ------**

## 1. Đa luồng (multithreading) 
-

### 1.1 Các lý thuyết
- Đa luồng (Multithreading) là kỹ thuật cho phép một chương trình thực thi nhiều luồng (thread) song song để tối ưu hóa hiệu suất và tài nguyên hệ thống.
- Một thread là một đơn vị nhỏ nhất của quá trình xử lý có thể thực thi độc lập.

## 2 Tạo và Quản lý Thread
- Trạng thái của thread:
  + **NEW** – Thread vừa được tạo nhưng chưa chạy (new Thread()).
  + **RUNNABLE** – Thread đã gọi start(), chờ CPU cấp tài nguyên.
  + **BLOCKED** – Thread đang chờ tài nguyên bị khóa (synchronized).
  + **WAITING** – Thread đợi tín hiệu từ thread khác (wait()).
  + **TIMED_WAITING** – Chờ trong thời gian giới hạn (sleep(), join()).
  + **TIMED_WAITING** – Chờ trong thời gian giới hạn (sleep(), join()).
- Quản lý vòng đời của Thread
  + Dùng join() để chờ một thread kết thúc trước khi chạy tiếp: ![image](https://github.com/user-attachments/assets/925aa9d4-26df-4b99-a474-b7dee3594f54)
  + Dùng sleep() để tạm dừng một thread

### 2.1 Extend Thread class
- Sử dụng Thread class ![image](https://github.com/user-attachments/assets/93739b83-b2de-4554-90d2-7715179f4131)
  + Đơn giản dễ hiểu nhưng không thể kết thừa lớp khác do java không hỗ trợ đa kế thừa.
- Các phương thức:
  + ![image](https://github.com/user-attachments/assets/56cfcdc6-4946-4f45-ab3c-ccf993ada8d7)
  + ![image](https://github.com/user-attachments/assets/93337d97-9ad6-406d-be4b-74834aae1867)
  + ![image](https://github.com/user-attachments/assets/e403277e-6dae-4885-ae96-3a957d2c272f)
  + ![image](https://github.com/user-attachments/assets/1a227d99-c527-442b-b69c-ce6948b067a4)
  + ![image](https://github.com/user-attachments/assets/27984361-7a66-45dc-928e-928583c2702a)
 
### 2.2 Runnable interface 
- Sử dụng Runnable interface ![image](https://github.com/user-attachments/assets/bba91ac3-11a6-4598-8ab0-ffdbe5aa7306)
  + Có thể kế thừa lớp khác, link hoạt hơn. Nhưng cần tạo thêm thread để chạy
  + Can implements method void run().

### 2.3 Sử dụng Callable Interface (Trả về kết quả & xử lý ngoại lệ)
- **Callable là một interface trong Java, tương tự như Runnable, nhưng nó có khả năng trả về kết quả và ném ngoại lệ.**
  + **Chỉ có phương thức call() trả về kết quả. Còn runnable có method run là hàm void.**
  + Callable có khả năng ném ngoại lệ từ phương thức call(), trong khi Runnable chỉ có thể sử dụng try-catch để xử lý ngoại lệ bên trong tác vụ.
- **Future<V>: dùng để lấy kết quả, kiểm tra trạng thái, hoặc hủy một task do Callable thực hiện**. ![image](https://github.com/user-attachments/assets/333d7de1-51c6-420f-8909-a34f28db4079) ![image](https://github.com/user-attachments/assets/1e2f652b-51ba-4a68-8f89-97f057c798f0)

  + FutureTask dùng để lấy kết quả trả ra
- Callable và FutureTask cung cấp các tính năng mở rộng so với Runnable, giúp xử lý kết quả và ngoại lệ một cách linh hoạt hơn khi thực hiện các tác vụ đồng thời trong Java.
- ![image](https://github.com/user-attachments/assets/cf59f422-e28c-4ee6-8c53-e8eb95965200)
- Chúng ta có thể kết hợp FutureTask với ExecutorService
### 2.4 Executor Framework (Thread Pool - Quản lý tốt hơn)
- Executor Framework là một phần của java.util.concurrent giúp quản lý và thực thi các tác vụ đồng thời một cách hiệu quả thay vì tạo Thread thủ công.
#### 2.4.1 Executor - Interface gốc để thực thi tác vụ.
- Chỉ chạy không quản lý.
- ![image](https://github.com/user-attachments/assets/2b894061-1b4f-4bae-9cdb-81968d4b5307)

#### 2.4.2 Executors class - Tạo và Quản lý Thread Pool (Tốt hơn Thread)
- Executors là một lớp hỗ trợ trong gói java.util.concurrent cung cấp các factory method để tạo các loại khác nhau của ExecutorService
- newFixedThreadPool(int nThreads): Tạo một ExecutorService với một pool cố định có số lượng luồng xác định.
- newCachedThreadPool(): Tạo thread pool động, tăng giảm theo nhu cầu.
- newSingleThreadExecutor(): Tạo thread pool chỉ có 1 thread, thực hiện tuần tự.
- newScheduledThreadPool(int corePoolSize): Tạo thread pool hỗ trợ lập lịch chạy task.
- newWorkStealingPool(): Tạo pool hỗ trợ Fork/Join, tối ưu CPU đa lõi.

#### 2.4.3 Interface ExecutorService (Quản lý tiến trình tốt hơn)
- **ExecutorService là một interface mở rộng từ Executor**, giúp quản lý thread pool và cung cấp các phương thức mạnh mẽ như:
  + Gửi task (submit(), invokeAll(), invokeAny())
  + Quản lý vòng đời (shutdown(), shutdownNow())
  + Xử lý kết quả (Future<V>, Callable<V>)
- Sử dụng ExecutorService giúp tránh quản lý thread thủ công, giúp chương trình ổn định hơn, dễ mở rộng hơn.
- Các tạo dùng Executors : ![image](https://github.com/user-attachments/assets/8d3cd5b9-9869-47b7-a7ea-d089d544218f) hoặc ThreadPoolExecutor ![image](https://github.com/user-attachments/assets/46dc42ed-2906-4f1d-9e80-ef21bc44daaf)
  + **Hàm execute(Runnable task) - Không có giá trị trả về**
  + **submit(Callable<T> task) - Có giá trị trả về (Future<T>)** ![image](https://github.com/user-attachments/assets/020e550d-8c23-4d89-8498-68ed8c7a0d9d)
  + **invokeAll(Collection<Callable<T>> tasks) - dùng để thực thi đồng thời nhiều Callable tasks và chờ tất cả task hoàn thành, rồi trả List Future.**![image](https://github.com/user-attachments/assets/1c883ce4-0db4-415e-a476-52051e54c3b9)
- Vòng đời ExecutorService
  + Running: Đang nhận task (submit(), execute())
  + Shutdown: Không nhận task mới, nhưng tiếp tục xử lý task đang chờ
  + Terminated: Tất cả task đã xong, pool đóng hoàn toàn
- Các phương thức quản lý vòng đời
  + shutdown() - Đóng Executor một cách "mềm" : các task tiếp tục nhưng ko nhận thêm task mới
  + shutdownNow() - Đóng Executor ngay lập tức.
  + awaitTermination(timeout, unit) - Chờ Executor tắt hoàn toàn ![image](https://github.com/user-attachments/assets/0b741d56-6fbd-4ddd-93f2-fae2f148a913)
  + isShutdown(): Trả về true nếu đã gọi shutdown() hoặc shutdownNow().
  + isTerminated(): Trả về true nếu tất cả task đã hoàn thành sau shutdown.
  + Nen kiem tra thead da interrup chua bang isInterrupted() de an toan ![image](https://github.com/user-attachments/assets/a3242351-6270-4b18-a600-3ed0f3fa725c)



#### 2.4.4 Class ThreadPoolExecutor - Cấu hình chi tiết
- **Là lớp triển khai chính của interface ExecutorService. Các class như Executors.newFixedThreadPool() hay newCachedThreadPool() đều trả về một đối tượng ThreadPoolExecutor bên trong.**
- Khi cần kiểm soát số lượng thread hoạt động trong pool.
- Khi muốn tinh chỉnh kích thước pool, thời gian chờ, và các chính sách quản lý thread.
- Các tham số quan trọng:
  + corePoolSize: số thread chạy luôn tồn tại trong pool.
  + maximumPoolSize: số thread tối đa pool có thể tạo ra
  + keepAliveTime: nếu số thread vượt quá corePoolSize và không có task mới, thread dư sẽ bị hủy sau thời gian này.
  + Queue (BlockingQueue): nếu tất cả thread bận, task sẽ được đưa vào hàng đợi.
- ![image](https://github.com/user-attachments/assets/e532839e-ce3b-49c8-a6d8-5857ad2cbe89)
- ![image](https://github.com/user-attachments/assets/ae4dc1ec-dfda-4bea-a3ba-25af3a7dbc5d)
-**Executors.newFixedThreadPool(n) .... chính là cách đơn giản để tạo ra một đối tượng ThreadPoolExecutor với cấu hình cố định — cụ thể là corePoolSize = n và maximumPoolSize = n,LinkedBlockingQueue, không giới hạn số lượng phần tử. . Executors.newFixedThreadPool(n)... là wrapper tiện dụng của ThreadPoolExecutor. **

#### 2.4.5 Interface ScheduledExecutorService
- Giong Interface ExecutorService nhung co them lap lich.
- **ScheduledExecutorService là một interface đặc biệt trong Java Executor Framework**, cho phép bạn lên lịch chạy các task (Runnable/Callable):
  + Sau một khoảng thời gian trễ (delay)
  + Hoặc chạy định kỳ lặp lại
- Các method quan trọng:
  + **schedule(Runnable, delay, unit)**: chạy task sau delay thời gian. unit là đơn vị thời gian
  + **scheduleAtFixedRate(Runnable, initialDelay, period, unit)**: chạy task đầu tiên sau initialDelay, rồi lặp lại sau mỗi period.
  + **scheduleWithFixedDelay(Runnable, initialDelay, delay, unit)**: giống scheduleAtFixedRate, nhưng đợi đến khi task trước hoàn thành mới đếm delay.
- ![image](https://github.com/user-attachments/assets/a682de36-42e4-45de-8597-96ab034cc93b)
- ![image](https://github.com/user-attachments/assets/3e4ec2fc-fca5-4f08-9ccc-12f2db82303b)
- Đầu tiên sau 2 giây thì chu kỳ 2 chạy, sau đó 1s (tức giây thứ 3) chạy chu kỳ 1. Cuối cùng thì chu kỳ 2 cứ 5s chạy 1lần.


#### 2.4.6 Class ForkJoinPool - chia nhỏ tiến trình để thực hiện song song.
- Một ExecutorService đặc biệt để xử lý các tác vụ đệ quy song song (divide & conquer).
- Khi cần tối ưu xử lý CPU-bound (chia nhỏ công việc cho nhiều core).
- Trong thực tế, bước đầu tiên framework Fork/ Join thực hiện là chia nhỏ task (fork/ split), đệ quy chia nhỏ nhiệm vụ thành các nhiệm vụ phụ nhỏ hơn cho đến khi chúng đơn giản đủ để được thực hiện xử lý không đồng bộ.
- **Fork/Join**: Đây là mô hình trong đó một tác vụ được chia thành các tác vụ con (fork) và sau đó gộp kết quả lại khi các tác vụ con hoàn thành (join).
- **ForkJoinPool**: Đây là thread pool đặc biệt được tối ưu hóa để làm việc với mô hình fork/join này. Nó sử dụng một cơ chế gọi là work-stealing (cướp công việc), trong đó các thread không bận có thể cướp công việc từ các thread khác để đảm bảo tài nguyên được sử dụng hiệu quả.
- **ForkJoinTask**: Là lớp cơ bản mà các tác vụ song song trong ForkJoinPool sẽ kế thừa. ForkJoinTask có hai subclass chính:
  + **RecursiveTask: Sử dụng khi tác vụ có giá trị trả về** (có thể là một giá trị kết quả).
  + **RecursiveAction: Sử dụng khi tác vụ không trả về giá trị nào** (chỉ thực thi các tác vụ mà không cần trả kết quả).
- **Work-Stealing**: Khi một thread hoàn thành công việc của mình, nếu nó nhận thấy rằng có các thread khác đang bận, nó có thể "cướp" công việc từ các queue của các thread khác để đảm bảo tài nguyên hệ thống được sử dụng hiệu quả.
- **compute()** Thực thi công việc (phải override trong lớp con).
- invoke() Thực thi tác vụ và trả về kết quả ngay lập tức.
- isCompletedNormally() Kiểm tra xem tác vụ có hoàn thành mà không bị lỗi không.
- **fork() Chạy tác vụ trên một luồng khác**.
- join() Chờ kết quả từ tác vụ con.
- ![image](https://github.com/user-attachments/assets/42240dd0-dbd8-40c4-b065-c459d7d18bf6)
- ![image](https://github.com/user-attachments/assets/b44ac617-9746-4d31-8a6e-af90230ebb76)
- **ForkJoinPool hoạt động giống như một vòng lặp đệ quy chia nhỏ công việc liên tục cho đến khi đạt đến một ngưỡng nhất định (THRESHOLD)**, sau đó thực hiện tính toán và ghép kết quả lại.
- Ví dụ Tính tổng:
  + ![image](https://github.com/user-attachments/assets/8e4de3e1-9546-4566-ab03-21df9d32eabc)

#### 2.4.7 Shutdown ExecutorService đúng cách
- ![image](https://github.com/user-attachments/assets/c1062f47-e0a7-4f0d-9d4e-b927ad13e0b9)

## 3. Synchronization (Đồng bộ hóa) và Thread Safety (luồng an toàn)
- https://gpcoder.com/3514-dong-bo-hoa-cac-luong-trong-java/
### 3.1 Synchronization
- Synchronization đảm bảo rằng chỉ một thread có thể truy cập tài nguyên chung tại một thời điểm, giúp tránh lỗi khi nhiều thread chạy đồng thời.
- **Java Monitor** là một cơ chế đồng bộ hóa giúp kiểm soát quyền truy cập vào tài nguyên dùng chung bằng cách chỉ cho phép một thread thực thi bên trong một khối đồng bộ hóa (synchronized block/method) tại một thời điểm. Nguyên tắc hoặt động của monitor
  + Khi một thread vào vùng synchronized, nó chiếm Monitor của đối tượng.
  + Nếu một thread khác muốn vào vùng synchronized của cùng một đối tượng, nó phải chờ.
  + Khi thread hiện tại rời khỏi vùng synchronized, Monitor được giải phóng và thread khác có thể tiếp tục.
- Khi bạn có 2 luồng cùng tác động vào 1 biến mà ko có đồng bộ thì có thể sảy ra sự sai lệch kết quả.
- Chúng ta có 3 cách để đồng bộ trong java:
  + synchronized methods: Phương thức synchronized đảm bảo rằng chỉ một thread có thể truy cập phương thức đó tại một thời điểm. ![image](https://github.com/user-attachments/assets/1b891481-4f2c-4863-aae2-c4b5b330d913)
  + synchronized statements: Nếu chỉ cần đồng bộ một phần của phương thức, ta dùng synchronized block để tối ưu hiệu suất.![image](https://github.com/user-attachments/assets/ae39dedf-bfca-4273-ab66-5c37b8dadedc)
  + static synchronized method: Khi có biến tĩnh (static), ta dùng synchronized static method để bảo vệ tài nguyên dùng chung cho tất cả các thread.![image](https://github.com/user-attachments/assets/41f82570-a6c7-4a51-9f6c-eab9aeb02798)

### 3.2 Thread Safety

## 4. CompletableFuture -lập trình bất đồng bộ
### 4.1 Lý thuyết
- **CompletableFuture được dùng để xử lý chương trình chạy ngầm (background / async task) — tức là các công việc chạy bất đồng bộ (asynchronous) mà không làm chặn luồng chính (main thread).**
- CompletableFuture là một class trong Java thuộc gói java.util.concurrent, được giới thiệu từ Java 8. Nó đại diện cho một tương lai (future) có thể được hoàn thành thủ công và có thể lập lịch các tác vụ bất đồng bộ. CompletableFuture cung cấp API mạnh mẽ cho lập trình bất đồng bộ, giúp dễ dàng thực hiện các tác vụ song song và xử lý kết quả khi các tác vụ hoàn thành.
- Hỗ trợ xử lý bất đồng bộ
  + Bạn có thể thực thi các tác vụ ở nền mà không chặn luồng chính.
  + Hỗ trợ chaining (xâu chuỗi) các bước xử lý sau khi kết quả sẵn sàng
  + Hỗ trợ chaining (xâu chuỗi) các bước xử lý sau khi kết quả sẵn sàng
- Hỗ trợ xử lý song song (Parallel Execution)
  + Kết hợp nhiều tác vụ bất đồng bộ, ví dụ: thực hiện hai hoặc nhiều công việc đồng thời.
- Sử dụng các phương thức static tiện lợi: ![image](https://github.com/user-attachments/assets/d6b1816a-2e26-4085-b179-d35c5c0a3bfa)
  + supplyAsync: Thực hiện một tác vụ trả về kết quả.
  + runAsync: Thực hiện một tác vụ không trả về kết quả.
- Chaining API (Thực hiện hành động sau supplyAsync/runAsync)
  + Chaining (thenApply -xâu chuỗi các tác vụ)
    + ![image](https://github.com/user-attachments/assets/3397568d-dcc9-4f17-b686-b620b8123af1)
  + thenCompose: Kết nối 2 CompletableFuture phụ thuộc nhau: ![image](https://github.com/user-attachments/assets/890bd0b9-3ceb-41c5-af8b-565ec571667e)
  + thenApply:Xử lý kết quả và trả kết quả mới ![image](https://github.com/user-attachments/assets/574cb12d-af4e-4a18-a851-ea5db7e7516e)
  + thenCombine: Kết hợp 2 CompletableFuture chạy độc lập ![image](https://github.com/user-attachments/assets/8a51d0eb-a83d-475b-b0eb-093c0fc3d8b4)
  + thenAccept: Tiêu thụ kết quả, KHÔNG trả về giá trị ![image](https://github.com/user-attachments/assets/304f4102-9f47-4dcf-80a8-d0d3f382c576)
  + thenRun(): Thực thi runnable KHÔNG dùng kết quả trước đó ![image](https://github.com/user-attachments/assets/072d0fa9-9ca2-4868-a560-d6eb90957fb7)
  + exceptionally(): Xử lý exception khi task lỗi ![image](https://github.com/user-attachments/assets/88238f47-07b2-467b-9eae-76f4902f2546)
  + handle(): Xử lý kết quả hoặc lỗi ![image](https://github.com/user-attachments/assets/942a1d37-7681-4c71-9bf6-f116e6172e9f)
  + allOf(): Chờ tất cả CompletableFuture hoàn thành ![image](https://github.com/user-attachments/assets/69e157e5-21b7-41dd-877b-cc8c14545ee1)
  + anyOf(): Chờ 1 task bất kỳ hoàn thành ![image](https://github.com/user-attachments/assets/f52b87c9-bcdb-4f4a-80e3-0702a2e50e6c)

- CompletableFuture.join() : KẾT THÚC: chờ tác vụ hoàn tất và lấy kết quả ![image](https://github.com/user-attachments/assets/90272f4b-0d10-4184-a714-8f97d69b9140)
- CompletableFuture.get(): Giong join Khi bạn muốn xử lý ngoại lệ rõ ràng
  + ![image](https://github.com/user-attachments/assets/106e15f9-860c-4bf4-924d-302a32d16e62)





- Tạo CompletableFuture với Executor: Thực thi một tác vụ bất đồng bộ trên một Executor cụ thể.
  + ![image](https://github.com/user-attachments/assets/82e9526f-dfe9-4863-abbd-c21289551192)
- get(): Chờ kết quả của CompletableFuture và trả về giá trị.
  + join(): Tương tự get(), nhưng không ném ngoại lệ mà thay vào đó ném CompletionException nếu có lỗi.
- ![image](https://github.com/user-attachments/assets/bb65bd0d-d629-4f48-8ace-e6a50a648912)
- ExecutorService và CompletableFuture
  + ![image](https://github.com/user-attachments/assets/1e8c74be-cbd3-4205-8300-11067cedb81e)

### 4.2 Executor để điều khiển luồng ngầm
- CompletableFuture mặc định sử dụng một ThreadPool để thực thi các tác vụ bất đồng bộ
- Bạn có thể cung cấp một Executor để điều khiển chính xác cách các tác vụ được thực thi trong các luồng ngầm.
- ![image](https://github.com/user-attachments/assets/0ce093d4-8b22-4a10-99fa-43e4fa3f4c03)

## 5. Concurrent Programming Utilities
## 6. I/O-bound vs. CPU-bound
## 7. Shutdown Hook
## 8. Performance Tuning and Optimization
## 9. Các vấn đề trong Multithreading










