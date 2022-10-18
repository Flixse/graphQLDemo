package be.flixse.graphqldemo.service;


import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingsController {

    @QueryMapping
    public String hello() {
        return "Hello, world!";
    }

}