package com.company;

public class Student extends Person{

    public int id;
    public Student(int id, String name){
        super.name = name; //overriding an attribute of the parent class.
        this.id = id;
    }
}
