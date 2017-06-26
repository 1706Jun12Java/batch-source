package DAO;

import java.sql.*;
import java.util.*;
import org.junit.Test;
import Conutil.*;
import UserDefinedExceptions.*;

public class AccountsDAOImpl implements AccountsDAO {

	@Test
	public void testAccount() {
		try {
			run("User001", "password");
		} catch (BadLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(String username, String password) throws BadLoginException {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = new String("SELECT * FROM BANK_USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
			PreparedStatement ptsmt = con.prepareStatement(sql);
			CallableStatement cs;
			ptsmt.setString(1, username);
			ptsmt.setString(2, password);
			ResultSet rs = ptsmt.executeQuery();

			// check if the user name was found
			if (rs.next()) {
				System.out.println("Welcome " + rs.getString("USER_NAME"));
				int ID = rs.getInt("USER_ID");
				int job = 0;
				Scanner scan = new Scanner(System.in);
				while (job != 6) {
					System.out.println("What would you like to do?");
					System.out.println(
							"1| Check Accounts\n2| Withdrawl\n3| Deposit\n4| Add Account\n5| Delete Account\n6| Logoff");
					job = scan.nextInt();
					boolean hasAccounts = false;
					switch (job) {
					// Get the amount of money in each account for the current
					// user
					case 1:
						printAccountList(con, ID);
						break;
					// Take money from an account
					case 2:
						printAccountList(con, ID);
						System.out.println("Which account will you be withdrawing from?");
						int acc_with = scan.nextInt();
						if (checkForAccount(con, ID, acc_with)) {
							System.out.println("How much will you be withdrawing?");
							int amt_with = scan.nextInt();
							sql = new String("SELECT * FROM ACCOUNTS WHERE USER_ID = ? AND ACCOUNT_ID = ? ");
							ptsmt = con.prepareStatement(sql);
							ptsmt.setInt(1, ID);
							ptsmt.setInt(2, acc_with);
							rs = ptsmt.executeQuery();
							rs.next();
							if ((rs.getInt("AMOUNT") - amt_with) >= 0) {
								sql = "{CALL WITHDRAW_FROM_ACCOUNTS(?,?)}";
								cs = con.prepareCall(sql);
								cs.setInt(1, acc_with);
								cs.setInt(2, amt_with);
								cs.execute();
								System.out.println("You have withdrew $" + amt_with);
							} else
								throw new OverdraftException();
						} else
							throw new AccountDoesNotExistException();
						break;
					// Put money to an account
					case 3:
						printAccountList(con, ID);
						System.out.println("Which account will you be depositing to?");
						int acc_dos = scan.nextInt();
						if (checkForAccount(con, ID, acc_dos)) {
							System.out.println("How much will you be depositing?");
							int amt_dos = scan.nextInt();
							sql = "{CALL DEPOSIT_TO_ACCOUNTS(?,?)}";
							cs = con.prepareCall(sql);
							cs.setInt(1, acc_dos);
							cs.setInt(2, amt_dos);
							cs.execute();
							System.out.println("You have depoisted $" + amt_dos);
						} else
							throw new AccountDoesNotExistException();
						break;
					// create empty account
					case 4:
						sql = new String("INSERT INTO ACCOUNTS (USER_ID,AMOUNT) VALUES ( ? ,DEFAULT)");
						ptsmt = con.prepareStatement(sql);
						ptsmt.setInt(1, ID);
						ptsmt.execute();
						System.out.println("New Account Created");
						break;
					// delete an account with $0
					case 5:
						System.out.println("Which account do you want to delete?");
						sql = new String("SELECT * FROM ACCOUNTS WHERE USER_ID = ? ORDER BY ACCOUNT_ID");
						ptsmt = con.prepareStatement(sql);
						ptsmt.setInt(1, ID);
						rs = ptsmt.executeQuery();
						hasAccounts = false;
						while (rs.next()) {
							int amount = rs.getInt("AMOUNT");
							String canDelete = "";
							if (amount == 0) {
								canDelete = ". This account can be deleted";
							} else {
								canDelete = ". This account can NOT be deleted";
							}
							System.out.println(
									"Account ID: " + rs.getInt("ACCOUNT_ID") + " contains $" + amount + canDelete);
							hasAccounts = true;
						}
						if (!hasAccounts)
							throw new NoAccountsException();

						int accountToDelete = scan.nextInt();

						if (checkForAccount(con, ID, accountToDelete)) {
							sql = new String("DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_ID = ? ");
							ptsmt = con.prepareStatement(sql);
							ptsmt.setInt(1, accountToDelete);
							ptsmt.setInt(2, ID);
							ptsmt.execute();
							System.out.println("Account Deleted");
						} else {
							throw new AccountDoesNotExistException();
						}
						break;
					// log off
					case 6:
						System.out.println("Logging off...");
						break;
					default:
						break;
					}
				}
			} else {
				throw new BadLoginException();
			}
		} catch (SQLException e) {
			System.out.println("Connection Error, Logging Off");
			e.printStackTrace();
			return;
		} catch (NoAccountsException e) {
			System.out.println("Sorry, you don't have any accounts. Try making a new one.");
			run(username, password);
		} catch (AccountDoesNotExistException e) {
			System.out.println("Sorry, you have no account by that number");
			run(username, password);
		} catch (OverdraftException e) {
			System.out.println("You cannot withdraw that much money");
			run(username, password);
		} catch (Exception e) {
			System.out.println("You shouldn't recieve this message");
			return;
		}
	}

	/**
	 * Prints all of a user's accounts
	 * 
	 * @param con
	 *            The connection to the database
	 * @param ID
	 *            The user who wants to see their accounts
	 * @throws SQLException
	 */
	public void printAccountList(Connection con, int ID) throws SQLException {
		System.out.println("These are your current accounts.");
		String sql = new String("SELECT * FROM ACCOUNTS WHERE USER_ID = ? ORDER BY ACCOUNT_ID");
		PreparedStatement ptsmt = con.prepareStatement(sql);
		ptsmt.setInt(1, ID);
		ResultSet rs = ptsmt.executeQuery();
		boolean hasAccounts = false;
		while (rs.next()) {
			System.out.println("Account ID: " + rs.getInt("ACCOUNT_ID") + " contains $" + rs.getInt("AMOUNT"));
			hasAccounts = true;
		}
		if (!hasAccounts)
			throw new NoAccountsException();
	}

	/**
	 * Checks the database for the account for a certain user
	 * 
	 * @param con
	 *            The connection to the database
	 * @param ID
	 *            The user's ID
	 * @param accountNum
	 *            The number of the account to find
	 * @return True if the account was found otherwise an
	 *         AccountDoesNotExistException is thrown
	 * @throws SQLException
	 * @throws AccountDoesNotExistException
	 */
	public boolean checkForAccount(Connection con, int ID, int accountNum)
			throws SQLException, AccountDoesNotExistException {
		String sql = new String("SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_ID = ?");
		PreparedStatement ptsmt = con.prepareStatement(sql);
		ptsmt.setInt(2, ID);
		ptsmt.setInt(1, accountNum);
		ResultSet rs = ptsmt.executeQuery();
		if (rs.next())
			return true;
		throw new AccountDoesNotExistException();
	}

}
