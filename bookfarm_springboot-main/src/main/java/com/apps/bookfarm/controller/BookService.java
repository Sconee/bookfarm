package com.apps.bookfarm.controller;

import com.apps.bookfarm.model.Book;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public class BookService {
    public String updateBook(Long id, String title, Author author, String publisher, Integer isbn, Integer length, String subjects) {
        return null;
    }

    public String deleteBook(Long id) {
    }

    public String addNewBook(Book book) {
    }

    public CollectionModel<EntityModel<Book>> getBooks() {
    }

    public EntityModel<Book> getBook(Long id) {
    }
}
