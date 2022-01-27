package no.ntnu.crudtest;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API Controller for Author collection.
 */
@RestController
public class AuthorController {
    private List<Author> authors;
    public AuthorController() {
        authors = new ArrayList<>();
        fillWithAuthors();

    }

    private void fillWithAuthors() {
        authors.add(new Author(001,"Ola","OLast",1980));
        authors.add(new Author(002,"Peder","PLast",1970));
        authors.add(new Author(003,"Jonas","JLast",1980));
    }
}
