package DesignPattern.Creational;

// Factory Method Design Pattern
// Consider a builder when faced with many constructor parameters
public class BuilderPattern {
    public static void main(String[] args) {
        Person person = new Person.Builder("separk", 99)
                .phoneNumber("010-1234-5678")
                .email("test@gmail.com")
                .build();

        System.out.println(person.toString());
    }
}

class Person {
    private String name; // required
    private int age; // required
    private String phoneNumber;
    private String email;

    static class Builder {
        private String name;
        private int age;
        private String phoneNumber;
        private String email;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder phoneNumber(String phoneNumber) {
            phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            email = email;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        phoneNumber = builder.phoneNumber;
        email = builder.email;
    }

}

