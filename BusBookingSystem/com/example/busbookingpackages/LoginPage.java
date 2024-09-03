package com.example.busbookingpackages;

import java.util.Scanner;
import com.example.busbookingpackages.Data.Admin;

public class LoginPage {

    public static String loginPage() {
        Scanner input = new Scanner(System.in);

        // Prompt for email
        System.out.println("Enter E-mail : ");
        String email = input.next();

        // Prompt for password and re-enter password
        String password = promptForPassword();
        String reenteredPassword = promptForPassword();

        // Check if both passwords match
        if (!password.equals(reenteredPassword)) {
            System.out.println("Your password does not match.");
            return "none";
        }

        // Validate the user with the provided email and password
        String name = Admin.isAdmin(email, password);
        return name;
    }

    private static String promptForPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password : ");
        return input.next();
    }
}
