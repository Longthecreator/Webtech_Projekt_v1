package Webtech.Projekt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

    @GetMapping(path = "/test")
    public ModelAndView showTest(){
        return new ModelAndView("index");
    }
}
