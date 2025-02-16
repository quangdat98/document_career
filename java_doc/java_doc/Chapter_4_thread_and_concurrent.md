# ** ------ Tóm Tắt ------ **
1. Đa luồng (multithreading)
2. Tạo và Quản lý Thread
3. Synchronization và Thread Safety
4. Concurrent Programming Utilities
5. I/O-bound vs. CPU-bound
6. Shutdown Hook
7. Performance Tuning and Optimization
8. Best Practices and Design Patterns
9. Functional Programming with Concurrency
10. Các vấn đề trong Multithreading

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
- Hàm execute(Runnable task) - Không có giá trị trả về
- submit(Callable<T> task) - Có giá trị trả về (Future<T>) ![image](https://github.com/user-attachments/assets/020e550d-8c23-4d89-8498-68ed8c7a0d9d)
- invokeAll(Collection<Callable<T>> tasks) - Chạy nhiều task và đợi tất cả hoàn thành ![image](https://github.com/user-attachments/assets/1c883ce4-0db4-415e-a476-52051e54c3b9)





#### 2.4.4 ThreadPoolExecutor - Cấu hình chi tiết
#### 2.4.5 ForkJoinPool - Xử lý song song
#### 2.4.6 Shutdown ExecutorService đúng cách



