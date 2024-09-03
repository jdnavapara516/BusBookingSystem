package com.example.busbookingpackages;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Scanner;

import com.example.busbookingpackages.Data.Admin;

public class AdminPage {
      public static boolean adminPage(String name){
        Scanner input = new Scanner(System.in);
        
        System.out.println("welcome " +  name);
              System.out.println("   1.view all your bus");
              System.out.println("   2.Add new bus");
              System.out.println("   3.Edit your bus");
              System.out.println("   4.Exit");

              int choice1 = input.nextInt();

                if(choice1 == 1){

                    Admin.viewAllYourBus();

                }else if(choice1 == 2){
                    System.out.println("Enter bus number : ");
                    String busNumber = input.next();
                    System.out.println("Enter bus route : ");
                    String busRoute = input.next();
                
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

                    System.out.println("Enter new time (HH:mm): ");
                    String timeInput = input.next();
            
                    LocalTime busTime = LocalTime.parse(timeInput, timeFormatter);
                    Admin.addBus(busNumber,busRoute,busTime);

                }else if(choice1 == 3){
                    System.out.println("Enter bus number : ");
                    String busnumber = input.next();
                    Admin.editBus(busnumber);

                }else if(choice1 == 4){
                    return true;
                }
                return false;
    }
}
