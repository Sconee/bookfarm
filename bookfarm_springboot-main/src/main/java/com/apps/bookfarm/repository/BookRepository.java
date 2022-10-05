package com.apps.bookfarm.repository;

import com.apps.bookfarm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findByTitle(String title);
}
