package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.currentThread().sleep(2000);
                return 1;
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        while(!futureTask.isDone()){
        }
        System.out.println(futureTask.get());
    }
}
