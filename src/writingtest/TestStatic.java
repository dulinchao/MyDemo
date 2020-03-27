package writingtest;

import singleton.DoubleCheck;

/**
 * > 下列说法错误的有（ ACD）
 * > A. 在类方法中可用this来调用本类的类方法
 * > B. 在类方法中调用本类的类方法时可直接调用
 * > C.在类方法中只能调用本类中的类方法
 * > D.在类方法中绝对不能调用实例方法
 */
public class TestStatic {
    public static void test(){
    }
    public static void normal(){
        System.out.println("me");
    }
}
