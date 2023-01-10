package org.example;

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

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null)
            throw new IllegalStateException("Имя и фамилия не указаны");
        if (age < 0) {
            person = new Person(name, surname, age);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}