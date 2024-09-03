package com.example.busbookingpackages;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Data {
    static Scanner input = new Scanner(System.in);

    public static class Bus {
        private String busNumber;
        private int capacity = 40;
        private int availableSeats = 40;
        private String route;
        private LocalTime depthTime;

        public Bus(String busNumber, String route, LocalTime depthTime) {
            this.busNumber = busNumber;
            this.route = route;
            this.depthTime = depthTime;
        }
    }

    public static class User {
        protected String name;
        protected String userName;
        protected String email;
        protected String password;
        protected List<Bus> bookedBus = new ArrayList<>();

        public User(String name, String userName, String email, String password) {
            this.name = name;
            this.userName = userName;
            this.email = email;
            this.password = password;
        }

        public void showMyDetail() {
            System.out.println("User Name : " + userName);
            System.out.println("Name : " + name);
            System.out.println("E-mail : " + email);
            System.out.println("Password : " + password);
        }
    }

    public static class Admin {
        private static User admin = new User("Jenil navapara", "Tapovan traveller", "23dce071@gmail.com", "050106");
        private static List<Bus> busData = new ArrayList<>();

        static {
            // Prepopulate with 10 buses
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            for (int i = 1; i <= 10; i++) {
                busData.add(new Bus("Bus" + i, "Route" + i, LocalTime.parse("08:00", timeFormatter)));
            }
        }

        public static String isAdmin(String name, String password) {
            if(admin.email.equalsIgnoreCase(name) && admin.password.equals(password)){
                return name;
            }
            return "none";
        }

        public static void addBus(String busNumber, String route, LocalTime depthTime) {
            Bus newBus = new Bus(busNumber, route, depthTime);
            busData.add(newBus);
        }

        public static void editBus(String busNumber) {
            for (Bus bus : busData) {
                if (bus.busNumber.equals(busNumber)) {
                    System.out.println("Bus Number: " + bus.busNumber + " Available Seats: " + bus.availableSeats + " Route: " + bus.route + " Departure Time: " + bus.depthTime);
                    while (true) {
                        System.out.println("1. Route");
                        System.out.println("2. Time");
                        System.out.println("3. Capacity");
                        System.out.println("4. Exit");
                        int choice = input.nextInt();
                        input.nextLine(); // Consume newline

                        if (choice == 1) {
                            System.out.println("Enter new route: ");
                            String newRoute = input.nextLine();
                            bus.route = newRoute;
                            System.out.println("Updated data: " + bus);
                        } else if (choice == 2) {
                            System.out.println("Enter new time (HH:mm): ");
                            String timeInput = input.nextLine();
                            LocalTime newTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));
                            bus.depthTime = newTime;
                            System.out.println("Updated data: " + bus);
                        } else if (choice == 3) {
                            System.out.println("Enter new capacity: ");
                            int newCapacity = input.nextInt();
                            bus.capacity = newCapacity;
                            System.out.println("Updated data: " + bus);
                        } else if (choice == 4) {
                            break;
                        }
                    }
                    return;
                }
            }
            System.out.println("Bus not found.");
        }

        public static void viewAllYourBus() {
            int i = 1;
            for (Bus bus : busData) {
                System.out.println(i++ + ". Bus Number: " + bus.busNumber + " Available Seats: " + bus.availableSeats + " Route: " + bus.route + " Departure Time: " + bus.depthTime);
            }
        }

        public static void bookSeat(String userName, String userRoute) throws Exception {
            for (Bus bus : busData) {
                if (bus.route.equalsIgnoreCase(userRoute)) {
                    if (bus.availableSeats <= 0) {
                        throw new Exception("No available seats on this bus.");
                    }else {
                        bus.availableSeats--;
                 
                    }
                    return;
                }
            }
            System.out.println("No bus available on this route.");
        }

        public abstract static class UserData {
            static List<User> userData = new ArrayList<>();

            public static void addUser(String name, String userName, String email, String password) {
                User newUser = new User(name, userName, email, password);
                userData.add(newUser);
            }

            public static boolean verifyUser(String userName, String password) {
                for (User user : userData) {
                    if (user.userName.equals(userName) && user.password.equals(password)) {
                        return true;
                    }
                }
                return false;
            }

            public static void bookTicket(String username) {
                for (User user : userData) {
                    if (user.userName.equals(username)) {
                        System.out.println("Enter your destination route: ");
                        String userRoute = input.next();
                        try {
                            Admin.bookSeat(username, userRoute);
                            System.out.println("Ticket booked successfully.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        return;
                    }
                }
                System.out.println("User not found.");
            }

            public static void showMyTickets(String username) {
                for (User user : userData) {
                    if (user.userName.equals(username)) {
                        int i = 1;
                        for (Bus bus : user.bookedBus) {
                            System.out.println(i++ + ". Bus Number: " + bus.busNumber + " Route: " + bus.route + " Departure Time: " + bus.depthTime);
                        }
                        return;
                    }
                }
                System.out.println("User not found.");
            }
        }
    }
}
