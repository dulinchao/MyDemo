import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Robot.class;
        Robot robot = (Robot) rc.newInstance();
        Method sayHi = rc.getDeclaredMethod("sayHi",String.class);
        sayHi.invoke(robot,"hello");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"dlc");
        sayHi.invoke(robot,"hello");
    }
}
