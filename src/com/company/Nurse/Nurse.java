package com.company.Nurse;

import com.company.Employee.*;
import com.company.Patient.Patient;
import com.company.Date.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Nurse extends Employee implements EmployeeInterface {
    public ArrayList<Patient> NursePatientList = new ArrayList<Patient>(10); //list of patient nurse has
    public ArrayList<Date> dates=new ArrayList<Date>();

    public Nurse(){
        super();
    }
    public void addPatient(Patient p){NursePatientList.add(p);}

    public String toString(){
        return this.name;
    }

    public Nurse(String name, String Gender, String id){
        super(name,Gender,id);
    }
    public Nurse(String name, String gender, String id, String date){
        super(name, gender, id);
        dates.add(new Date(date));
    }
    @Override
    public String GetGender() {
        return gender;
    }

    @Override
    public String GetName() {
        return name;
    }

    public void FollowUpDate(){
        for(Date d: dates){
            d.getETime();
        }
    }

    @Override
    public String bookMeeting(String date, String index) {
        String time;
        for(Date d: dates){
            if(d.equals(date)){
                time=d.bookMeeting(index);
                System.out.println("Your meeting has been add!");
                return time;
            }
        }
        return "Meeting Err!";
    }

    @Override
    public String bookAppoint(int days, String time) {
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
        for(Date d: dates){//this date is already in the system.
            if(d.getDate().equals(date)){
                return d.bookAppoint(time);
            }
        }
        //if not then create new date in the system
        dates.add(new Date(date));
        return dates.get(dates.size()-1).bookAppoint(time);
    }
}
