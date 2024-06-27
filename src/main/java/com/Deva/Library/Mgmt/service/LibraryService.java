package com.Deva.Library.Mgmt.service;

import com.Deva.Library.Mgmt.model.Library;
import com.Deva.Library.Mgmt.repository.LibraryRepo;
import com.Deva.Library.Mgmt.repository.LibrarySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryRepo repo;

    @Autowired
    LibrarySearch srepo;


    //Get Requests
    public List<Library> getAllBooks() {
        return repo.findAll();
    }

    public List<Library> getBySearch(String text) {
        return srepo.getBySearch(text);
    }

    public List<Library> getByAuthor(String author) {
        return srepo.getByAuthor(author);
    }

    public List<Library> getByName(String name) {
        return srepo.getByBookName(name);
    }

    public List<Library> getByType(String type) {
        return srepo.getByType(type);
    }


    //post requests
    public Library addBook(Library library) {
        return repo.save(library);
    }



}