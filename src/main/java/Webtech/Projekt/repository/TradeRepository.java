package Webtech.Projekt.repository;

import Webtech.Projekt.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    List<Trade> findTradeByOwnerEmail(String ownerEmail);
    List<Trade> findTradeByOwnerEmailAndStatusOrderByTradeId(String ownerEmail, boolean status);
    List<Trade> findTradeByOwnerEmailAndStatusIsTrueOrderByTradeId(String ownerEmail);
}
