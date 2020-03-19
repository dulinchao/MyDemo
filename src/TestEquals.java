import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

public class TestEquals {
    public static void main(String[] args) {
        Pig pig1 = new Pig("abc");
        Pig pig2 = new Pig("abc");
        System.out.println(pig1.equals(pig2));
    }

}
class Pig{
    private String name;

    public Pig(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pig pig = (Pig) o;
        return Objects.equals(name, pig.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
