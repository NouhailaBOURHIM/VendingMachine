package model;

import enums.Coin;

import java.util.Map;

public class UserRequest {
    private Product productSelected;
    private Map<Coin,Integer> remainingMoney;;

    public UserRequest(Map<Coin, Integer> remainingMoney, Product productSelected) {
        this.remainingMoney = remainingMoney;
        this.productSelected = productSelected;
    }

    public Map<Coin, Integer> getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(Map<Coin, Integer> remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    public Product getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(Product productSelected) {
        this.productSelected = productSelected;
    }
}
