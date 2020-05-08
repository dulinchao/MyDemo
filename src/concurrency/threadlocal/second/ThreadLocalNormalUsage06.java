package concurrency.threadlocal.second;

//演示ThreadLocal用法二，避免传参
public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process("超哥");
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Service1().process("阿美");
            }
        }).start();
    }
}
class Service1{
    public void process(String name){
        User user = new User(name);
        System.out.println("服务一："+user.Name);
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}
class Service2{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("服务二："+user.Name);
        new Service3().process();
    }
}
class Service3{
    public void process(){
        User user = UserContextHolder.holder.get();
        System.out.println("服务三："+user.Name);
        UserContextHolder.holder.remove();  //避免内存泄漏
    }

}
class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}