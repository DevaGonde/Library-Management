package com.Deva.Library.Mgmt.controller;

import com.Deva.Library.Mgmt.model.Library;
import com.Deva.Library.Mgmt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Modify")
public class LibraryPostController {

    @Autowired
    LibraryService service;

    @PostMapping("/AddBook")
    public Library addBook(@RequestBody Library library){
        return service.addBook(library);
    }
}
