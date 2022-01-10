package com.company.Employee;

import com.company.Person.*;

public abstract class Employee extends Person implements EmployeeInterface{
    //attributes
    final protected String EmployeeId;

    //default constructor
    public Employee(){
        super();
        this.EmployeeId = "";
    }

    //custom constructor that takes 3 parameters
    public Employee(String name, String gender, String EmployeeId){
        super(name, gender);
        this.EmployeeId = EmployeeId;
    }
    @Override
    public String GetGender(){
        return gender;
    }
    @Override
    public String GetName(){
        return name;
    }
    public String GetID(){return EmployeeId;}
}



