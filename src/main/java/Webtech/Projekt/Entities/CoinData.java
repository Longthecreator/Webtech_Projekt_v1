package Webtech.Projekt.Entities;

import java.math.BigDecimal;

public class CoinData {

    private String name;
    private BigDecimal currentPrice;

    public CoinData(){}

    public CoinData(String name, BigDecimal price){
        this.name=name;
        this.currentPrice=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
