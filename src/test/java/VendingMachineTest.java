import exceptions.MachineOutOfStock;
import exceptions.UserInsufficientMoney;
import model.Product;
import model.VendingMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    @BeforeEach
    void setUp(){
        vendingMachine=new VendingMachine();
        vendingMachine.addProduct("Mirendina",5,0);
        vendingMachine.addProduct("Tango",3,5);
        vendingMachine.addProduct("KitKat",13,7);
        vendingMachine.addProduct("Snickers",15,6);
        vendingMachine.addProduct("Milka",26,3);
    }
    @Test
    public void givenAmountUnderProductPrice_withSelectProduct_thenThrowUserInsufficientMoney(){
            Product product=vendingMachine.getProducts().get(1);
            Assertions.assertThrows(UserInsufficientMoney.class,()->vendingMachine.selectProduct(product,2));
    }

    @Test
    public void givenUnavailableProduct_withSelectProduct_thenThrowMachineOutOfStock()
    {
        Product product=vendingMachine.getProducts().get(0);
        Assertions.assertThrows(MachineOutOfStock.class,()->vendingMachine.selectProduct(product,5));
    }
}
