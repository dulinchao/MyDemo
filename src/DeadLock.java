import java.util.concurrent.TimeUnit;

public class DeadLock {


    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("get 1 want 2");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("get 1 and 2");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("get 2 want 1");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("get 1 and 2");
                    }
                }
            }
        }).start();
    }
}
