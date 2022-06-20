package DesignPattern.Creational;

public class Singleton {
    /*
    // private constructor restricted to this class ifself
    private Singleton() {}
    // static instance of type Singleton
    private static Singleton instance = null;
    // static method to create instance of Singleton class
    public static Singleton getSingletonInstance() {
        return instance;
    }
    */
    public static void main(String[] args) {
        User user = new User("Wongok");
        user.print();
    }
}

class Printer {
    private Printer() {}

    private static Printer printer = null;

    public static Printer getPrinterInstance() {
        if (printer == null) printer = new Printer();
        return printer;
    }

    public void print(String text) {
        System.out.println("print >>>>> " + text);
    }
}

class User {
    private String userName;
    public User(String userName) {
        this.userName = userName;
    }

    public void print() {
        Printer printer = Printer.getPrinterInstance();
        printer.print(userName);
    }
}