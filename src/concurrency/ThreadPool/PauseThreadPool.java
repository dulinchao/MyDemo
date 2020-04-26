package concurrency.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//自己写一个可暂停的线程池，每个任务前后都可以写钩子函数
public class PauseThreadPool extends ThreadPoolExecutor {
    private boolean isPaused;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition unpaused = lock.newCondition();

    public PauseThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (isPaused){
                unpaused.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void pause(){
        lock.lock();
        try {
            isPaused = true;
        }finally {
            lock.unlock();
        }
    }
    private void resume(){
        lock.lock();
        try{
            isPaused = false;
            unpaused.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PauseThreadPool pauseThreadPool = new PauseThreadPool(10,20,10L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for(int i=0;i<10000;i++){
            pauseThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我被执行了");
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(1500);
        pauseThreadPool.pause();
        System.out.println("线程池被暂停了");
        Thread.sleep(1500);
        System.out.println("恢复线程池");
        pauseThreadPool.resume();
    }
}
