package com.Deva.Library.Mgmt.repository;

import com.Deva.Library.Mgmt.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepo extends MongoRepository<Library,String> {
}
