package com.Deva.Library.Mgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Library")
public class Library {

    private String title;
    private String author;
    private String description;
    private String img;
    private String type;

}
