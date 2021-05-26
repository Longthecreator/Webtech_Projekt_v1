package Webtech.Projekt.Services;

import Webtech.Projekt.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ProductService /*extends JpaRepository*/ {
    void buyCoin(Product p);
    void sellCoin(Product p);

    @Query("SELECT name, price from Product")
    Product fetchAllCoins();
}
