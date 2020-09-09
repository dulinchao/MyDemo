import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test{
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size()>1){
            int size = list.size();
            int i = index + m -1;
            index = i % size;
            list.remove(index);
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        int i = lastRemaining(100000, 1000000);
        System.out.println(i);
    }
}