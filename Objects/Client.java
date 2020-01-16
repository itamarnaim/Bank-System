package Objects;

import Utils.idGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Client implements Serializable {

    private long id;
    private Rank rank;
    private String name;
    private double balance;
    private ArrayList<Account> accounts;
    protected double commissionRate;
    protected double interesrRate;

    private static final int MAX_ACCOUNTS = 4;

    public Client(String name, double balance, Rank rank) {
        this.id = idGenerator.getClientID();
        this.name = name;
        this.balance = balance;
        this.accounts = new  ArrayList<Account>(MAX_ACCOUNTS);
        this.rank = rank;

    }

    public Client(String name, Rank rank) {
        this(name, 0, rank);

    }

    public Client(String name) {
        this.name = name;
        this.rank = Rank.REGULAR;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private static boolean isValidIndex(int index) {
        return (index >= 0 && index < MAX_ACCOUNTS);
    }

    public void addAccount(Account account) {
        boolean canAdd = false;
        int addIndex = 0;

        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            if (accounts.get(i) == null) {
                canAdd = true;
                addIndex = i;
                break;
            }
        }
        if (!canAdd) {
            System.out.println("There is no space for another account");
            return;
        }
        accounts.set(addIndex, account);


    }



    public Account getAccount (int index, Account account) {

        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            if (account.equals(index)) {
                return account;
            }
            index++;

        }return null;

    }
    public void removeAccount(int index){
        if (!isValidIndex(index)){
            System.out.println("Invalid Index to remove ");
            return;
        }
        Account accountToRemove = accounts.get(index);
        if (accountToRemove == null){
            System.out.printf("There is no account at index %d\n",index);
            return;
        }
        setBalance(getBalance() + accountToRemove.getBalance());
        accounts.set(index, null);
        Logger.log(accounts.get(index));


    }

    public double getFortune(){

        double sum = balance;
        for (Account account:accounts) {
            if (account != null){
                sum += account.getBalance();
            }
        }
        return sum;

    }
    public void deposit(double deposit){
        switch (rank){
            case REGULAR:
                commissionRate = RegularClient.getCommissionRate();
                setBalance(getBalance() + (deposit - (deposit * commissionRate)));
                break;

            case GOLD:
                commissionRate = 0.02;
                setBalance(getBalance() + (deposit - (deposit * commissionRate)));
                break;

            case PLATINUM:
                commissionRate = 0.01;
                setBalance(getBalance() + (deposit - (deposit * commissionRate)));
        }

    }

    public void wirhdraw ( double wirhdraw) throws Details{
        switch (rank){
            case REGULAR:
                if (wirhdraw > getBalance()){
                    throw new Details(" The amount to withdraw is greater than the current client balance.",getId(),getBalance(),wirhdraw);
                }

                setBalance(getBalance() - (wirhdraw - (wirhdraw * RegularClient.getCommissionRate())));
                Bank.addCommission(wirhdraw * RegularClient.getCommissionRate());
                break;

            case GOLD:

                setBalance(getBalance() - (wirhdraw - (wirhdraw * GoldClient.getCommissionRate())));
                Bank.addCommission(wirhdraw * GoldClient.getCommissionRate());
                break;

            case PLATINUM:

                setBalance(getBalance() - (wirhdraw - (wirhdraw * PlatinumClient.getCommissionRate())));
                Bank.addCommission(wirhdraw * PlatinumClient.getCommissionRate());
        }
    }

    public void autoUpdateAccount(){
        double balanceUpdate = 0;
        switch (rank){
            case REGULAR:
//                interesrRate = 0.01;

                for (Account account: accounts) {
                    if (account == null){
                        System.out.println("There is no value in the account to calculate daily regular interest");
                    }

                    else {
                        balanceUpdate = account.getBalance();
                        balanceUpdate = (balanceUpdate + (balanceUpdate * RegularClient.getInterestRate()));
                        account.setBalance(balanceUpdate);

                    }

                }

            case GOLD:

                for (Account account: accounts) {
                    if (account == null){
                        System.out.println("There is no value in the account to calculate daily gold interest");
                    }

                    else {
                        balanceUpdate = account.getBalance();
                        balanceUpdate = (balanceUpdate + (balanceUpdate * GoldClient.getInterestRate()));
                        account.setBalance(balanceUpdate);

                    }

                }

            case PLATINUM:

                for (Account account: accounts) {
                    if (account == null){
                        System.out.println("There is no value in the account to calculate daily platinum gold interest");
                    }

                    else {
                        balanceUpdate = account.getBalance();
                        balanceUpdate = (balanceUpdate + (balanceUpdate * PlatinumClient.getInterestRate()));
                        account.setBalance(balanceUpdate);

                    }

                }


        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Double.compare(client.balance, balance) == 0 &&
                Double.compare(client.commissionRate, commissionRate) == 0 &&
                Double.compare(client.interesrRate, interesrRate) == 0 &&
                rank == client.rank &&
                Objects.equals(name, client.name) &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, name, balance, accounts, commissionRate, interesrRate);
    }

    public String accountsToString(){
        String accountsString = "\naccounts: [\n";
        for (Account account: accounts){
            accountsString += account + "\n";
        }
        accountsString += "]\n";
        return accountsString;
    }




    @Override
    public String toString() {

            return "Client{" +
                    "ID=" + id +
                    ", rank='" + rank + '\'' +
                    ", name='" + name + '\'' +
                    ", balance=" + balance +
                    accountsToString() +
                    ", commissionRate=" + commissionRate +
                    ", interestRate=" + interesrRate +
                    '}';

        }
}

