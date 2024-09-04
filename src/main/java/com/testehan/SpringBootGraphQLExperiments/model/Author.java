package com.testehan.SpringBootGraphQLExperiments.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(Integer id, String name) {
    public static List<Author> authors = Arrays.asList(
            new Author(1, "JK Rowling"),
            new Author(2, "Tolkien"),
            new Author(3, "CS Lewis")

    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
