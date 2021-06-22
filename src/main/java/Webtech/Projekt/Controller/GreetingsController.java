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

//    @PostMapping("/add")
//    public @ResponseBody String addNewProduct(@AuthenticationPrincipal OidcUser user, @RequestParam String name, @RequestParam double price) {
//        Product n = new Product();
//        n.setOwnerEmail(user.getEmail());
//        n.setName(name);
//        n.setPrice(price);
//        productRepository.save(n);
//        return "Saved "+name;
//    }

//    @GetMapping(path = "/all")
//    public @ResponseBody Iterable<Product> getAllProducts(){
//        return productRepository.findAll();
//    }

//    @GetMapping(path= "/allproducts")
//    public String productsTable(@AuthenticationPrincipal OidcUser user, Model model){
//        List<Product> products = productRepository.findAll();
//        List<Product> products = productRepository.findByOwnerEmail(user.getEmail());
//        model.addAttribute("products", products);
//        return "productstable";
//    }

    @GetMapping(path="/coins")
    public String testGetRequest(Model model) throws IOException, JSONException, InterruptedException {
        List<CoinData> allCoinData = cmcApi.getAllData();
        model.addAttribute("allCoinData", allCoinData);
        return "coins";

    }

    @RequestMapping("/trade")
    public String trade(@AuthenticationPrincipal OidcUser user, @ModelAttribute Product product, Model model){
//        product.setOwnerEmail(user.getEmail());
        productRepository.save(product);
        model.addAttribute("product", product);
        return "trade";
    }
}

