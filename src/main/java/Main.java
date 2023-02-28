import exceptions.*;
import model.Product;
import model.VendingMachine;

public class Main {
    public static void main(String[] args) throws MachineInsufficientBalance, MachineOutOfStock, UserInsufficientMoney, NoProductIsSelected, MachineInsufficientCoins {
        VendingMachine vendingMachine;
        vendingMachine=new VendingMachine();
        Product product=new Product("Mirendina",5,0);
        vendingMachine.addProduct("Mirendina",5,0);
        vendingMachine.addProduct("Tango",3,5);
        vendingMachine.addProduct("KitKat",13,7);
        vendingMachine.addProduct("Snickers",15,6);
        vendingMachine.addProduct("Milka",26,3);

        System.out.println(vendingMachine.selectProduct(product,3));

    }
}
