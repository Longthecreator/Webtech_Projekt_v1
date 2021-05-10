package Webtech.Projekt.Controller;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class GreetingsController {

    @Autowired
    private ProductRepository productRepository;

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
}

