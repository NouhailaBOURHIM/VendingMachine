package exceptions;

public class UserInsufficientMoney extends Exception{
    public UserInsufficientMoney(String message) {
        super(message);
    }
}
