package com.Deva.Library.Mgmt.repository;

import com.Deva.Library.Mgmt.model.Library;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface LibrarySearch {
    public List<Library> getBySearch(String text);

    List<Library> getByAuthor(String author);

    List<Library> getByBookName(String author);

    List<Library> getByType(String type);

    List<Library> getLimitedBooks();

    Library getBook(String title, String author);
}
