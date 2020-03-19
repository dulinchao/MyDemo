package singleton;

public class DoubleCheck {
    private volatile static DoubleCheck instance;

    private DoubleCheck(){}

    public static DoubleCheck getInstance(){
        //第一次检测
        if(instance==null){
            synchronized (DoubleCheck.class){
                //第二次检测
                if(instance==null){
                    instance = new DoubleCheck();
                    return instance;
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheck instance = DoubleCheck.getInstance();
    }
}
