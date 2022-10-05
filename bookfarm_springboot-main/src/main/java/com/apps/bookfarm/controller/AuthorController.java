package com.apps.bookfarm.controller;


import com.apps.bookfarm.repository.AuthorRepository;
import com.apps.bookfarm.serviceimpl.AuthorServiceImpl;
import com.apps.bookfarm.exception.AuthorNotFoundException;
import com.apps.bookfarm.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorServiceImpl authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    //Aggregate root
    @GetMapping("/authors")
    Iterable<Author> allAuthors (){
        return authorService.getAuthors();
    }
    //end::get-aggregate-root[]

    @GetMapping("/authors/{id}")
    Author oneAuthor (@PathVariable Long id){
       return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }

    @GetMapping("/authors/contacts/{phone}")
    List<Author> authorPhone (@PathVariable int phone){
        return authorRepository.findByPhoneNumber(phone);
    }

    @PostMapping("/authors")
    public void addNewAuthor(@RequestBody Author newAuthor){
        authorService.addNewAuthor(newAuthor);
    }

    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }

    @PutMapping("authors/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id){
        return authorRepository.findById(id).map(author -> {
            author.setAuthorName(newAuthor.getAuthorName());
            author.setPhoneNumber(newAuthor.getPhoneNumber());
            return authorRepository.save(newAuthor);
        }).orElseGet(()->{newAuthor.setAuthorId(id);
        return authorRepository.save(newAuthor);
        });
    }
}
