package Webtech.Projekt.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController(Endpoints.INDEX).setViewName(ViewNames.INDEX);
        registry.addViewController(Endpoints.LOGIN).setViewName(ViewNames.LOGIN);
        registry.addViewController(Endpoints.COINS).setViewName(ViewNames.COINS);
        //registry.addViewController(Endpoints.TRADE).setViewName(ViewNames.TRADE);
    }
}
