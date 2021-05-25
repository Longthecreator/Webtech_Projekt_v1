package Webtech.Projekt.Services;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;

import java.util.List;

public interface ProductService {
    void buyCoin(Product p);
    void sellCoin(Product p);
    Iterable<Product> fetchAllCoins();
}
