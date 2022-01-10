package com.company;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import com.company.Management.*;

//things to consider using
//try catch
//exception handling
//to string methods for the classes

public class Main {

    public static void main(String[] args) {
        // write your code here
        Operations one = new Operations();
        one.UserDisplay();
    }
}

class Operations{
    //function for just the menu of the system
    public void PrintMenu(){
        System.out.println("--------------------------------------------");
        System.out.println("Welcome to the Hospital Management System");
        System.out.println("Press  1, Register New Patients");
        System.out.println("Press  2, Look up Patients information");
        System.out.println("Press  3, Schedule Appointment");
        System.out.println("Press  4, Follow-up Dates");
        System.out.println("Press -1, to exit the system");
        System.out.println("--------------------------------------------");
    }

    //system that interacts with the user to do different things
    public void UserDisplay(){
        Management one = new Management();
        one.setDate();
        one.Add_Default_Employee();
        Scanner in = new Scanner(System.in);
        String UserChoice;
        String UserChoice2;
        PrintMenu();
        UserChoice = in.nextLine();


        while(!UserChoice.matches("(1|2|3|4|-1)")){
            PrintMenu();
            UserChoice = in.nextLine();
        }

        while(!UserChoice.equals("-1")) {
            if(!UserChoice.equals("-1")){ //not exisiting
                if(UserChoice.equals("1")){
                    one.Add_Patient();
                }else if(UserChoice.equals("2")){
                    //user wants to look up patient info
                    //System.out.println("looking up info");
                    //one.Look_up_info();
                    one.Info_menu(); //prints the menu
                    String UserChoice3 = in.nextLine();
                    while(!UserChoice3.matches("(1|2|-1)")){
                        one.Info_menu();
                        UserChoice3 = in.nextLine();

                    }
                    while(!UserChoice3.equals("-1")){
                        if(!UserChoice3.equals("-1")){
                            if(UserChoice3.equals("1")){
                                one.Look_up_info();
                            }else if(UserChoice3.equals("2")){
                                one.All_Patient_in_System();
                            }
                        }
                        one.Info_menu();
                        UserChoice3 = in.nextLine();
                        while(!UserChoice3.matches("(1|2|-1)")){
                            PrintMenu();
                            UserChoice3 = in.nextLine();

                        }
                    }

                }else if(UserChoice.equals("3")){
                    //user wants to schedule appointment
                    one.bookAppoint_menu();

                }else if(UserChoice.equals("4")){
                    //print doctor and nurse schedule.
                    System.out.println("Enter your employee ID: ");
                    String id= in.nextLine();
                    while(!id.matches("[0-9]{4}")){
                        System.out.println("Enter your employee ID: ");
                        id= in.nextLine();
                    }
                    one.printSchedule(id);
                }
            }

            PrintMenu();
            UserChoice = in.nextLine();

        }
    }



}

