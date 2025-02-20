package executor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Task đang chạy..."));
    }
}
