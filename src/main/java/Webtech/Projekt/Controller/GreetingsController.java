package Webtech.Projekt.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @RequestMapping("/")
    public String index(){
        return "Hello world!";
    }
    //Hard Reset
}
