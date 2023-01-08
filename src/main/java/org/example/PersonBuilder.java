package org.example;
import java.util.Objects;

public class PersonBuilder {
    private String name;
    private String surname;
    private String address;
    private int age;
    String number = (String) null;

    public PersonBuilder setName(String name) {
        if (this.name == null) {
            this.name = name;
            return this;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (this.surname == null) {
            this.surname = surname;
            return this;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Некорректный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(this.name, this.surname, this.age, this.address);
        if (surname != null && name != null) {
            if (person.hasAge()) {
                if (age > 0 && age < 100) {
                    return new Person(name, surname, age, address);
                } else if (age == 0) {
                    return new Person(name, surname);
                }
            }
        }

        return person;
    }
}