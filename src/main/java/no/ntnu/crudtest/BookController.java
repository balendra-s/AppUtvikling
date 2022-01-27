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
    //private List<Integer> authorList;
    public BookController() {
        bookList = new ArrayList<>();
        //authorList = new ArrayList<>();
        fillWithDummyBooks();

    }


    private void fillWithDummyBooks() {
        Author firstAuthor = new Author(004,"First","Author",1999);
        Author secondAuthor = new Author(005,"Second","Author",1998);
        Author thirdAuthor = new Author(006,"Third","Author",1997);

        //authorList.add(firstAuthor.getId());
        //authorList.add(secondAuthor.getId());
        bookList.add(new Book(100,"WebTek",2010,800));
        bookList.add(new Book(101,"AppDev",2011,700));
        bookList.add(new Book(102,"OS",2000,900));
       // bookList.add(new Book(103,"fysikk",2001,1000,authorList));

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


    private Book findBookById(int id){
        Book foundBook = null;
        for(Book book:bookList){
            if(id == book.getId()){
                foundBook = book;
            }
        }
        return foundBook;
    }
}
