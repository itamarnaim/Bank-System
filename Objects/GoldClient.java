package Objects;

public class GoldClient extends Client {



    private static double commissionRate = 0.02;
    private static double interestRate = 0.03;


    public GoldClient(String name, double balance, Rank rank) {
        super(name, balance, rank);
    }

    public GoldClient(String name, Rank rank) {
        super(name, rank);
    }

    public GoldClient(String name) {
        super(name);
    }

    public static double getCommissionRate() {
        return commissionRate;
    }

    public static void setCommissionRate(double commissionRate) {
        GoldClient.commissionRate = commissionRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
