package Webtech.Projekt.Entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    private double quantity;
    private double changeInPercentage;
    private double profit;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate endDate;
    private boolean status;
    private String ownerEmail;

    public Trade(){}

    public Trade(String name, double price){
        this.name =name;
        this.price = price;
        this.changeInPercentage=0;
        this.endDate = null;
        this.profit= 0;
        this.status=true;
    }


    //Getter and Setter
    public String toString(){
        return String.format("Coin:[id=%id, name=%name, price=%price]", tradeId,name,price);
    }

    public Long getTradeId() {
        return tradeId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getChangeInPercentage() { return changeInPercentage;}

    public double getProfit() {return profit; }

    public LocalDate getEndDate() { return endDate; }

    public LocalDate getCreationDate() { return creationDate; }

    public String getOwnerEmail() { return ownerEmail; }

    public boolean isStatus() {
        return status;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public void setProfit(double profit) { this.profit = profit; }

    public void setChangeInPercentage(double changeInPercentage) {this.changeInPercentage = changeInPercentage;}

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
