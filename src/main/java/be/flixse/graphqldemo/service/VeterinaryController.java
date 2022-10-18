package be.flixse.graphqldemo.service;

import be.flixse.graphqldemo.model.book.Author;
import be.flixse.graphqldemo.model.book.Book;
import be.flixse.graphqldemo.model.veterinary.Dog;
import be.flixse.graphqldemo.model.veterinary.Veterinary;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class VeterinaryController {

    @QueryMapping
    private Dog dogById(@Argument  String id){
        return Dog.getById(id);
    }

    @SchemaMapping
    public Veterinary veterinary(Dog dog){
        return Veterinary.getById(dog.getVeterinaryId());
    }

    @SchemaMapping
    public List<Dog> dogs(Veterinary veterinary){
        return Veterinary.getById(veterinary.getId()).getDogs().stream().map(Dog::getById).collect(Collectors.toList());
    }
}
