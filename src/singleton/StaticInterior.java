package singleton;

public class StaticInterior {
    private StaticInterior(){}

    private static class SingletonInstance{
        private static final StaticInterior INSTANCE = new StaticInterior();
    }

    public static StaticInterior getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
