package Webtech.Projekt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @RequestMapping("/)")
    public String Greetings(){
        return "Hello world!";
    }

}
