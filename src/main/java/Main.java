import exceptions.MachineInsufficientBalance;
import model.VendingMachine;

public class Main {
    public static void main(String[] args) throws MachineInsufficientBalance {
        VendingMachine vendingMachine;
        vendingMachine=new VendingMachine();

        System.out.println(vendingMachine.remain(5,10));
    }
}
