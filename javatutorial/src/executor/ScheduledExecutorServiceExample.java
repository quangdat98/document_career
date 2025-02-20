package executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        // Chạy một lần sau 3 giây
        scheduler.schedule(() -> System.out.println("Task chạy sau 3 giây"), 3, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task chạy mỗi 5 giây: " + System.currentTimeMillis());
        }, 2, 5, TimeUnit.SECONDS);
    }
}
