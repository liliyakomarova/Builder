package org.example;

import org.example.Person;
import org.example.PersonBuilder;

public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Лилия")
                .setSurname("Георг")
                .setAge(31)
                .setAddress("Москва")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Алексей")
                .build();
        mom.happyBirthday();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            Person mom1 = new PersonBuilder()
                    .setName("Ольга")
                    .setAge(31)
                    .setAddress("Москва")
                    .build();
            System.out.println("У " + mom1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person mom2 = new PersonBuilder()
                    .setName("Любовь")
                    .setSurname("Иванова")
                    .setAge(-10)
                    .setAddress("Москва")
                    .build();
            System.out.println("У " + mom2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}