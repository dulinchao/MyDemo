package concurrency.threadlocal.first;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalNormalUsage00 {
    public String date(int seconds){
        //Date()参数单位是毫秒，从1970.1.1 00：00：00 计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10);
                System.out.println(date);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(1007);
                System.out.println(date);
            }
        }).start();
    }
}
