package com.example.busbookingpackages;

import java.util.Scanner;

public class UserPage {
    
    static MyBooking showTicket = new MyBooking();
    static NewBooking bookTicket = new NewBooking();

    public static void userPage(String userName){
            Scanner input = new Scanner(System.in);

            System.out.println("welcome ");
            System.out.println("   1.New Booking ");
            System.out.println("   2.My Booking ");
            System.out.println("   3.Exit");
        int choice1 = input.nextInt();

        if(choice1 == 1){

            bookTicket.newBooking(userName);

        }else if(choice1 == 2){

              MyBooking.myBooking(userName);

        }else if(choice1 == 3){
            // break;


        }else{

        }
    }

}
