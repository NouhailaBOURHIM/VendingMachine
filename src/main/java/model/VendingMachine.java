package model;

import enums.Coin;
import exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private  int balance=0;
    private List<Product> products;
    private Map<Coin,Integer> coinStock=new HashMap<Coin,Integer>();

    public int getBalance() {
        return balance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Map<Coin, Integer> getCoinStock() {
        return coinStock;
    }

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.coinStock.put(Coin.COIN_10,0);
        this.coinStock.put(Coin.COIN_5,10);
        this.coinStock.put(Coin.COIN_2,10);
        this.coinStock.put(Coin.COIN_1,10);
        this.balance =this.coinStock.get(Coin.COIN_10)*Coin.COIN_10.getValue()+this.coinStock.get(Coin.COIN_5)*Coin.COIN_5.getValue()+this.coinStock.get(Coin.COIN_2)*Coin.COIN_2.getValue()+this.coinStock.get(Coin.COIN_1)*Coin.COIN_1.getValue();
    }

    public Product addProduct(String label, int price, int stock)
     {
         Product product=new Product(label,price,stock);
         products.add(product);
         return product;
     }

    public UserRequest selectProduct(Product productSelected, int givenAmount) throws MachineInsufficientStock, UserInsufficientMoney, NoProductIsSelected, MachineInsufficientBalance, MachineInsufficientCoins {
        Map<Coin,Integer> coins=new HashMap<>();
        if(productSelected.getStock()==0)
        {
            throw new MachineInsufficientStock("No stock is available for this product");
        }
        if(givenAmount<productSelected.getPrice()){
            throw new UserInsufficientMoney("No full Price");
        }
        if(productSelected==null)
        {
            throw new NoProductIsSelected("No product is selected, select one");
        }
        int remainingMoney=remain(productSelected.getPrice(),givenAmount);
        coins=getNumbersOfCoins(remainingMoney);
        UserRequest userRequest=new UserRequest(coins,productSelected);
        updateProductStock(productSelected);
        return userRequest;
    }

    public int remain(int price, int givenAmount) throws MachineInsufficientBalance
    {
        int remainingAmount=givenAmount-price;
        if(remainingAmount>balance){
            throw  new MachineInsufficientBalance("No change is available");
        }
        this.balance-=remainingAmount;
        return remainingAmount;
    }

    public void updateProductStock(Product product)
    {
        product.setStock(product.getStock()-1);
    }

    public int refund(){
        return 0;
    }
    public Map<Coin,Integer> getNumbersOfCoins(int amount)
    {
        Map<Coin,Integer> coins=new HashMap<>();
        int numberCoin10;
        int numberCoin5;
        int numberCoin2;
        int numberCoin1;
        int rest;

        if(amount>10 && coinStock.get(Coin.COIN_10)>0)
        {
            numberCoin10=amount/Coin.COIN_10.getValue();
            rest=coinStock.get(Coin.COIN_10)-numberCoin10;
            if(rest>0){
                coins.put(Coin.COIN_10,numberCoin10);
                amount=amount-numberCoin10*Coin.COIN_10.getValue();
            }
            else {
                coins.put(Coin.COIN_10,coinStock.get(Coin.COIN_10));
                amount=amount-coinStock.get(Coin.COIN_10)*Coin.COIN_10.getValue();
            }

        }
        if(amount>5 && coinStock.get(Coin.COIN_5)>0)
        {
            numberCoin5=amount/Coin.COIN_5.getValue();
            rest=coinStock.get(Coin.COIN_5)-numberCoin5;
            if(rest>0)
            {
                coins.put(Coin.COIN_5,numberCoin5);
                amount=amount-numberCoin5*Coin.COIN_5.getValue();
            }
            else{
                coins.put(Coin.COIN_5,coinStock.get(Coin.COIN_5));
                amount=amount-coinStock.get(Coin.COIN_5)*Coin.COIN_5.getValue();
            }
        }
        if(amount>2 && coinStock.get(Coin.COIN_2)>0)
        {
            numberCoin2=amount/Coin.COIN_2.getValue();
            rest=coinStock.get(Coin.COIN_2)-numberCoin2;
            if(rest>0)
            {
                coins.put(Coin.COIN_2,numberCoin2);
                amount=amount-numberCoin2*Coin.COIN_2.getValue();
            }
            else{
                coins.put(Coin.COIN_2,coinStock.get(Coin.COIN_2));
                amount=amount-coinStock.get(Coin.COIN_2);
            }
        }
        if(amount>1 && coinStock.get(Coin.COIN_1)>0)
        {
            numberCoin1=amount/Coin.COIN_1.getValue();
            coins.put(Coin.COIN_1, numberCoin1);
        }
        return coins;
    }


}
