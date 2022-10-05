package com.apps.bookfarm;


import com.apps.bookfarm.model.Author;
import com.apps.bookfarm.repository.AuthorRepository;
import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    public static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase (AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {

            //Create two authors
            Author authorOne = new Author("John Mutiso", 3579);
            Author authorTwo = new Author("Emily Jefferson", 2468);

            //Save authorOne to the Author entity
            authorRepository.save(authorOne);
            authorRepository.save(authorTwo);

            //Create and save book instance
            bookRepository.save(new Book("Programming 101",
                    authorOne,
                    "MacMilan",
                    123456,
                    245,
                    "Programming, IT, Coding"));

            bookRepository.save(new Book("Advanced Database",
                    authorTwo,
                    "McGraw Hill",
                    24589,
                    300,
                    "Programming, Databases"));


            //Create and save new authors
            authorRepository.save(new Author("Mike Wallace", 23456));
            //Log the author entry
            authorRepository.findAll().forEach(author -> log.info("Preloaded Author: " + author));
            bookRepository.findAll().forEach(book -> log.info("Preloaded Book: " + book));
        };
    }

}
