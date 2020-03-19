
public class VolatileCanInterrupt implements Runnable {
    private volatile boolean canceled = false;  //volatile标志位
    @Override
    public void run() {
        int num = 0;
        try {
            while(num<=100000 && !canceled){
                if(num%100==0){
                    System.out.println(num+"是100的倍数");
                }
                num++;
                Thread.currentThread().sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanInterrupt volatileCanInterrupt = new VolatileCanInterrupt();
        Thread t = new Thread(volatileCanInterrupt);
        t.start();
        Thread.sleep(5000);
        volatileCanInterrupt.canceled = true;
    }
}
