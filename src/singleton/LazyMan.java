package singleton;

public class LazyMan {
    private static LazyMan instance;

    private LazyMan(){}

    public synchronized static LazyMan getInstance(){
        if(instance==null){
            instance = new LazyMan();
        }
        return instance;
    }
}
