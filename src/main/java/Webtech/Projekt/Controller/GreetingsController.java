package Webtech.Projekt.Controller;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Optional;

@RestController
public class GreetingsController {

    @Autowired
    private Environment env;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello World";
        //        String testEnvValue = Optional.of(env.getProperty("Test_VALUE")).orElse("Environment variable not found");
//        return "Hello bad trader! You just tried an environment variable" +testEnvValue;
    }

//    @GetMapping("/products")
//    public List<Product> allProducts(){
//        return
//    }
}

