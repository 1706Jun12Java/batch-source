package Main;

import java.util.*;

import DAO.*;
import UserDefinedExceptions.*;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int job = 0;
		try {
			while (job != 3) {
				System.out.println("Hello. What do you want to do?");
				System.out.println("Select One:");
				System.out.println("1| Login\n2| Sign Up\n3| Login as Admin\n4| Quit");
				job = scan.nextInt();
				switch (job) {
				// Logging In
				case 1:
					AccountsDAO acc = new AccountsDAOImpl();
					System.out.println("Insert Username");
					String username = scan.next();
					System.out.println("Insert Password");
					String password = scan.next();
					acc.run(username, password);
					break;
				// Creating a new user
				case 2:
					System.out.println("Insert Username");
					String newUser = scan.next();
					System.out.println("Insert Password");
					String newPass = scan.next();
					BankUsersDAO bkUser = new BankUsersDAOImpl();
					bkUser.addUser(newUser, newPass);
					break;
				case 3:
					System.out.println("Insert Username");
					String adminUser = scan.next();
					System.out.println("Insert Password");
					String adminPass = scan.next();
					AdminDAO ad = new AdminDAOImpl();
					ad.run(adminUser, adminPass);
					break;
				case 4:
					System.out.println("Terminating...");
					return;
				default:
					System.out.println("I'm sorry, that is not an option");
					main(args);
					return;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("I'm sorry, that is possibly not even a number");
			main(args);
			return;
		} catch (BadLoginException e) {
			System.out.println("Login Failed");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
