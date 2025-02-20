package StringBuffer;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (sb) {
                    sb.append("1");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(sb) {
                    sb.append("2");
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }
}
