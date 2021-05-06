package Webtech.Projekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.util.Optional;

@RestController
public class GreetingsController {

    @Autowired
    private Environment env;
    @RequestMapping("/")
    public String index() {
        String testEnvValue = Optional.of(env.getProperty("Test_VALUE")).orElse("Environment variable not found");
        return "Hello bad trader! You just tried an environment variable" +testEnvValue;
    }
}

