package be.flixse.graphqldemo.service;


import be.flixse.graphqldemo.model.book.Author;
import be.flixse.graphqldemo.model.book.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id){
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> booksByIds(@Argument List<String> ids){
        return ids.stream()
                .map(id -> Book.getById(id))
                .collect(Collectors.toList());

    }

    @QueryMapping
    public Author authorOfBook(@Argument String bookId){
        return Author.getById(Book.getById(bookId).getAuthorId());
    }
    @SchemaMapping(typeName="Book", field="author")
    public Author author(Book book){
        return Author.getById(book.getAuthorId());
    }


    // pros with GrapQL :
    // Resilience for client developers. They can describe their needs with high flexibility
    // low regression risk and smooth moving between API versions
    //--------------------------------------------------------
    // Issues with GraphQL :
    // Security issue with exhaustive GraphQL queries that make things extremely slow
    // Does not take advantage of the HTTP cache
}
