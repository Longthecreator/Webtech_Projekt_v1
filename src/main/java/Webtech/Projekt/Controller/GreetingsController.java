package Webtech.Projekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@RestController
public class GreetingsController {
    @RequestMapping("/")
    public String index() {
        return "Hello world!";
    }
}
//    @Entity
//    public class Product {
//        @Id
//        @GeneratedValue(strategy= GenerationType.IDENTITY)
//        private Long id;
//        private String name;
//        private int priceontime;
//
//        public Waehrung() {}
//        public Waehrung(String name,int priceontime) {
//            this.name= name;
//            this.priceontime=priceontime;
//        }
//    }

//    @Autowired
//    private WaehrungRepository wearungRepository;
    //Hard Reset

