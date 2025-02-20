package executor;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> System.out.println("Chạy task trên " + Thread.currentThread().getName()));
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });
        System.out.println("Kết quả: " + future.get()); // Kết quả: 42*/

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = List.of(
                () -> 1, () -> 2, () -> 3
        );
        List<Future<Integer>> results = executor.invokeAll(tasks); // Chỉ trả về kết quả khi tất cả task hoàn thành.
        for (Future<Integer> result : results) {
            System.out.println(result.get());
        }

    }
}
