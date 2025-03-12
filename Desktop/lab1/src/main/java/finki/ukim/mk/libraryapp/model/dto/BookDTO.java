package finki.ukim.mk.libraryapp.model.dto;

import finki.ukim.mk.libraryapp.model.Category;
import lombok.Data;

@Data
public class BookDTO {
    String name;
    Category category;
    Long authorId;
    Integer availableCopies;
}
