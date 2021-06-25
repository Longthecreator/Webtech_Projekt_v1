package Webtech.Projekt.Controller;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
import Webtech.Projekt.Entities.CoinData;
import Webtech.Projekt.Entities.Trade;
import Webtech.Projekt.Repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@RestController
public class FontendRestController {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private CmcApi cmcApi;

    @PostMapping("/doTrade")
    public @ResponseBody
    Trade doTrade(@AuthenticationPrincipal OidcUser user, @RequestParam String name, @RequestParam BigDecimal price){
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        int coinId=0;
        if(name.equals("Bitcoin")){
            coinId=0;
        }
        else if(name.equals("Litecoin")){
            coinId=1;
        }
        else if(name.equals("Dogecoin")){
            coinId= 2;
        }
        else if(name.equals("Ethereum")){
            coinId= 3;
        }
        else if(name.equals("Cardano")){
            coinId= 4;
        }
        BigDecimal currentCoinPrice = cmcApi.getAllData().get(coinId).getCurrentPrice();
        Trade trade = new Trade();
        trade.setOwnerEmail(user.getEmail());
        trade.setName(cmcApi.getAllData().get(coinId).getName());
        trade.setPrice(price);
        trade.setStatus(true);
        trade.setClosePrice(new BigDecimal(0));
        trade.setBoughtAt(cmcApi.getAllData().get(coinId).getCurrentPrice());
        trade.setQuantity(price.divide(currentCoinPrice, mc).multiply(new BigDecimal(1)));
        trade.setProfit(cmcApi.getAllData().get(coinId).getCurrentPrice().subtract(trade.getBoughtAt()));
        trade.setChangeInPercentage(currentCoinPrice.subtract(trade.getBoughtAt(), mc).divide(trade.getBoughtAt(), mc).multiply(new BigDecimal(100)));
        return tradeRepository.save(trade);
    }

    @GetMapping("/getCoinData")
    public List<CoinData> bla(){
        return cmcApi.getAllData();
    }

    @PostMapping("/closeTrade")
    public void closeTrade(@AuthenticationPrincipal OidcUser user,@RequestParam Long tradeId){
        List<Trade> tradeList= tradeRepository.findTradeByOwnerEmail(user.getEmail());
        for(Trade t : tradeList) {
            if (t.getTradeId() == tradeId) {
                t.setStatus(false);
                int coinId=0;
                if(t.getName().equals("Bitcoin")){
                    coinId=0;
                }
                else if(t.getName().equals("Litecoin")){
                    coinId=1;
                }
                else if(t.getName().equals("Dogecoin")){
                    coinId= 2;
                }
                else if(t.getName().equals("Ethereum")){
                    coinId= 3;
                }
                else if(t.getName().equals("Cardano")){
                    coinId= 4;
                }
                t.setClosePrice(cmcApi.getAllData().get(coinId).getCurrentPrice());
                tradeRepository.save(t);
            }
        }
    }

    @GetMapping("/getActualTrades")
    public List<Trade> getActualUserTrades(@AuthenticationPrincipal OidcUser user, Model model){
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        List<Trade> tradeList= tradeRepository.findTradeByOwnerEmailAndStatusIsTrueOrderByTradeId(user.getEmail());
        int coinId=0;
        for(Trade trade: tradeList){
            if(trade.getName().equals("Bitcoin")){
                coinId = 0;
            }
            else if(trade.getName().equals("Litecoin")){
                coinId= 1;
            }
            else if(trade.getName().equals("Dogecoin")){
                coinId= 2;
            }
            else if(trade.getName().equals("Ethereum")){
                coinId= 3;
            }
            else if(trade.getName().equals("Cardano")){
                coinId= 4;
            }
            trade.setProfit((cmcApi.getAllData().get(coinId).getCurrentPrice().subtract(trade.getBoughtAt())).multiply(trade.getQuantity()));
            trade.setChangeInPercentage(cmcApi.getAllData().get(coinId).getCurrentPrice().subtract(trade.getBoughtAt(), mc).divide(trade.getBoughtAt(), mc).multiply(new BigDecimal(100)));
            tradeRepository.save(trade);
        }
        return tradeList;
    }

    @GetMapping("/getAllClosedTrades")
    public List<Trade> getClosedTrades(@AuthenticationPrincipal OidcUser user){
        return tradeRepository.findTradeByOwnerEmailAndStatusOrderByTradeId(user.getEmail(), false);
    }

    @GetMapping("/getTotalOpenTrades")
    public BigDecimal totalOpenTrades(@AuthenticationPrincipal OidcUser user){
        List<Trade> tradeList = tradeRepository.findTradeByOwnerEmailAndStatusIsTrueOrderByTradeId(user.getEmail());
        BigDecimal totalOpen = new BigDecimal(0);
        for(Trade trade : tradeList){
            totalOpen = totalOpen.add(trade.getProfit());
        }
        System.out.println("Total:"+totalOpen);
        return totalOpen;
    }

    @GetMapping("/getTotalClosedTrades")
    public BigDecimal totalClosedTrades(@AuthenticationPrincipal OidcUser user){
        List<Trade> tradeList = tradeRepository.findTradeByOwnerEmailAndStatusOrderByTradeId(user.getEmail(), false);
        BigDecimal totalOpen = new BigDecimal(0);
        for(Trade trade : tradeList){
            totalOpen = totalOpen.add(trade.getProfit());
        }
        System.out.println("Total:"+totalOpen);
        return totalOpen;
    }

}
