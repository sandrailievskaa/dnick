package finki.ukim.mk.libraryapp.service;

import finki.ukim.mk.libraryapp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {

    List<Country> listAll();
    Country findById(Long id);
    void deleteById(Long id);
    Country create(String name, String continent);
    Country update(Long id, String name, String continent);

}
