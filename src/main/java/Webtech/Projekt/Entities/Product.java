package Webtech.Projekt.Entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
//import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String ownerEmail;
    @CreationTimestamp
    private LocalDate datum;

    public Product(){}

    public Product(String name, double price){
        this.name =name;
        this.price = price;
    }

    public String toString(){
        return String.format("Cryptocurreny:[id=%id, name=%name, price=%price]",id,name,price);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //    public List returnAllProducts(){
//
//    }wieso ist das eigentlich noch als ausgeklammert drin?
}
