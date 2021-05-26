package Webtech.Projekt.Entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private LocalDate time;

    public Coin(){}

    public Coin(String name, double price){
        this.name =name;
        this.price = price;
        this.time = LocalDate.now();
    }

    public String toString(){
        return String.format("Coin:[id=%id, name=%name, price=%price]",id,name,price);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
