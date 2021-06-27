package webtech.projekt.controller;

import webtech.projekt.coinMarketCap_API.CmcApi;
import webtech.projekt.entities.CoinData;
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
public class EndpointsController {

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

    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}

