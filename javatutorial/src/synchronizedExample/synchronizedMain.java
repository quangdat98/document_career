package synchronizedExample;

public class synchronizedMain {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected: 2000, Actual: " + counter.getCount()); // Có thể < 2000!
    }

    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
