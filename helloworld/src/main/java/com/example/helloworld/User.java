package com.example.helloworld;

public class User {

    private String name;
    private int age;
// Default constructor (required by Spring)
    public User(){}

    //Getter and Setter(required)

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

}


