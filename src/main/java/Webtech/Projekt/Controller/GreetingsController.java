package Webtech.Projekt.Controller;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Optional;

@Controller
public class GreetingsController {

    @Autowired
    private Environment env;
    @Autowired
    private ProductRepository productRepository;

    //TestMethode
//    @RequestMapping("/")
//    public String index(){
//        String testValue = Optional.of(env.getProperty("TEST_VALUE")).orElse("Keine");
//        return "Umgebungsvariable: "+ testValue;
//    }

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

//    @GetMapping("/test")
//    public String home(Model m){
//        Data d = new Data(123);
//        m.setAttribute(d.myData);
//    return "template";
//
//
//    }
}

