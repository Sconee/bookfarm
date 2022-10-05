package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Author;

public interface  AuthorService {
    public Iterable<Author> getAuthors();
    public void addNewAuthor(Author author);
    public void removeAuthor(Long id);
}
