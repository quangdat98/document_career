package forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolMain extends RecursiveTask<Integer> {
    int start;
    int end;
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinPoolMain task = new ForkJoinPoolMain(1,100);
        int res = pool.invoke(task);
        System.out.println("sum from 1 to 100: " + res);
    }

    @Override
    protected Integer compute() {
        //Nếu start == end tức chỉ có 1 phần tử
        if (start == end) {
            return end;
        } else {
            //Chia thành 2 nhiệm vụ nhỏ hơn
            int middle = (start + end) / 2;
            ForkJoinPoolMain leftTask = new ForkJoinPoolMain(start, middle);
            ForkJoinPoolMain rightTask = new ForkJoinPoolMain(middle + 1, end);

            //.fork() là thực hiện song song
            leftTask.fork();
            rightTask.fork();

            //.join() là chờ kết quả từ các task con rồi mới cộng
            return leftTask.join() + rightTask.join();
        }
    }

    public ForkJoinPoolMain(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
