package Webtech.Projekt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //public pages
                .antMatchers(
                        HttpMethod.GET,
                        Endpoints.INDEX,
                        Endpoints.COINS
                        ).permitAll()
                .antMatchers(
                        "static/javascript/**"
                ).permitAll()
                .anyRequest().authenticated()

                .and()
                .logout().logoutSuccessUrl("/")

                .and()
                .oauth2Client()
                .and()
                .oauth2Login()
                .and()
                .csrf()
                .disable();

    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login().and().csrf().disable();
//    }
}
