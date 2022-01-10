package com.company.Patient;

import com.company.Person.*;
import com.company.Doctor.*;
import com.company.Nurse.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Patient extends Person{
    // Date, assigned doctor/nurse, illness, medication, insurance.

    public String date; // date of admission in form of(MM/DD/YYYY)
    String time;//meeting time
    Doctor doc;  // doctor the patient is assigned
    Nurse nurse;  //nurse the patient is assign
    public final String Illness; //type of illness patient is diagnosed of
    public final String Medication; //medication for the patient
    public final String InsuranceId; //ID found on the insurance

    public Patient(){ //default constructor for patient class , initialize everything to null
        super();
        this.date = "";
        this.Illness = "";
        this.Medication = "";
        this.InsuranceId = "";
        this.doc = new Doctor();
        this.nurse = new Nurse();
    }

    //custom constructor for patient class that takes in all the parameters and initializes them
    public Patient(String name, String gender, String date, String insurID, Doctor d, Nurse n, String med, String ill){
        super(name, gender);
        this.date = date;
        this.InsuranceId=insurID;
        this.doc=d;
        this.nurse=n;
        this.Medication= med;
        this.Illness=ill;
    }
    //custom constructor for patient class taking some parameters
    public Patient(String name, String gender, String date, Doctor d, Nurse n){
        super(name,gender);
        this.date = date;
        this.doc=d;
        this.nurse=n;
        Medication="Sample";
        Illness="Sample";
        InsuranceId="Sample";
    }
    public Patient(String ID, Doctor d){
        super();
        InsuranceId=ID;
        this.date="";
        this.time="";
        doc=d;
        Medication="Sample";
        Illness="Sample";
        nurse=null;
    }
    public Patient(String ID, Nurse n){
        super();
        InsuranceId=ID;
        this.date="";
        this.time="";
        doc=null;
        Medication="Sample";
        Illness="Sample";
        nurse=n;
    }

    //methods for setters and getters
    public String getIll(){return Illness;} //returns illness
    public String getMed(){return Medication;}//return Medication
    public String getInsur(){return InsuranceId;}//return patient's insurance ID
    public String getAssignedDoc(){return doc.GetName();}//return assigned doctor
    public String getAssignedNur(){return nurse.GetName();}//return assigned nurse
    public String getDate(){return date;}//return appointment date

    // methods inherited from Person class
    public String GetGender(){ return gender;} //returns string gender
    public String GetName(){ return name;} // returns string name
    public void setTime(String time){this.time=time;}
    public String toString(){
        return ("Name: "+name +"\n gender: " + gender + "\n Insurance ID: " + InsuranceId + "\n Illness: " + Illness + "\n Doctor: " + doc +
                "\n Nurse: " + nurse+"\n Date: "+date+"\n Time: "+time);
    }
    public void setDate(int days){
        Calendar today = Calendar.getInstance();
        String date=null;
        today.add(Calendar.DATE,days);
        java.util.Date temp=today.getTime();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try{
            date = df.format( temp );
        }catch (Exception ex ){
            System.out.println(ex);
        }
        this.date=date;
    }
}