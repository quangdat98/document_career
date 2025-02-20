package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class main {
    public static void main(String[] args) {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        };

        FutureTask<Integer> future = new FutureTask<>(task);
        Thread thread = new Thread(future);
        thread.start();// chạy xong và kết quả đã có trong FutureTask

        try {
            // Lấy kết quả trả về từ tác vụ đồng thời
            Integer result = future.get();
            System.out.println("Kết quả: " + result);
        } catch (InterruptedException | ExecutionException e) {
            // Xử lý ngoại lệ khi có lỗi xảy ra trong quá trình thực thi tác vụ đồng thời
            e.printStackTrace();
        }
    }
}
