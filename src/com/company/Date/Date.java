package com.company.Date;

public class Date {
    String date;
    String[] time= {"08:00-08:30","08:30-09:00","09:00-09:30","09:30-10:00","10:00-10:30","10:30-11:00",
            "13:00-13:30","13:30-14:00","14:30-15:00","15:00-15:30"};
    //begin: hh:mm, end:hh:mm, meeting time: hh:mm-hh:mm
    public Date(String date){
        this.date=date;
    }
    public String getDate(){return date;}
    public boolean checkTime(){
        for(String c: time){
            if (c.substring(11).equals("")) return true;
        }
        return false;
    }
    public String bookMeeting(String index){
        time[Integer.parseInt(index)]=time[Integer.parseInt(index)]+" booked";
        return time[Integer.parseInt(index)];
    }
    public String bookAppoint(String t){
        String[] temp=new String[time.length+1];
        for(int i=0; i<time.length; i++){
            temp[i]=time[i];
        }
        temp[time.length-1]=t+" booked";
        time=temp;
        return time[time.length-1];
    }

    public void getETime(){//Doctors and Nurses' calender
        System.out.println("Date: "+date);
        for(int i=0; i<time.length; i++){
            System.out.println((i)+":"+time[i]);
        }
    }
    public void getPTime(){//Time available that patients can book appointment
        System.out.println("Date: "+date);
        for(int i=0; i<time.length; i++){
            if (time[i].substring(11).equals("")) System.out.println((i)+": "+time[i].toString());
        }
    }
}
