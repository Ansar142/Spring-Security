package com.myCompany.securitydemo.Model;


public class Student {
    public String name ;
    public int Class ;

    public int age;
    public Student(String name, int aClass, int age) {
        this.name = name;
        Class = aClass;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }



    public Student setClass(int aClass) {
        Class = aClass;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }
}
