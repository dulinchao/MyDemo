package concurrency.cache;

import concurrency.cache.computable.MayFail;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UseCache {
    static ExecutorService executorService = Executors.newFixedThreadPool(3000);
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public volatile static AtomicInteger res = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Cache<String, Integer> cache = new Cache<String, Integer>(new MayFail());

        for (int i = 0; i < 10000; i++) {

            executorService.submit(()->{
                Integer result = null;
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result = cache.compute("666");
                res.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+" "+result+",这是第"+res.get()+"个数了");
            });
        }
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        countDownLatch.countDown();
        executorService.shutdown();
        while (!executorService.isTerminated()){
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"ms");
    }
}
