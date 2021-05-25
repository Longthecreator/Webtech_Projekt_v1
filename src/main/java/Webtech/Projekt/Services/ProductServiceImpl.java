package Webtech.Projekt.Services;

import Webtech.Projekt.Controller.GreetingsController;
import Webtech.Projekt.Entities.Product;


public class ProductServiceImpl implements ProductService{

    private final GreetingsController gc;

    public ProductServiceImpl(GreetingsController gc) {
        this.gc = gc;
    }

    public void buyCoin(Product p){

    }

    public void sellCoin(Product p){}

    public Iterable<Product> fetchAllCoins(){
        return gc.getAllProducts();
    }

}
