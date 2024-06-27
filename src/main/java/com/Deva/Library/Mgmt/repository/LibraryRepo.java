package com.Deva.Library.Mgmt.repository;

import com.Deva.Library.Mgmt.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LibraryRepo extends MongoRepository<Library,String> {
}
