package DesignPattern.Creational;

public class TelescopingConstructorPattern {
    public static void main(String[] args) {
        Person_2 person = new Person_2("separk", 99, "010-1234-5678", "test@gmail.com");

        System.out.println(person.toString());
    }
}

class Person_2 {
    private final String name;  // required
    private final int age;  // required
    private final String phoneNumber;
    private final String email;

    public Person_2(String name, int age) {
        this(name, age, null);
    }

    public Person_2(String name, int age, String phoneNumber) {
        this(name, age, phoneNumber, null);
    }

    public Person_2(String name, int age, String phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}