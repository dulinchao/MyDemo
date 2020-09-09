package concurrency.cas;

public class SimulatedCAS implements Runnable{
    private volatile int value;
    //使用synchronized来保证原子性
    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        if(oldValue == expectedValue){
            value = newValue;
        }
        return value;
    }

    @Override
    public void run() {
        compareAndSwap(0,1);
    }

    public static void main(String[] args) throws InterruptedException {
        SimulatedCAS r = new SimulatedCAS();
        r.value = 0;
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }
}
