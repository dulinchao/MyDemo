package concurrency.flowConcurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new Runnable(){
            @Override
            public void run() {
                System.out.println("所有人已到场，一起出发");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(i,cyclicBarrier)).start();
        }
    }

    static class Task implements Runnable{
        private int id;
        private CyclicBarrier cyclicBarrier;
        public Task(int id,CyclicBarrier cyclicBarrier){
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+id+"现在前往集合地点");
            try {
                Thread.sleep((long)(Math.random())*10000);
                System.out.println("线程"+id+"到达集合地点，开始等待其他线程");
                cyclicBarrier.await();
                System.out.println("线程"+id+"继续出发");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
