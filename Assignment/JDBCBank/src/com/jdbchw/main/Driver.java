package com.jdbchw.main;

import com.jdbchw.dao.*;
import com.jdbchw.domain.Account;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to Login");
            System.out.println("Enter 2 to Register");
            System.out.println("Enter 3 to exit");
            int choice = scan.nextInt();

            switch(choice){
                case 1:
                    loginToBank(scan);
                    break;
                case 2:
                    createUser(scan);
                    break;
                case 3:
                    return;
            }
        }
    }


    public static void loginToBank (Scanner scan){

        UserSessionImpl loginUser = null;

        System.out.println("Please enter your username (case sensitive)");
        String username = scan.next();
        System.out.println("Please enter your password (case sensitive)");
        String password = scan.next();

        loginUser = new UserSessionImpl();
        loginUser.login(username, password);

        if (loginUser.isOnline())
            userActions(loginUser);
    }

    public static void createUser(Scanner scan){
        UserDao create = new UserImpl();

        System.out.println("Creating User Account!");
        System.out.println("Please enter your username (case sensitive)");
        String username = scan.next();
        System.out.println("Please enter your password (case sensitive)");
        String password = scan.next();
        System.out.println("Please enter your email");
        String email = scan.next();

        create.createUser(username,password,email);
    }

    public static void userActions (UserSessionImpl user){
        Scanner scan = new Scanner(System.in);

        while (user.isOnline()){
            System.out.println("Hello " + user.getUser().getUsername() + "!");
            System.out.println("Enter 1 to view accounts");
            System.out.println("Enter 2 to withdraw");
            System.out.println("Enter 3 to deposit");
            System.out.println("Enter 4 to create account");
            System.out.println("Enter 5 to delete account");
            System.out.println("Enter 6 to logout");
            System.out.println("---------------------------------");
            int action = scan.nextInt();
            switch (action){
                case 1:
                    userBalances(user);
                    break;
                case 2:
                    withdrawBalance(user, scan);
                    break;
                case 3:
                    depositBalance(user, scan);
                    break;
                case 4:
                    createAccount(user, scan);
                    break;
                case 5:
                    deleteAccount(user, scan);
                    break;
                case 6:
                    user.logout();
                    break;
            }
        }
    }

    public static void userBalances(UserSessionImpl user){
        UserDao balance = new UserImpl();
        for (Account i: balance.getAllBalances(user.getUser())) {
            System.out.println(i.toString());
        }
    }

    public static void withdrawBalance(UserSessionImpl user, Scanner scan){
        UserDao userImpl = new UserImpl();
        System.out.println("Select an account.");
        userBalances(user);
        int accountNumber = scan.nextInt();
        System.out.println("Enter amount to withdraw");
        double withdraw = scan.nextDouble();

        userImpl.withdraw(user.getUser(), accountNumber, withdraw);

    }

    public static void depositBalance(UserSessionImpl user, Scanner scan){
        UserDao userImpl = new UserImpl();
        System.out.println("Select an account.");
        userBalances(user);
        int accountNumber = scan.nextInt();
        System.out.println("Enter amount to deposit");
        int deposit = scan.nextInt();
        userImpl.deposit(user.getUser(),accountNumber, deposit);
    }

    public static void createAccount(UserSessionImpl user, Scanner scan){
        UserDao userImpl = new UserImpl();
        userImpl.createAccount(user.getUser());
        userBalances(user);
    }

    public static void deleteAccount(UserSessionImpl user, Scanner scan){
        UserDao userImpl = new UserImpl();
        System.out.println("Select an account.");
        userBalances(user);
        int accountNumber = scan.nextInt();

        userImpl.deleteAccount(user.getUser(), accountNumber);
    }

}
