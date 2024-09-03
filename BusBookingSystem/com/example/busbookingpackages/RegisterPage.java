package com.example.busbookingpackages;

import java.util.Scanner;

import com.example.busbookingpackages.Data.Admin.UserData;

public class RegisterPage {
    
    public static String registerPage(){
        UserPage nextPage = new UserPage();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Name : ");
        String name = input.nextLine();

        System.out.println("Enter User Name : ");
        String username = input.nextLine();

        System.out.println("Enter E-mail : ");
        String email = input.nextLine();
        int password1;
        while (true) {
        
        System.out.println("Enter Password : ");
         password1 = input.nextInt();
        System.out.println("Re-Enter Password : ");
        int password2 = input.nextInt();
        
            if(password1 ==password2){
                break;
            }else{
                System.out.println("Your password does not match..");
            }
        }
        String n  = Integer.toString(password1);
        
        UserData.addUser(name,username,email,n);
        System.out.println("registerpage end");

     return username;
    }
}
