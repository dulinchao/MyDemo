package concurrency.future;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ArrayList<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = executorService.submit(() -> {
                Thread.sleep(3000);
                return 1;
            });
            futures.add(future);
        }
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
