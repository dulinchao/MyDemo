import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        Random random = new Random();
        for(int i=0;i<10;i++){
            int e = random.nextInt(100);
            queue.offer(e);
            System.out.println("入队"+e);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }

}
