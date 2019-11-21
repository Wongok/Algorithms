package DesignPattern.Creational;

public class Singleton {
    // private constructor restricted to this class ifself
    private Singleton() {}
    // static instance of type Singleton
    private static Singleton instance = null;
    // static method to create instance of Singleton class
    public static Singleton getSingletonInstance() {
        return instance;
    }

}
