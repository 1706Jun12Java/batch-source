package Assignment2;

import Assignment2.DAO.AccountController;
import Assignment2.DAO.UserController;
import Assignment2.model.Account;
import Assignment2.model.User;

import java.util.List;
import java.util.Scanner;

/**
 * Created by John on 6/24/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("=====Welcome to JV bank, for all your banking needs.======"
                + "\nIf you have an account then press 1."
                + "\nIf not, press 9");

        // TODO check inputs
        int x = input.nextInt();

        String username;
        String password;

        String firstName;
        String lastName;
        int accountType;
        User user;

        switch (x)
        {
            case 1:
                System.out.println("Enter your username: ");
                username = input.next();
                System.out.println("Now enter your password");
                password = input.next();

                //TODO  maybe add a restriction
                while (!User.authUser(username, password))
                {
                    System.out.println("Wrong username or password. Please try again.");
                    System.out.println("Enter your username: ");
                    username = input.next();
                    System.out.println("Now enter your password");
                    password = input.next();
                }

                user = new UserController().getUserByUsername(username);

                List<Account> accountList = new AccountController().getAccounts(user.getId());

                accountPicker(accountList, user, input);
                break;
            case 9:
                System.out.println("Thank you for choosing JV bank " +
                        "\nFirst you need to fill out the required fields...." +
                        "\nEnter your first name");
                firstName = input.next();
                System.out.println("Now enter your last name");
                lastName = input.next();
                System.out.println("Type in a username which you will use to login from now on");
                username = input.next();

                while (!User.isUsernameAvailable(username))
                {
                    System.out.println("Sorry, that username is taken already! Pick another one");
                    username = input.next();
                }

                System.out.println("Now type in your password, and remember to keep it safe! (Case sensitive)");
                password = input.next();

                user = new UserController().createUser(firstName, lastName, username, password);

                // setting up account
                System.out.println("What type of account would you like?" +
                        "\n1.Checking" +
                        "\n2.Savings");
                accountType = input.nextInt();

                // TODO need a check for any other number
                Account acc = new AccountController().createAccount(user.getId(), accountType);

                accountActivity(acc, input);

                System.out.println("You're all set up!" +
                        "\nRemember you can login with your username and password anytime to check your balance and account" +
                        "\nHave a great day! Goodbye.");
                break;

            default:
                System.out.println("Something went wrong. Try again later");
        }

        input.close();
    }

    /**
     * Let user pick what account they want to view
     * @param accountList the list of accounts related to them
     * @param input a scanner object for taking in inputs
     */
    private static void accountPicker(List<Account> accountList, User user, Scanner input)
    {
        Account account;
        String accName;
        int choice = 0;

        System.out.println("Which account would you like to view: ");

        for (int i = 0;  i < accountList.size(); i++)
        {
            // TODO proper input validations
            if (accountList.get(i).getAccountType() == 1)
                accName = "Checking";
            else
                accName = "Savings";

            System.out.println(i + " - " + accName);
        }

        System.out.println("9 - Create a new account");
        choice = input.nextInt();

        if (choice == 9)
        {
            System.out.println("What type of account would you like?" +
                    "\n1 - Checking" +
                    "\n2 - Savings");
            choice = input.nextInt();

            Account acc = new AccountController().createAccount(user.getId(), choice);
            if (acc == null)
            {
                System.out.println("Sorry you have an account of that type");
                accountPicker(accountList, user, input);
            }

            accountActivity(acc, input);
        }
        else
        {
            account = accountList.get(choice);

            accountActivity(account, input);
        }
    }

    private static void accountActivity(Account account, Scanner input)
    {

        int choice;
        System.out.println("What would you like to do today?" +
                "\n 1 - View balance" +
                "\n 2 - Deposit" +
                "\n 3 - Withdraw" +
                "\n 4 - Delete account" +
                "\n 0 - Exit");
        choice = input.nextInt();

        int amount;

        switch (choice)
        {
            case 1:
                System.out.println("You currently have " + account.getBalance());
                break;
            case 2:
                System.out.println("How much are you going to deposit today?");
                amount = input.nextInt();
                depositCash(account, amount);
                break;
            case 3:
                System.out.println("How much are you going to withdraw today?");
                amount = input.nextInt();
                withdrawCash(account, amount);
                break;
            case 4:
                deleteActivity(account);
            case 0:
                break;

            default:
                System.out.println("Sorry, that wasn't a valid input");
                accountActivity(account, input);
        }
    }

    private static void depositCash(Account account, int amount)
    {
        AccountController ac = new AccountController();
        if (!ac.deposit(amount, account.getUser().getId(), account.getAccountType() ) )
            System.out.println("something went wrong, try again later! Goodbye");
        else
            System.out.println("Your cash has been deposited!");
    }

    private static void withdrawCash(Account account, int amount)
    {
        AccountController ac = new AccountController();

        if (ac.withdraw(amount, account.getUser().getId(), account.getAccountType()) == -1)
            System.out.println("Error occurred please talk to a bank representative.");
        else
            System.out.println("Cash is being dispense below. Have a great day!");
    }

    private static void deleteActivity(Account account)
    {
        AccountController ac = new AccountController();
        if (!ac.deleteAccount(account.getUser().getId(), account.getAccountType()) )
            System.out.println("Error, you can't delete this account cause balance is not zero!");
        else
            System.out.println("Success, your account was deleted");
    }
}
