package Webtech.Projekt.Controller;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class GreetingsController {

    @Autowired
    private ProductRepository productRepository;

    private CmcApi cmcApi;

    @PostMapping("/add")
    public @ResponseBody String addNewProduct(@RequestParam String name, @RequestParam double price) {
        Product n = new Product();
        n.setName(name);
        n.setPrice(price);
        productRepository.save(n);
        return "Saved"+name;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping(path= "/allproducts")
    public String productsTable(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productstable";
    }

    @GetMapping(path="/test")
    public void testGetRequest(Model model) throws IOException {
        try {
            cmcApi.requestMethodFour();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
//        model.addAttribute(response);
//        return "trade";
    }


}

