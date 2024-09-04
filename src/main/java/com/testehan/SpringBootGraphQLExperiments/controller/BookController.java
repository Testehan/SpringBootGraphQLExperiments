package com.testehan.SpringBootGraphQLExperiments.controller;

import com.testehan.SpringBootGraphQLExperiments.model.Author;
import com.testehan.SpringBootGraphQLExperiments.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @QueryMapping
    public List<Book> books() { // same name of method as in the .graphqls file in the Query type
        return Book.books;
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return Book.getBookById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return Author.getAuthorById(book.authorId());
    }
}
