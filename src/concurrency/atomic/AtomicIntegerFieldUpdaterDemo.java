package concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {
    static Candidate tom;
    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");
    public static class Candidate{
        volatile int score;
    }

    public static void main(String[] args) {
        scoreUpdater.getAndIncrement(tom);
    }
}
