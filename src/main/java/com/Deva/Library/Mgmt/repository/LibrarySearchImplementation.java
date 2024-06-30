package com.Deva.Library.Mgmt.repository;

import com.Deva.Library.Mgmt.model.Library;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class LibrarySearchImplementation implements LibrarySearch {

    @Autowired
    private MongoClient client;

    @Autowired
    private MongoConverter converter;


    @Override
    public List<Library> getBySearch(String text) {

        List<Library> libraries = new ArrayList<>();

        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "LibraryIndex")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("title", "type", "description", "author"))))));

        result.forEach((doc) -> libraries.add(converter.read(Library.class, doc)));

        return libraries;
    }

    @Override
    public List<Library> getByAuthor(String author) {

        List<Library> libraries = new ArrayList<>();

        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "LibraryIndex")
                        .append("text",
                                new Document("query", author)
                                        .append("path", "author")))));

        result.forEach((doc) -> libraries.add(converter.read(Library.class, doc)));


        return libraries;
    }

    @Override
    public List<Library> getByBookName(String name) {

        List<Library> libraries = new ArrayList<>();

        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "LibraryIndex")
                        .append("text",
                                new Document("query", name)
                                        .append("path", "title")))));

        result.forEach((doc) -> libraries.add(converter.read(Library.class, doc)));


        return libraries;
    }

    @Override
    public List<Library> getByType(String type) {

        List<Library> libraries = new ArrayList<>();

        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "LibraryIndex")
                        .append("text",
                                new Document("query", type)
                                        .append("path", "type")))));

        result.forEach((doc) -> libraries.add(converter.read(Library.class, doc)));


        return libraries;
    }

    @Override
    public List<Library> getLimitedBooks() {
        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$limit", 12L)));

        List<Library> list = new ArrayList<>();
        result.forEach((doc) -> list.add(converter.read(Library.class, doc)));
        return list;
    }

    @Override
    public Library getBook(String title, String author) {

        MongoDatabase database = client.getDatabase("DevaGonde");
        MongoCollection<Document> collection = database.getCollection("Library");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
                new Document("title", title)
                        .append("author", author)
        )));

        List<Library> library =new ArrayList<>();
        result.forEach((doc)->{
            library.add(converter.read(Library.class,doc));
        });
        return library.get(0);
    }

}
