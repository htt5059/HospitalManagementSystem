package com.company.Person;


//abstract class that nurses doctors and patients inherit
abstract public class Person{
    final protected String gender;
    final protected String name;

    public Person(String name, String gender){ // constructor for person class
        this.gender=gender;
        this.name=name;
    }

    public Person(){
        this.gender = "";
        this.name = "";
    }
    //methods for setters and getters

    public abstract String GetGender(); //returns string gender
    public abstract String GetName(); // returns string name
}
