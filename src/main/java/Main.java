import exceptions.MachineInsufficientBalance;
import model.VendingMachine;

public class Main {
    public static void main(String[] args) throws MachineInsufficientBalance {
        VendingMachine vendingMachine;
        vendingMachine=new VendingMachine();

        System.out.println(vendingMachine.getNumbersOfCoins(25).toString());

    }
}
