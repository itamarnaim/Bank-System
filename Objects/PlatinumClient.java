package Objects;

public class PlatinumClient extends Client {

    private static double commissionRate = 0.01;
    private static double interestRate = 0.05;


    public PlatinumClient(String name, double balance, Rank rank) {
        super(name, balance, rank);
    }

    public PlatinumClient(String name, Rank rank) {
        super(name, rank);
    }

    public PlatinumClient(String name) {
        super(name);
    }

    public static double getCommissionRate() {
        return commissionRate;
    }

    public static void setCommissionRate(double commissionRate) {
        PlatinumClient.commissionRate = commissionRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
