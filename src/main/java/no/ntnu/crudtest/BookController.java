package no.ntnu.crudtest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API Controller for Book collection.
 */
@RestController
public class BookController {
    private List<Book> bookList;
    public BookController() {
        bookList = new ArrayList<>();
        fillWithDummyBooks();
        System.out.println(findBookById(1));
    }

    private void fillWithDummyBooks() {
        bookList.add(new Book(100,"WebTek",2010,800));
        bookList.add(new Book(101,"AppDev",2011,700));
        bookList.add(new Book(102,"OS",2000,900));
    }

    @GetMapping("/books")
    public List<Book> getBookList(){
        return bookList;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookList.add(book);

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        ResponseEntity<Book> response;
        Book book = findBookById(id);
        if(book != null){
            response = new ResponseEntity<>(book, HttpStatus.OK);
        }else{
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Book bookToBeDeleted = findBookById(id);
        if(bookToBeDeleted != null){
            bookList.remove(bookToBeDeleted);
            response = new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return response;
    }

    // TODO: 26/01/2022 Find a better way to find a book.
    private Book findBookById(int id){
        return bookList.get(id);
    }
}
