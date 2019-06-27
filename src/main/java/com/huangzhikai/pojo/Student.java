package com.huangzhikai.pojo;

public class Student {

    private String address;

    private String name;

    private Integer age;

    public Student(String address, String name, Integer age) {
        super();
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", name=" + name + ", age=" + age + "]";
    }

}