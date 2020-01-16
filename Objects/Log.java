package Objects;

public class Log {

    private long timeStamp;
    private int clientId;
    private String description;
    private long amount;

    public Log(long timeStamp, int clientId, String description, long amount) {
        this.timeStamp = timeStamp;
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
    }

    public String getData(){
        return "";
    }

    @Override
    public String toString() {
        return "Log{" +
                "timeStamp=" + timeStamp +
                ", clientId=" + clientId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
