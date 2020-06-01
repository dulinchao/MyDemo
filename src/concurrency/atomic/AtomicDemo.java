package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo {
    private static final AtomicInteger atomicInteger = new AtomicInteger(4);
    public static void main(String[] args) {
        atomicInteger.getAndIncrement();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        atomicIntegerArray.getAndDecrement(5);//对下标为5的元素--
        AtomicReference<Thread> sign = new AtomicReference<>();
    }
}
