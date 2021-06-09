package Webtech.Projekt.Controller;

import Webtech.Projekt.Entities.Product;
import Webtech.Projekt.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FontendRestController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public @ResponseBody
    String addNewProduct(@AuthenticationPrincipal OidcUser user, @RequestParam String name, @RequestParam double price) {
        Product n = new Product();
        n.setOwnerEmail(user.getEmail());
        n.setName(name);
        n.setPrice(price);
        productRepository.save(n);
        return "Saved "+name;
    }
}
