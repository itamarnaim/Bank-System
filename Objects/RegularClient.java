package Objects;

public class RegularClient extends Client {

    private static double commissionRate = 0.03;
    private  static double interestRate = 0.01;



    public RegularClient(String name, double balance, Rank rank) {
        super(name, balance, rank);
    }

    public RegularClient(String name, Rank rank) {
        super(name, rank);
    }

    public RegularClient(String name) {
        super(name);
    }

    public static double getCommissionRate() {
        return commissionRate;
    }

    public static void setCommissionRate(double commissionRate) {
        RegularClient.commissionRate = commissionRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }



}
