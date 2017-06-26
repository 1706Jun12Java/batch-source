package DAO;

import java.sql.*;
import java.util.Scanner;

import org.junit.*;

import Conutil.ConnectionUtil;
import DAO.*;
import UserDefinedExceptions.*;

public class AdminDAOImpl implements AdminDAO {

	@Test
	public void testAdmin() {
		try {
			run("Master", "!Pass001!");
		} catch (BadLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(String username, String password) throws BadLoginException {
		Connection con;
		Scanner scan = new Scanner(System.in);
		try {
			// check database for username and password
			con = ConnectionUtil.getConnection();
			String sql = new String("SELECT * FROM ADMINS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, username);
			ptsmt.setString(2, password);
			ResultSet rs = ptsmt.executeQuery();

			if (rs.next()) {
				System.out.println("Welcome Admin, what would you like to do?");
				int job = 0;
				while (job != 5) {
					System.out.println("1| See All Users\n2| Add User\n3| Update User\n4| Clear All\n5| Log Off");
					job = scan.nextInt();
					switch (job) {
					// print list of all users and accounts
					case 1:
						printSuperList(con);
						break;
					// Add a new user
					case 2:
						try {
							System.out.println("New Username:");
							String newUser = scan.next();
							sql = new String("SELECT * FROM BANK_USERS WHERE USER_NAME = ? ");
							ptsmt = con.prepareStatement(sql);
							ptsmt.setString(1, newUser);
							rs = ptsmt.executeQuery();
							// check to see if name is taken
							if (rs.next())
								throw new UserNameTakenException();
							else {
								// add new name
								System.out.println("New Password:");
								String newPass = scan.next();
								sql = new String("INSERT INTO BANK_USERS (USER_NAME,USER_PASSWORD) VALUES (?,?)");
								ptsmt = con.prepareStatement(sql);
								ptsmt.setString(1, newUser);
								ptsmt.setString(2, newPass);
								ptsmt.execute();
								System.out.println("User created successfully.");
							}
						} catch (UserNameTakenException e) {
							System.out.println("User name was taken. Please try another name");
							this.run(username, password);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							break;
						}
						break;
					// Alter a user
					case 3:
						int update = 0;
						printSuperList(con);
						// select user
						System.out.println("What user do you want to change?");
						int userToChange = scan.nextInt();
						sql = new String("SELECT * FROM BANK_USERS WHERE USER_ID = ?");
						ptsmt = con.prepareStatement(sql);
						ptsmt.setInt(1, userToChange);
						rs = ptsmt.executeQuery();
						if (rs.next()) {
							System.out.println("What do you want to update?");
							System.out.println("1| Username\n2| Password\n3| Accounts");
							update = scan.nextInt();
							switch (update) {
							// change username
							case 1:
								System.out.println("What do you want to change the username to?");
								String newUsername = scan.next();
								sql = new String("SELECT * FROM BANK_USERS WHERE USER_NAME = ? ");
								ptsmt = con.prepareStatement(sql);
								ptsmt.setString(1, newUsername);
								rs = ptsmt.executeQuery();
								if (rs.next()) {
									throw new UserNameTakenException();
								} else {
									sql = new String("UPDATE BANK_USERS SET USER_NAME = ? WHERE USER_ID = ?");
									ptsmt = con.prepareStatement(sql);
									ptsmt.setString(1, newUsername);
									ptsmt.setInt(2, userToChange);
									ptsmt.execute();
									System.out.println("Change successful");
								}
								break;
							// change password
							case 2:
								System.out.println("What do you want to change the password to?");
								String newPassword = scan.next();
								sql = new String("UPDATE BANK_USERS SET USER_PASSWORD = ? WHERE USER_ID = ?");
								ptsmt = con.prepareStatement(sql);
								ptsmt.setString(1, newPassword);
								ptsmt.setInt(2, userToChange);
								ptsmt.execute();
								System.out.println("Change successful");
								break;
							// change account
							case 3:
								sql = new String("SELECT * FROM ACCOUNTS WHERE USER_ID = ? ORDER BY ACCOUNT_ID");
								ptsmt = con.prepareStatement(sql);
								ptsmt.setInt(1, userToChange);
								rs = ptsmt.executeQuery();
								while (rs.next()) {
									System.out.println(
											"Account #" + rs.getInt("ACCOUNT_ID") + " holds $" + rs.getInt("AMOUNT"));

								}
								System.out.println("Which account do you want to change?");
								int accountToEdit = scan.nextInt();
								if (checkForAccount(con, accountToEdit)) {
									System.out.println("What do you want to change the value to?");
									int newVal = scan.nextInt();
									sql = new String("UPDATE ACCOUNTS SET AMOUNT = ? WHERE ACCOUNT_ID = ?");
									ptsmt = con.prepareStatement(sql);
									ptsmt.setInt(1, newVal);
									ptsmt.setInt(2, accountToEdit);
									ptsmt.execute();
									System.out.println("Change completed successfully");
								} else
									throw new AccountDoesNotExistException();
								break;
							}
						} else
							throw new NoAccountsException();
						break;
					case 4:
						System.out.println("Clearing all...");
						sql = new String("DELETE FROM BANK_USERS");
						ptsmt = con.prepareStatement(sql);
						ptsmt.execute();
						sql = new String("DELETE FROM ACCOUNTS");
						ptsmt = con.prepareStatement(sql);
						ptsmt.execute();
						System.out.println("Successfully cleared all");
						break;
					case 5:
						System.out.println("Logging off...");
						ptsmt.close();
						con.close();
						return;
					}
				}
			} else {
				throw new BadLoginException();
			}
		} catch (BadLoginException e) {
			throw new BadLoginException();
		} catch (NoAccountsException e) {
			System.out.println("Sorry, that does not exist");
			run(username, password);
			return;
		} catch (UserNameTakenException e) {
			System.out.println("Sorry, that username is taken");
			run(username, password);
			return;
		} catch (AccountDoesNotExistException e) {
			System.out.println("That account does not exist.");
			run(username, password);
			return;
		} catch (Exception e) {
			System.out.println("You should not see this message");
			System.out.println(e.getMessage());
			System.out.println("Logging off...");
			return;
		}
	}

	/**
	 * 
	 * @param con
	 *            The connection to the database
	 * @throws SQLException
	 */
	public void printSuperList(Connection con) throws SQLException {
		System.out.println("List of all accounts");
		String sql = new String("SELECT * FROM BANK_USERS ORDER BY USER_ID");
		PreparedStatement ptsmt = con.prepareStatement(sql);
		ResultSet bURS = ptsmt.executeQuery();
		ResultSet aCRS;
		while (bURS.next()) {
			sql = new String("SELECT * FROM ACCOUNTS WHERE USER_ID = ? ORDER BY ACCOUNT_ID");
			ptsmt = con.prepareStatement(sql);
			ptsmt.setInt(1, bURS.getInt("USER_ID"));
			aCRS = ptsmt.executeQuery();
			System.out.println("User #" + bURS.getInt("USER_ID") + ": " + bURS.getString("USER_NAME") + " Password: "
					+ bURS.getString("USER_PASSWORD"));
			while (aCRS.next()) {
				System.out.println("Account #" + aCRS.getInt("ACCOUNT_ID") + " holds $" + aCRS.getInt("AMOUNT"));
			}
		}
	}

	/**
	 * Checks the database for an account
	 * 
	 * @param con
	 *            The connection to the database
	 * @param accountNum
	 *            The number of the account to find
	 * @return True if the account was found otherwise an
	 *         AccountDoesNotExistException is thrown
	 * @throws SQLException
	 * @throws AccountDoesNotExistException
	 */
	public boolean checkForAccount(Connection con, int accountNum) throws SQLException, AccountDoesNotExistException {
		try {
			String sql = new String("SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?");
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setInt(1, accountNum);
			ResultSet rs = ptsmt.executeQuery();
			if (rs.next())
				return true;
			throw new AccountDoesNotExistException();
		} catch (Exception e) {
			return false;
		}
	}
}
