package concurrency.flowConcurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class countDownDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int no = i+1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random())*10000);
                        System.out.println("No."+no+"完成了检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        System.out.println("等待5人检查完....");
        countDownLatch.await();
        System.out.println("所有质检完成，进入下一环节");
    }
}
