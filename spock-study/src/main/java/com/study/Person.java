package com.study;

public class Person {
    private String name;
    private String lastname;
    private int age;

    public Person(){
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return String.format("This person is called %s %s with the age of %d", this.name, this.lastname, this.age);
    }
}
