package com.apps.bookfarm.controller;

import com.apps.bookfarm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    EntityModel<Book> oneBook (@PathVariable Long id){
        return bookService.getBook(id);
    }

    @GetMapping("/books")
    CollectionModel<EntityModel<Book>> allBooks (){

        return bookService.getBooks();
    }
    @PostMapping
    String addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @PutMapping("{id}")
    String updateBook(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Integer isbn,
            @RequestParam(required = false) Integer length,
            @RequestParam(required = false) String subjects) {
        return bookService.updateBook(id, title, author, publisher, isbn, length, subjects);
    }

    @DeleteMapping("{id}")
    String deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);
    }
}
