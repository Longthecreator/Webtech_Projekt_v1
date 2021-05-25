package Webtech.Projekt.Controller;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import Webtech.Projekt.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GreetingsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

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
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "productstable";
    }

//   @GetMapping("/test")
//   public String home(Model m){
//      Data d = new Data();
//       m.setAttribute(d.myData);
//       return "template";
//    }
}

