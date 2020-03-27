package writingtest;

/**
 * 测试super的用法
 */
public class TestSuper {
    protected String father = "father";
    public TestSuper() {
    }
    public void print(){
        System.out.println("我是爸爸");
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.print();
        child.fatherPrint();
        child.printFather();
    }
}
class Child extends TestSuper{
    /**
     * 调用父类的构造方法
     */
    public Child() {
        super();
    }
    @Override
    public void print() {
        System.out.println("我是儿子");
    }
    /**
     * 调用父类的被重写方法
     */
    public void fatherPrint(){
        super.print();
    }
    /**
     * 访问父类非私有变量
     */
    public void printFather(){
        System.out.println(super.father);
    }
}