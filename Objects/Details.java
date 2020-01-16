package Objects;

public class Details extends Exception {

    private long clientId;
    private double currentBalance;
    private double withdrawAmunt;

    public Details(String message, long clientId, double currentBalance, double withdrawAmunt) {
        super(message);
        this.clientId = clientId;
        this.currentBalance = currentBalance;
        this.withdrawAmunt = withdrawAmunt;
    }

    public long getClientId() {
        return clientId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getWithdrawAmunt() {
        return withdrawAmunt;
    }
}
