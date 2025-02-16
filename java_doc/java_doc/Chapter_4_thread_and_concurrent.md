# ** ------ Tóm Tắt ------ **
1. Đa luồng (multithreading)
2. Tạo và Quản lý Thread
4. Synchronization và Thread Safety
5. CompletableFuture -lập trình bất đồng bộ
6. Concurrent Programming Utilities
7. I/O-bound vs. CPU-bound
8. Shutdown Hook
9. Performance Tuning and Optimization
10. Best Practices and Design Patterns
11. Functional Programming with Concurrency
12. Các vấn đề trong Multithreading

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

### 2.3 Sử dụng Callable Interface và Future Class (Trả về kết quả & xử lý ngoại lệ)
- Callable là một interface trong Java, tương tự như Runnable, nhưng nó có khả năng trả về kết quả và ném ngoại lệ.
  + Chỉ có phương thức call() trả về kết quả. Còn runnable có method run là hàm void.
  + Callable có khả năng ném ngoại lệ từ phương thức call(), trong khi Runnable chỉ có thể sử dụng try-catch để xử lý ngoại lệ bên trong tác vụ.
  + 
- FutureTask là một lớp cung cấp implement của RunnableFuture, kế thừa từ Runnable và Callable. ![image](https://github.com/user-attachments/assets/333d7de1-51c6-420f-8909-a34f28db4079) ![image](https://github.com/user-attachments/assets/1e2f652b-51ba-4a68-8f89-97f057c798f0)

  + FutureTask dùng để lấy kết quả trả ra
- Callable và FutureTask cung cấp các tính năng mở rộng so với Runnable, giúp xử lý kết quả và ngoại lệ một cách linh hoạt hơn khi thực hiện các tác vụ đồng thời trong Java.
- ![image](https://github.com/user-attachments/assets/cf59f422-e28c-4ee6-8c53-e8eb95965200)
- Chúng ta có thể kết hợp FutureTask với ExecutorService
### 2.4 Executor Framework (Thread Pool - Quản lý tốt hơn)
- Executor Framework là một phần của java.util.concurrent giúp quản lý và thực thi các tác vụ đồng thời một cách hiệu quả thay vì tạo Thread thủ công.
#### 2.4.1 Executor - Interface gốc để thực thi tác vụ.
- Chỉ chạy không quản lý.
#### 2.4.2 Executors class - Tạo và Quản lý Thread Pool (Tốt hơn Thread)
- Executors là một lớp hỗ trợ trong gói java.util.concurrent cung cấp các factory method để tạo các loại khác nhau của ExecutorService
- newFixedThreadPool(int nThreads): Tạo một ExecutorService với một pool cố định có số lượng luồng xác định.
- newCachedThreadPool(): Tạo thread pool động, tăng giảm theo nhu cầu.
- newSingleThreadExecutor(): Tạo thread pool chỉ có 1 thread, thực hiện tuần tự.
- newScheduledThreadPool(int corePoolSize): Tạo thread pool hỗ trợ lập lịch chạy task.
- newWorkStealingPool(): Tạo pool hỗ trợ Fork/Join, tối ưu CPU đa lõi.

#### 2.4.3 ExecutorService (Quản lý tiến trình tốt hơn)
- ExecutorService là một giao diện mở rộng từ Executor, giúp quản lý thread pool và cung cấp các phương thức mạnh mẽ như:
  + Gửi task (submit(), invokeAll(), invokeAny())
  + Quản lý vòng đời (shutdown(), shutdownNow())
  + Xử lý kết quả (Future<V>, Callable<V>)
- Sử dụng ExecutorService giúp tránh quản lý thread thủ công, giúp chương trình ổn định hơn, dễ mở rộng hơn.
- Các tạo dùng Executors : ![image](https://github.com/user-attachments/assets/8d3cd5b9-9869-47b7-a7ea-d089d544218f) hoặc ThreadPoolExecutor ![image](https://github.com/user-attachments/assets/46dc42ed-2906-4f1d-9e80-ef21bc44daaf)
  + Hàm execute(Runnable task) - Không có giá trị trả về
  + submit(Callable<T> task) - Có giá trị trả về (Future<T>) ![image](https://github.com/user-attachments/assets/020e550d-8c23-4d89-8498-68ed8c7a0d9d)
  + invokeAll(Collection<Callable<T>> tasks) - Chạy nhiều task và đợi tất cả hoàn thành ![image](https://github.com/user-attachments/assets/1c883ce4-0db4-415e-a476-52051e54c3b9)
- Quán lý vòng đời của ExecutorService
  + shutdown() - Đóng Executor một cách "mềm" : các task tiếp tục nhưng ko nhận thêm task mới
  + shutdownNow() - Đóng Executor ngay lập tức.
  + awaitTermination(timeout, unit) - Chờ Executor tắt hoàn toàn ![image](https://github.com/user-attachments/assets/0b741d56-6fbd-4ddd-93f2-fae2f148a913)


#### 2.4.4 ThreadPoolExecutor - Cấu hình chi tiết
- Khi cần kiểm soát số lượng thread hoạt động trong pool.
- Khi muốn tinh chỉnh kích thước pool, thời gian chờ, và các chính sách quản lý thread.
- Các tham số quan trọng:
  + corePoolSize: số thread chạy luôn tồn tại trong pool.
  + maximumPoolSize: số thread tối đa pool có thể tạo ra
  + keepAliveTime: nếu số thread vượt quá corePoolSize và không có task mới, thread dư sẽ bị hủy sau thời gian này.
  + Queue (BlockingQueue): nếu tất cả thread bận, task sẽ được đưa vào hàng đợi.
- ![image](https://github.com/user-attachments/assets/e532839e-ce3b-49c8-a6d8-5857ad2cbe89)
- ![image](https://github.com/user-attachments/assets/ae4dc1ec-dfda-4bea-a3ba-25af3a7dbc5d)


#### 2.4.5 ScheduledExecutorService
- Khi cần lên lịch chạy task sau một khoảng thời gian.
- Khi muốn thực hiện task theo chu kỳ (vd: chạy mỗi 5 giây).
- Các method quan trọng:
  + schedule(Runnable, delay, unit): chạy task sau delay thời gian. unit là đơn vị thời gian
  + scheduleAtFixedRate(Runnable, initialDelay, period, unit): chạy task đầu tiên sau initialDelay, rồi lặp lại sau mỗi period.
  + scheduleWithFixedDelay(Runnable, initialDelay, delay, unit): giống scheduleAtFixedRate, nhưng đợi đến khi task trước hoàn thành mới đếm delay.
- ![image](https://github.com/user-attachments/assets/a682de36-42e4-45de-8597-96ab034cc93b)
- ![image](https://github.com/user-attachments/assets/3e4ec2fc-fca5-4f08-9ccc-12f2db82303b)
- Đầu tiên sau 2 giây thì chu kỳ 2 chạy, sau đó 1s (tức giây thứ 3) chạy chu kỳ 1. Cuối cùng thì chu kỳ 2 cứ 5s chạy 1lần.


#### 2.4.6 ForkJoinPool - chia nhỏ tiến trình để thực hiện song song.
- Khi cần xử lý đệ quy song song, ví dụ như chia nhỏ công việc.
- Khi cần tối ưu xử lý CPU-bound (chia nhỏ công việc cho nhiều core).
- Trong thực tế, bước đầu tiên framework Fork/ Join thực hiện là chia nhỏ task (fork/ split), đệ quy chia nhỏ nhiệm vụ thành các nhiệm vụ phụ nhỏ hơn cho đến khi chúng đơn giản đủ để được thực hiện xử lý không đồng bộ.
- **Fork/Join**: Đây là mô hình trong đó một tác vụ được chia thành các tác vụ con (fork) và sau đó gộp kết quả lại khi các tác vụ con hoàn thành (join).
- **ForkJoinPool**: Đây là thread pool đặc biệt được tối ưu hóa để làm việc với mô hình fork/join này. Nó sử dụng một cơ chế gọi là work-stealing (cướp công việc), trong đó các thread không bận có thể cướp công việc từ các thread khác để đảm bảo tài nguyên được sử dụng hiệu quả.
- **ForkJoinTask**: Là lớp cơ bản mà các tác vụ song song trong ForkJoinPool sẽ kế thừa. ForkJoinTask có hai subclass chính:
  + **RecursiveTask: Sử dụng khi tác vụ có giá trị trả về** (có thể là một giá trị kết quả).
  + **RecursiveAction: Sử dụng khi tác vụ không trả về giá trị nào** (chỉ thực thi các tác vụ mà không cần trả kết quả).
- **Work-Stealing**: Khi một thread hoàn thành công việc của mình, nếu nó nhận thấy rằng có các thread khác đang bận, nó có thể "cướp" công việc từ các queue của các thread khác để đảm bảo tài nguyên hệ thống được sử dụng hiệu quả.
- 
#### 2.4.7 Shutdown ExecutorService đúng cách



