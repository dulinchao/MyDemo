package concurrency;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        //放入第一个任务，由核心线程执行
        threadPoolExecutor.execute(new PrintThreadName());
        //再连续放入三个任务，都由核心线程执行
        threadPoolExecutor.execute(new PrintThreadName());
        threadPoolExecutor.execute(new PrintThreadName());
        threadPoolExecutor.execute(new PrintThreadName());
        //放入第五个任务，此时阻塞队列已满，会新建一个线程执行
        threadPoolExecutor.execute(new PrintThreadName());
        //放入第六个任务，会再次新建一个线程，但是超过最大线程数于是会报错
//        threadPoolExecutor.execute(new PrintThreadName());
        threadPoolExecutor.shutdown();
    }
}
class PrintThreadName implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
/**
 * 执行结果：
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-1
 * pool-1-thread-2
 */