package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(
                2, // corePoolSize (số thread tối thiểu)
                5, // maximumPoolSize (số thread tối đa)
                60L, // thời gian giữ thread thừa trước khi terminate
                TimeUnit.SECONDS, // đơn vị thời gian
                new LinkedBlockingQueue<>(10) // hàng đợi chứa các task đợi thực thi
        );

        // Gửi task vào pool
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task " + taskNumber + " đang chạy bởi " + Thread.currentThread().getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Đóng pool sau khi hoàn thành task
        executor.shutdown();
    }
}
