package exceptions;

public class MachineInsufficientStock extends Exception{
    public MachineInsufficientStock(String message) {
        super(message);
    }
}
