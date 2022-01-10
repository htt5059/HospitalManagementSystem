package com.company.Management;


import com.company.Doctor.Doctor;
import com.company.Employee.Employee;
import com.company.Nurse.Nurse;
import com.company.Patient.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//class that management the composition of the classes and has the methods
public class Management{
    public ArrayList<Patient> patientList =new ArrayList<Patient>(); //array list of patients
    public ArrayList<Employee> empolyeeList=new ArrayList<>();
    // --------------------
    Scanner input = new Scanner(System.in);
    String UserChoice, UserChoice2, name, gender, InsuranceID, illness, date, Medication, tomorrow;

    public void setDate(){
        Date today = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try{
            date = df.format( today );
        }catch (Exception ex ){
            System.out.println(ex);
        }
    }

    //Doctor Physician = new Doctor("Sanjay gupta", "male", "1234");

    public void Add_Default_Employee(){
        Employee Physician = new Doctor("Sanjay gupta", "male", "1111",date);
        Employee Physician2 = new Doctor("Eric Cartman", "male", "1112",date);
        Employee Physician3 = new Doctor("John Jones", "male", "1113",date);
        Employee Nurse = new Nurse("erika smith", "female", "1114", date);
        Employee Nurse2 = new Nurse("emily warren", "female", "1115", date);
        Employee Nurse3 = new Nurse("kylie gates", "female", "1116", date);

        empolyeeList.add(Physician);
        empolyeeList.add(Physician2);
        empolyeeList.add(Physician3);
        empolyeeList.add(Nurse);
        empolyeeList.add(Nurse2);
        empolyeeList.add(Nurse3);

    }





    public void Add_Patient(){
        boolean DoctorFound = false;
        boolean NurseFound = false;
        int flagDoctor= 0;
        int flagNurse = 0;

        Employee Obj1 = new Doctor(); //new doctor class
        Employee Obj = new Nurse(); //new nurse class

        //initializing medication,
        Medication = "";

        //getting the time


        System.out.println("Registration Date " + date);


        System.out.println("Enter Your Name(Firstname Lastname)");
        name = input.nextLine();
        //checking name
        while(!name.matches("[a-zA-Z]* [a-zA-Z]*")){
            System.out.println("Enter Your Name");
            name = input.nextLine();
        }

        System.out.println("Enter Your Gender(M/F)");
        gender = input.nextLine();
        //checking gender
        while(!gender.matches("(M|F|m|f)")){
            System.out.println("Enter Your Gender(M/F)");
            gender = input.nextLine();
        }

        System.out.println("Enter Your Insurance ID (7 digits)");
        InsuranceID = input.nextLine();
        //checking insurance ID
        while(!InsuranceID.matches("[0-9]{7}")){
            System.out.println("Enter Your Insurance ID (7 digits)");
            InsuranceID = input.nextLine();
        }

        System.out.println("Enter Patient Illness");
        illness = input.nextLine();
        //checking input
        while(!illness.matches("([a-zA-Z]*|([a-zA-Z]* [a-zA-Z]*))")){
            System.out.println("Enter Patient Illness");
            illness = input.nextLine();
        }

        //if the user already takes medication , we log it, if not we move on.
        System.out.println("is patient currently taking medication(yes/no)");
        UserChoice = input.nextLine();
        while(!UserChoice.matches("(yes|Yes|NO|no|y|n)")){
            System.out.println("is patient currently taking medication(yes/no)");
            UserChoice = input.nextLine();
        }
        if(UserChoice.matches("Yes")|| UserChoice.matches("yes") || UserChoice.matches("YES")|| UserChoice.matches("y")){
            System.out.println("Enter Patient Medication");
            Medication = input.nextLine();
            while(!Medication.matches("([a-zA-Z]*|([a-zA-Z]* [a-zA-Z]*))")){
                System.out.println("Enter Patient Medication");
                Medication = input.nextLine();
            }
        } else{
            Medication = "";//if there is no medication, then it's entered as null
            System.out.println("Lets move on");
        }

        //checks if they already have a physicaian or nurse assigned, if not then it moves on
        System.out.println("has Physician/nurse been assigined(yes/no)");
        UserChoice2 = input.nextLine();
        while(!UserChoice2.matches("(yes|Yes|NO|no|y|n)")){
            System.out.println("has Physician/nurse been assigined(yes/no)");
            UserChoice2 = input.nextLine();
        }
        String NameOfPhysician =""; //initilizing physician name
        if(UserChoice2.matches("Yes")|| UserChoice2.matches("yes") || UserChoice2.matches("YES")|| UserChoice2.matches("y")){
            System.out.println("Enter Physicans name (firstname lastname)");
            NameOfPhysician = input.nextLine();

            while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){
                System.out.println("Enter Physicans name (firstname lastname)");
                NameOfPhysician = input.nextLine();
            }
            //if the input is right
            //check here if the physician assigned are in our system or not


            for(int i = 0; i < empolyeeList.size(); i++){
                if (!(empolyeeList.get(i).GetName().equals(NameOfPhysician))){
                    //System.out.println("Doctor not found");//instead of saying not found we do a boolean flag that goes to a different function
                }
                else{
                    DoctorFound = true;
                    Obj1=empolyeeList.get(i);
                    flagDoctor++;  //flag to find the found doctor
                }
            }
            //we falut check here for checking doctor
            String UserChoice3;
            while(!DoctorFound){
                System.out.println("Doctor is not in the system");
                System.out.println("Would you like to retype(yes/no)");
                UserChoice3 = input.nextLine();
                while(!UserChoice3.matches("(yes|Yes|NO|no|y|n)")){
                    System.out.println("would you like to retype(yes/no)");
                    UserChoice3 = input.nextLine();
                }

                if(UserChoice3.matches("Yes")|| UserChoice3.matches("yes") || UserChoice3.matches("YES")|| UserChoice3.matches("y")){
                    System.out.println("Enter Doctor name (firstname lastname)");
                    NameOfPhysician = input.nextLine();
                    while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){
                        System.out.println("Enter Doctor name (firstname lastname)");
                        NameOfPhysician = input.nextLine();
                    }

                    for(int i = 0; i < empolyeeList.size(); i++) {
                        if (!(empolyeeList.get(i).GetName().equals(NameOfPhysician))) {
                            //System.out.println("Doctor not found");//instead of saying not found we do a boolean flag that goes to a different function
                        } else {
                            DoctorFound = true;
                            Obj1 = empolyeeList.get(i);
                            flagDoctor++;  //flag to find the found doctor
                            System.out.println("doctor has been found");
                        }
                    }
                }else break;
            }


