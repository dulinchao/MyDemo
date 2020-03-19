package singleton;

public class HungryMan {
    private final static HungryMan instance = new HungryMan();

    private HungryMan(){ }

    public static HungryMan getInstance() {
        return instance;
    }
}
