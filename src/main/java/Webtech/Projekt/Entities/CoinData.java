package Webtech.Projekt.Entities;

import Webtech.Projekt.Repository.ProductRepository;

public class CoinData {

    private String name;
    private double currentPrice;

    public CoinData(){}

    public CoinData(String name, double price){
        this.name=name;
        this.currentPrice=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
