package com.Deva.Library.Mgmt.controller;

import com.Deva.Library.Mgmt.model.Library;
import com.Deva.Library.Mgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/Fetch")
@CrossOrigin(origins = "http://localhost:5173")
public class LibraryGetController {


    @Autowired
    LibraryService service;

    @GetMapping("/AllBooks")
    public ResponseEntity<List<Library>> getAllBooks() {
        return new ResponseEntity<List<Library>>(service.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/HomeBooks")
    public ResponseEntity<List<Library>> getLimitedBooks() {
        return new ResponseEntity<List<Library>>(service.getLimitedBooks(), HttpStatus.OK);
    }

    @GetMapping("/Search/{text}")
    public ResponseEntity<List<Library>> getBySearch(@PathVariable String text) {
        return new ResponseEntity<List<Library>>(service.getBySearch(text), HttpStatus.OK);
    }

    @GetMapping("/Search/author/{author}")
    public ResponseEntity<List<Library>> getByAuthor(@PathVariable String author) {
        return new ResponseEntity<List<Library>>(service.getByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/Search/type/{type}")
    public ResponseEntity<List<Library>> getByType(@PathVariable String type) {
        return new ResponseEntity<List<Library>>(service.getByType(type), HttpStatus.OK);
    }

    @GetMapping("/Search/name/{name}")
    public ResponseEntity<List<Library>> getByName(@PathVariable String name) {
        return new ResponseEntity<List<Library>>(service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/AllCategories")
    public ResponseEntity<Map<String, String>> getAllCategories() {
        return new ResponseEntity<Map<String, String>>(service.getCategoryiesData(), HttpStatus.OK);
    }

    @GetMapping("/AllAuthors")
    public ResponseEntity<Map<String, String>> getAllAuthors() {
        return new ResponseEntity<Map<String, String>>(service.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/GetBook")
    public ResponseEntity<Library> getBook(@RequestParam String title,@RequestParam String author){
        return new ResponseEntity<Library>(service.getBook(title,author),HttpStatus.OK);
    }

}
