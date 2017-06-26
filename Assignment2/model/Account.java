package Assignment2.model;

/**
 * Account model
 * <p>
 * Created by John on 6/24/2017.
 */
public class Account
{
    private int id;
    private int accountType;
    private User user;
    private int balance;


    public Account(int id, int accountType, User user, int balance)
    {
        this.id = id;
        this.accountType = accountType;
        this.user = user;
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "Account{" +
                "id=" + id +
                ", accountType=" + accountType +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAccountType()
    {
        return accountType;
    }

    public void setAccountType(int accountType)
    {
        this.accountType = accountType;
    }
}
