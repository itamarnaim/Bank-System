package Objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Client> clients;
    private Logger logger;
    private Logger logService;
    private double balance;
    private static Bank instance ;
    private static double commissionSum;
    private static final int  MAX_CLIENTS =10;



    // constructor for Singleton class
    private Bank (){}

    public double getBalance() {
        return balance;
    }

    public ArrayList<Client> getClients(){
        return clients;
    }
    // Method for create only one object of Bank.
    public synchronized static Bank getInstance(){
        if(instance == null){
            instance = new Bank();
        }
        return instance;
    }



    public double setBalance(){
        double sumClientBalance = 0;
        double sumBankBalance = balance;
        for (int i = 0; i < MAX_CLIENTS ; i ++) {
            sumClientBalance += clients.get(i).getFortune();
            sumBankBalance += sumClientBalance;
            sumBankBalance = balance;

        }
        return balance + commissionSum;

    }
    public double getSumBankBalanc(){
        return balance;
    }
    public void addClient(Client client){

        double bankBalance = 0;
        boolean canAddClient = false;
        int addIndex = 0;
        for (int i = 0 ; i < MAX_CLIENTS ; i ++){
            if (clients.get(i) == null){
                canAddClient = true;
                addIndex = i;
                break;

            }
        }
        if (! canAddClient){
            System.out.println("There is no space for add new client");
            return;
        }
        clients.set(addIndex, client);
        bankBalance = client.getBalance();
        balance += bankBalance;



    }


    public void removeClient(int id){

        if(id < 0 && id > MAX_CLIENTS){
            System.out.println("This ID number is not valid , the ID number need to be between 1 to 10");
        }

        double bankBalance = 0 ;
        for ( int i = 0 ; i < MAX_CLIENTS ; i ++){
            if (clients.equals(id)){
                bankBalance = getBalance();
                bankBalance = setBalance() - balance;
                clients.set(id, null);

            }
            else {
                System.out.println("There is no client for this id");
            }
        }

    }

    public static double addCommission(double withdraw){
        return commissionSum ;
    }

    public void printClientList(){

    }

//    public static void store() {
//        ArrayList<Client> clientArrayList = new ArrayList<>();
//        try {
//            (BufferedReader reader = new BufferedReader(new FileReader(bank.data)) ){
//                while (reader.ready()) {
//                    clientArrayList.add(1, 1);
//                }
//            }
//        } catch (IOException e) {
//
//        }
//
//    }
}
