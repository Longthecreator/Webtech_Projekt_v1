package Webtech.Projekt.Controller;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
import Webtech.Projekt.Entities.CoinData;
import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Entities.Trade;
import Webtech.Projekt.Repository.ProductRepository;
import Webtech.Projekt.Repository.TradeRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller
@EnableScheduling
public class GreetingsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private CmcApi cmcApi;

    @GetMapping(path="/coins")
    public String testGetRequest(Model model) throws IOException, JSONException, InterruptedException {
        List<CoinData> allCoinData = cmcApi.getAllData();
        model.addAttribute("allCoinData", allCoinData);
        return "coins";

    }

    @GetMapping(path="/history")
    public String history(@AuthenticationPrincipal OidcUser user, Model model) {
        return "history";
    }

    @RequestMapping("/trade")
    public String trade(@AuthenticationPrincipal OidcUser user){
        return "trade";
    }
}

