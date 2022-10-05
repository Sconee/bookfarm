package com.apps.bookfarm.serviceimpl;

import com.apps.bookfarm.model.Author;
import com.apps.bookfarm.repository.AuthorRepository;
import com.apps.bookfarm.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void addNewAuthor(Author author) {
        List<Author> optionalAuthor = authorRepository.findByPhoneNumber(author.getPhoneNumber());
        if(!optionalAuthor.isEmpty()){
            throw new IllegalStateException("Author already exists");
        }else {
            authorRepository.save(author);
        }
    }

    @Override
    public void removeAuthor(Long id) {

    }
}
