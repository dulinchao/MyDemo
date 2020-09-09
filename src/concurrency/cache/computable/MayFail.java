package concurrency.cache.computable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MayFail implements Computable<String,Integer>{
    @Override
    public Integer compute(String arg) throws Exception {
        double random = Math.random();
        if(random>0.5){
            throw new IOException("读取文件出错了");
        }
        TimeUnit.SECONDS.sleep(3);
        return Integer.valueOf(arg);
    }
}
