package Webtech.Projekt.Controller;

import Webtech.Projekt.config.Endpoints;
import Webtech.Projekt.config.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

    @GetMapping(path = Endpoints.INDEX)
    public ModelAndView showIndex(){
        return new ModelAndView(ViewNames.INDEX);
    }
}
