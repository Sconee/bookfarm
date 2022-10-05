package com.apps.bookfarm.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.bookfarm.model.Author;
import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.repository.BookRepository;

@Service

public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book not found"));
        return book;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public String addNewBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findByTitle(book.getTitle());
        if (optionalBook.isPresent()) {
            throw new IllegalStateException("A book with this title exists already");
        }
        bookRepository.save(book);
        return "OK";
    }

    @Transactional
    public String updateBook(
            Long id,
            String title,
            Author author,
            String publisher,
            Integer isbn,
            Integer length,
            String subjects) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book not found"));

        if (title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)) {
            book.setTitle(title);
        }
        if (author != null && !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
        }
        if (publisher != null && publisher.length() > 0 && !Objects.equals(book.getPublisher(), publisher)) {
            book.setPublisher(publisher);
        }
        if (isbn != null && !Objects.equals(book.getIsbn(), isbn)) {
            book.setIsbn(isbn);
        }
        if (length != null && !Objects.equals(book.getLength(), length)) {
            book.setLength(length);
        }
        if (subjects != null && subjects.length() > 0 && !Objects.equals(book.getSubjects(), subjects)) {
            book.setSubjects(subjects);
        }

        return "OK";
    }

    public String deleteBook(Long id) {
        boolean exists = bookRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Book not found");
        }

        bookRepository.deleteById(id);
        return "0K";
    }
}
