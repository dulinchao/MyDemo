package concurrency.cache;

import concurrency.cache.computable.Computable;

import java.util.concurrent.*;

public class Cache<A, V> implements Computable<A, V> {
    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;    //计算器

    public Cache(Computable<A, V> computable) {
        this.computable = computable;
    }

    public static final Integer lock = 0;

    @Override
    public V compute(A arg) {
        while (true) {
            Future<V> f = cache.get(arg);
            if(f==null){
                synchronized (lock){
                    if (f == null) {
                        Callable<V> callable = new Callable<V>() {
                            @Override
                            public V call() throws Exception {
                                return computable.compute(arg);
                            }
                        };
                        FutureTask<V> futureTask = new FutureTask<>(callable);
                        //这个FutureTask就是要放入Map的值
                        f = futureTask;
                        if(!cache.containsKey(arg)){
                            cache.put(arg, futureTask);
                            System.out.println("调用FutureTask的计算逻辑");
                            futureTask.run();
                        }
                    }
                }
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                System.out.println("任务被取消");
            } catch (InterruptedException e) {
                System.out.println("任务被中断");
            } catch (ExecutionException e) {
                System.out.println("计算错误，重试");
                cache.remove(arg);
            }
        }

    }

    //一个执行定时任务的线程池
    public final static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    public V compute(A arg, long expire) {
        if (expire > 0) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            }, expire, TimeUnit.MILLISECONDS);
        }
        executor.shutdown();
        return compute(arg);
    }

    public V computeRandomExpire(A arg) {
        long expire = (long) (Math.random() * 10000);
        return compute(arg, expire);
    }

    private synchronized void expire(A key) {
        Future<V> future = cache.get(key);
        if (future != null) {
            if (!future.isDone()) {
                System.out.println("Future任务被取消");
                future.cancel(true);
            }
            System.out.println("过期时间到，缓存被清除");
            cache.remove(key);
        }
    }
}
