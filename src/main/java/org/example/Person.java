package org.example;
import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected String address = (String) null;
    protected int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        if (age >= 0 && age < 100) {
            return true;
        }
        return false;
    }

    public boolean hasAddress() {
        String number = (String) null;
        if (Objects.hashCode(address) != Objects.hashCode(number)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    @Override
    public String toString() {
        if (hasAge() && hasAddress()) {
            return "Person{ " +
                    "surname: " + surname + "\n" +
                    "name: " + name + "\n" +
                    "age: " + age + "\n" +
                    "town: " + address + "\n";
        }
        if (!hasAge() && hasAddress()) {
            return "Person{ " +
                    "surname: " + surname + "\n" +
                    "name: " + name + "\n" +
                    "town: " + address + "\n";
        } else {
            return "Person{ " + "\n " +
                    "surname: " + surname + "\n" +
                    "name: " + name + "\n";
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAddress(address);
        return child;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}