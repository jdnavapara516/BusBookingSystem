package com.example.busbookingpackages;

import java.util.*;

public class UserOrAdmin {
    
    public String UserorAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("      *************************");
        System.out.println("      *         Hello !       *");
        System.out.println("      *  1.USER      2.ADMIN  *");
        System.out.println("      *************************");

        int answer = input.nextInt();
        
        if(answer == 1){
            return "user";
        }else if(answer == 2){
            return "admin";
        }else{
            return "none";
        }
    }
}
