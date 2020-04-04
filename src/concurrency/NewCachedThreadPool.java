package concurrency;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();
        Stack<Integer> integers = new Stack<>();
    }
}
/**
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-3
 * pool-1-thread-3
 * pool-1-thread-3
 * pool-1-thread-4
 */
