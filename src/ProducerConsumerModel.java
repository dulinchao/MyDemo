import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
class Producer implements Runnable{
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.put();
        }
    }
}
class Consumer implements Runnable{
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.take();
        }
    }
}
class EventStorage{
    private int maxSize;
    private List<Date> storage;

    public EventStorage(){
        maxSize = 10;
        storage = new ArrayList<>();
    }
    public synchronized void put(){
        while(storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了"+storage.size()+"个产品");
        notify();
    }
    public synchronized void take(){
        while(storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了"+storage.remove(0)+"，现在仓库还剩下"+storage.size());
        notify();
    }
}