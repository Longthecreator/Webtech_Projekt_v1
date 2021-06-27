package webtech.projekt.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private BigDecimal boughtAt;
    @Column(nullable = true)
    private BigDecimal closePrice;
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    private BigDecimal changeInPercentage;
    @Column(nullable = false)
    private BigDecimal profit;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate closeDate; //bzw. lastUpdated
    @Column(nullable = false)
    private boolean status;
    private String ownerEmail;

    public Trade(){}

    public Trade(String name, BigDecimal price){
        this.name =name;
        this.price = price;
        this.changeInPercentage=new BigDecimal(0);
        this.closeDate = null;
        this.profit= new BigDecimal(0);
        this.status=true;
    }


    //Getter and Setter
    public String toString(){
        return String.format("Coin:[id=%id, name=%name, price=%price]", tradeId,name, price);
    }

    public Long getTradeId() {
        return tradeId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getChangeInPercentage() { return changeInPercentage;}

    public BigDecimal getProfit() {return profit; }

    public LocalDate getCloseDate() { return closeDate; }

    public LocalDate getCreationDate() { return creationDate; }

    public String getOwnerEmail() { return ownerEmail; }

    public boolean isStatus() {
        return status;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public void setCloseDate(LocalDate closeDate) { this.closeDate = closeDate; }

    public void setProfit(BigDecimal profit) { this.profit = profit; }

    public void setChangeInPercentage(BigDecimal changeInPercentage) {this.changeInPercentage = changeInPercentage;}

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(BigDecimal boughtAt) {
        this.boughtAt = boughtAt;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }
}
