package com.Deva.Library.Mgmt.controller;

import com.Deva.Library.Mgmt.model.Library;
import com.Deva.Library.Mgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Fetch")
public class LibraryGetController {


    @Autowired
    LibraryService service;

    @GetMapping("/AllBooks")
    public ResponseEntity<List<Library>> getAllBooks(){
        return new ResponseEntity<List<Library>>(service.getAllBooks(), HttpStatus.FOUND);
    }

    @GetMapping("/Search/{text}")
    public ResponseEntity<List<Library>> getBySearch(@PathVariable String text){
        return  new ResponseEntity<List<Library>>(service.getBySearch(text),HttpStatus.FOUND);
    }

    @GetMapping("/Search/author/{author}")
    public ResponseEntity<List<Library>> getByAuthor(@PathVariable String author){
        return  new ResponseEntity<List<Library>>(service.getByAuthor(author),HttpStatus.FOUND);
    }

    @GetMapping("/Search/type/{type}")
    public ResponseEntity<List<Library>> getByType(@PathVariable String type){
        return  new ResponseEntity<List<Library>>(service.getByType(type),HttpStatus.FOUND);
    }

    @GetMapping("/Search/name/{name}")
    public ResponseEntity<List<Library>> getByName(@PathVariable String name){
        return  new ResponseEntity<List<Library>>(service.getByName(name),HttpStatus.FOUND);
    }

    @GetMapping("/Fetch/cateory")
    public ResponseEntity<Set<String>> getAllCategories(){
        return new ResponseEntity<Set<String>>(service.getCategories(),HttpStatus.FOUND);
    }
}
