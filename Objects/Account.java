package Objects;

import Utils.idGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Account extends ArrayList implements Serializable {

    private long id ;
    protected double balance;


    public Account( double balance) {
        this.id = idGenerator.getAccountID();
        this.balance = balance;
    }
    public Account(){
        this(0);
    }

    public long getId() {

        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        Account account = (Account) other;
        return id == account.id &&
                Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, balance);
    }
}