            //check the nurse whether in the list of hospital or not
            System.out.println("Enter Nurse name (firstname lastname)");
            NameOfPhysician = input.nextLine();

            while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){
                System.out.println("Enter Nurse name (firstname lastname)");
                NameOfPhysician = input.nextLine();
            }
            for(int i = 0; i < empolyeeList.size(); i++){
                if (!(empolyeeList.get(i).GetName().equals(NameOfPhysician))){

                }
                else{
                    NurseFound = true;
                    Obj=empolyeeList.get(i);
                    flagNurse++; //flag to get the found nurse
                }
            }


            while(!NurseFound){
                System.out.println("Nurse is not in the system");
                System.out.println("Would you like to retype(yes/no)");
                UserChoice3 = input.nextLine();
                while(!UserChoice3.matches("(yes|Yes|NO|no|y|n)")){
                    System.out.println("would you like to retype(yes/no)");
                    UserChoice3 = input.nextLine();
                }

                if(UserChoice3.matches("Yes")|| UserChoice3.matches("yes") || UserChoice3.matches("YES")|| UserChoice3.matches("y")){
                    System.out.println("Enter Nurse name (firstname lastname)");
                    NameOfPhysician = input.nextLine();
                    while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){
                        System.out.println("Enter Nurse name (firstname lastname)");
                        NameOfPhysician = input.nextLine();
                    }

                    for(int i = 0; i < empolyeeList.size(); i++){
                        if (!(empolyeeList.get(i).GetName().equals(NameOfPhysician))){
                            //System.out.println("Doctor not found");//instread of saying not found we do a boolean flag that goes to a different function
                        }
                        else{
                            NurseFound = true;
                            Obj=empolyeeList.get(i);
                            flagNurse++;  //flag to find the found doctor
                            System.out.println("Nurse has been found");
                        }
                    }

                }else break;
            }

