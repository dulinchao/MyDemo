package concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        counter.increment();
                    }
                }
            });
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
        }
        long end = System.currentTimeMillis();
        System.out.println("数值为"+counter.sum()+"\n耗时："+(end-start)+"ms");
    }
}
