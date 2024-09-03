package com.example.busbookingpackages;

import com.example.busbookingpackages.Data.User;
import com.example.busbookingpackages.Data.Admin.UserData;

public class NewBooking {
    public static void newBooking(String userName){

        UserData.bookTicket(userName);
        System.out.println("newBooking end");
    }
}