//choose the date->print schedule -> patient next -> create new Date object next


        } else{

            System.out.println("they are assigned a doctor/nurse automatically");


        }


        Patient patientOne = new Patient(name,gender,date,InsuranceID,(Doctor)Obj1,(Nurse)Obj,Medication,illness);
        patientList.add(patientOne);
        patientOne.setTime(Date_menu((Doctor)Obj1,(Nurse)Obj, patientOne));


        System.out.println("Patient has been registered to the system");
        System.out.println("returning to main menu");





    }

    public void All_Patient_in_System(){
        System.out.println("Printing all Patient info");
        System.out.println("------------------------------------------------------------------");

        if(patientList.size() == 0){
            System.out.println("There are currently no Patients registered in the system");
        }else {
            for(int i = 0; i < patientList.size(); i++){
                System.out.println(patientList.get(i)); //prints all the patients
            }
        }
    }

    public void Info_menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to Information Section");
        System.out.println("Press 1, to search Patient Individually");
        System.out.println("Press 2, to see all the Patient in the system");
        System.out.println("Press -1, to go to main menu");
        System.out.println("---------------------------------------------------");
    }

    public void Look_up_info(){
        boolean FoundPatient = false;
        int flagPatient = 0;
        System.out.println("Enter Patient Name(Firstname Lastname)");
        name = input.nextLine();
        while(!name.matches("[a-zA-Z]* [a-zA-Z]*")){
            System.out.println("Enter Patient Name(Firstname Lastname)");
            name = input.nextLine();
        }

        for(int i = 0; i < patientList.size(); i++){
            if(patientList.get(i).GetName().matches(name)){
                FoundPatient = true;
                flagPatient = i;
            }
        }

        if(FoundPatient){
            System.out.println("The patient has been found");
        }else{
            int a = 4 ; //just putting something here
        }
        String UserChoice4;
        while(!FoundPatient){
            System.out.println("Patient is not in the system");
            System.out.println("Would you like to retype(yes/no)");
            UserChoice4= input.nextLine();
            while(!UserChoice4.matches("(yes|Yes|NO|no|y|n)")){
                System.out.println("would you like to retype(yes/no)");
                UserChoice4 = input.nextLine();
            }
            if(UserChoice4.matches("Yes")|| UserChoice4.matches("yes") || UserChoice4.matches("YES")|| UserChoice4.matches("y")){
                System.out.println("Enter Patient name (firstname lastname)");
                name = input.nextLine();
                while(!name.matches("[a-zA-Z]* [a-zA-Z]*")){
                    System.out.println("Enter Patient name (firstname lastname)");
                    name= input.nextLine();
                }

                for(int i = 0; i < patientList.size(); i++){
                    if (!(patientList.get(i).GetName().equals(name))){
                        //System.out.println("Doctor not found");//instead of saying not found we do a boolean flag that goes to a different function
                    }
                    else{
                        FoundPatient = true;
                        flagPatient = i;  //flag to find the found doctor
                        System.out.println("Patient has been found");
                    }
                }

            }else{
                break;
            }
        }
        if(FoundPatient){System.out.println(patientList.get(flagPatient));}
        //System.out.println(patientList.get(flagPatient));
        System.out.println("returning to main menu");
    }
    public String Date_menu(Doctor d, Nurse n, Patient p){
        //booking meeting with doctor.
        String choice;
        if(!d.checkDate()){
            //if doctor's date is unavailable, create a new date
            Calendar tmr= Calendar.getInstance();
            tmr.roll(Calendar.DATE, true);
            Date temp=tmr.getTime();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            try{
                tomorrow = df.format( temp );
            }catch (Exception ex ){
                System.out.println(ex);
            }
            d.dates.add(new com.company.Date.Date(tomorrow));
            System.out.println("Select one of the following time: ");
            d.dates.get(d.dates.size()-1).getPTime();//print the doctor's available time
            choice=input.nextLine();
            while(!choice.matches("\\d")){
                System.out.println("Select one of the following time: ");
                choice=input.nextLine();
            }
            n.bookMeeting(tomorrow, choice);
            n.addPatient(p);
            d.addPatient(p);
            return d.bookMeeting(tomorrow, choice);
        }
        else{
            for(com.company.Date.Date D: d.dates){
                System.out.println("Select one of the following time: ");
                D.getPTime();
                choice=input.nextLine();
                while(!choice.matches("\\d")){
                    System.out.println("Select one of the following time: ");
                    choice=input.nextLine();
                }
                n.bookMeeting(date, choice);
                n.addPatient(p);
                d.addPatient(p);
                return d.bookMeeting(date,choice);
            }
        }
        return "Err";
    }
    public void bookAppoint_menu(){
        System.out.println("When do you want to book an appointment?(in days) ");
        String userDate=input.nextLine();
        while(!userDate.matches("\\d")){
            System.out.println("When do you want to book an appointment?(in days) ");
            userDate=input.nextLine();
        }
        System.out.println("Enter Your Insurance ID (7 digits)");
        InsuranceID = input.nextLine();
        //checking insurance ID
        while(!InsuranceID.matches("[0-9]{7}")){
            System.out.println("Enter Your Insurance ID (7 digits)");
            InsuranceID = input.nextLine();
        }
        Patient temp=null;
        boolean check=false;
        for(Patient p: patientList){//check whether this patient is in the system.
            if(p.GetName().equals(name)){
                check=true;
                temp=p;
                break;
            }
        }
        System.out.println("Appointment with doctor or nurse: (d/n)");
        String user=input.nextLine();
        while(!user.matches("[d]|[n]")){
            System.out.println("Appointment with doctor or nurse: (d/n)");
            user=input.nextLine();
        }
        if(check==true){//this patient is already in the system.
            if(user.equals("d")){
                    System.out.println("Enter your doctor's name (firstname lastname): ");
                    String NameOfPhysician=input.nextLine();
                    while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){//check name input
                        System.out.println("Enter doctor name (firstname lastname)");
                        NameOfPhysician = input.nextLine();
                    }
                    for(Employee D: empolyeeList){
                        if(D.GetName().equals(NameOfPhysician)){
                            System.out.println("Enter appointment time (HH:MM): ");
                            user=input.nextLine();
                            while(!user.matches("[0][1-9]|[1][0-9]|[2][0-4]:[0-5][0-9]")){//check time input.
                                System.out.println("Enter appointment time (HH:MM): ");
                                user=input.nextLine();
                            }
                            D.bookAppoint(Integer.parseInt(userDate), user);
                            temp.setTime(user);
                            temp.setDate(Integer.parseInt(userDate));
                        }
                    }
            }else{//this patient appoints with nurse.
                System.out.println("Enter your nurse's name (firstname lastname): ");
                String NameOfPhysician=input.nextLine();
                while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){//check name input
                    System.out.println("Enter nurse name (firstname lastname)");
                    NameOfPhysician = input.nextLine();
                }
                for(Employee N: empolyeeList){
                    if(N.GetName().equals(NameOfPhysician)){
                        System.out.println("Enter appointment time (HH:MM): ");
                        user=input.nextLine();
                        while(!user.matches("[0][1-9]|[1][0-9]|[2][0-4]:[0-5][0-9]")){//check time input.
                            System.out.println("Enter appointment time (HH:MM): ");
                            user=input.nextLine();
                        }
                        N.bookAppoint(Integer.parseInt(userDate), user);
                        temp.setTime(user);
                        temp.setDate(Integer.parseInt(userDate));
                    }
                }
            }
        }else if(check==false){//this patient is not in the system
            if(user.equals("d")){
                System.out.println("Enter your doctor's name (firstname lastname): ");
                String NameOfPhysician=input.nextLine();
                while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){//check name input
                    System.out.println("Enter doctor name (firstname lastname)");
                    NameOfPhysician = input.nextLine();
                }
                for(Employee D: empolyeeList){
                    if(D.GetName().equals(NameOfPhysician)){
                        System.out.println("Enter appointment time (HH:MM): ");
                        user=input.next();
                        while(!user.matches("[0][1-9]|[1][0-9]|[2][0-4]:[0-5][0-9]")){//check time input.
                            System.out.println("Enter appointment time (HH:MM): ");
                            user=input.next();
                        }
                        D.bookAppoint(Integer.parseInt(userDate), user);
                        temp=new Patient(InsuranceID, (Doctor)D);
                        patientList.add(temp);
                        temp.setTime(user); temp.setDate(Integer.parseInt(userDate));
                    }
                }
            }else{
                System.out.println("Enter your nurse's name (firstname lastname): ");
                String NameOfPhysician=input.nextLine();
                while(!NameOfPhysician.matches("[a-zA-Z]* [a-zA-Z]*")){//check name input
                    System.out.println("Enter nurse name (firstname lastname)");
                    NameOfPhysician = input.nextLine();
                }
                for(Employee N: empolyeeList){
                    if(N.GetName().equals(NameOfPhysician)){
                        System.out.println("Enter appointment time (HH:MM): ");
                        user=input.next();
                        while(!user.matches("[0][1-9]|[1][0-9]|[2][0-4]:[0-5][0-9]")){//check time input.
                            System.out.println("Enter appointment time (HH:MM): ");
                            user=input.next();
                        }
                        N.bookAppoint(Integer.parseInt(userDate), user);
                        temp=new Patient(InsuranceID, (Nurse)N);
                        patientList.add(temp);
                        temp.setTime(user); temp.setDate(Integer.parseInt(userDate));
                    }
                }
            }
        }
    }

    public void printSchedule(String id){
        for(Employee D: empolyeeList){
            if(D.GetID().equals(id)){
                D.FollowUpDate();
                return;
            }
        }
        for(Employee N: empolyeeList){
            if(N.GetID().equals(id)){
                N.FollowUpDate();
                return;
            }
        }
        System.out.println("Cannot find that employee with "+ id);
    }
}
