package com.company.Doctor;

import com.company.Employee.*;

import com.company.Patient.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.company.Date.*;

public class Doctor extends Employee implements EmployeeInterface {

    public ArrayList<Patient> DoctorPatientList= new ArrayList<Patient>(10); //list of patients doctor has
    public ArrayList<Date> dates=new ArrayList<Date>();
    public Doctor(){
        super();
    }

    public Doctor(String name, String gender, String id, String date){
        super(name, gender, id);
        dates.add(new Date(date));
    }

    public String toString(){
        return this.name;
    }
    public void addPatient(Patient p){DoctorPatientList.add(p);}

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
        for(int i=0; i<dates.size();i++){
            if(dates.get(i).getDate().equals(date)){
                time=dates.get(i).bookMeeting(index);
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

    public void showDate(){
        for(Date d: dates){
            d.getPTime();
        }
    }
    public boolean checkDate(){
        for(Date d: dates){
            if(d.checkTime()) return true;//available
        }
        return false;
    }
}

