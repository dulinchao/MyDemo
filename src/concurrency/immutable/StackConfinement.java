package concurrency.immutable;

public class StackConfinement implements Runnable{
    public void inThread(){
        int neverGoOut = 0;
        for (int i = 0; i < 10000; i++) {
            neverGoOut++;
        }
        System.out.println("栈内保护安全"+neverGoOut);
    }

    @Override
    public void run() {
        inThread();
    }

    public static void main(String[] args) {
        StackConfinement stackConfinement = new StackConfinement();
        Thread t1 = new Thread(stackConfinement);
        Thread t2 = new Thread(stackConfinement);
        t1.start();
        t2.start();
    }
}
