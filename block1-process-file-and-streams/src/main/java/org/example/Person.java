package org.example;

class Person {

    private final String name;
    private final String town;
    private final int age;

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }
}