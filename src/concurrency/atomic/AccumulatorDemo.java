package concurrency.atomic;

import java.util.concurrent.atomic.LongAccumulator;

public class AccumulatorDemo {
    public static void main(String[] args) {
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 3);
        accumulator.accumulate(1);
        accumulator.accumulate(2);
        System.out.println(accumulator.getThenReset());
    }
}
