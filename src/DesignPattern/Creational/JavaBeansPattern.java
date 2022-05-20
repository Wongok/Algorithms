package DesignPattern.Creational;

public class JavaBeansPattern {
    public static void main(String[] args) {
        Person_3 person = new Person_3();
        person.setName("separk");
        person.setAge(99);
        person.setPhoneNumber("010-1234-5678");
        person.setEmail("test@gmail.com");

        System.out.println(person.toString());
    }
}

class Person_3 {
    private String name;  // required
    private int age;  // required
    private String phoneNumber;
    private String email;

    // USE LOMBOK..
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}