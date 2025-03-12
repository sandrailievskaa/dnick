package finki.ukim.mk.libraryapp.service;

import finki.ukim.mk.libraryapp.model.Author;
import finki.ukim.mk.libraryapp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    List<Author> listAll();
    Author findById(Long id);
    void deleteById(Long id);
    Author create(String name, String surname, Long countryId);
    Author update(Long id, String name, String surname, Long countryId);

}
