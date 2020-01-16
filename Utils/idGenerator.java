package Utils;

public class idGenerator {

    private static long accountID;
    private static long clientID;

    public static long getAccountID (){
        return ++accountID;
    }

    public static long getClientID(){
        return ++ clientID;
    }


}
