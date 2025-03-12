package finki.ukim.mk.libraryapp.service.impl;

import finki.ukim.mk.libraryapp.model.Author;
import finki.ukim.mk.libraryapp.model.Country;
import finki.ukim.mk.libraryapp.model.exceptions.AuthorNotFoundException;
import finki.ukim.mk.libraryapp.repository.AuthorRepository;
import finki.ukim.mk.libraryapp.repository.CountryRepository;
import finki.ukim.mk.libraryapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var author = this.findById(id);
        this.authorRepository.delete(author);
    }

    @Override
    public Author create(String name, String surname, Long countryId) {
        var country = this.countryRepository.findById(countryId).get();
        return this.authorRepository.save(new Author(name, surname, country));
    }

    @Override
    public Author update(Long id, String name, String surname, Long countryId) {
        var author = this.findById(id);
        var country = this.countryRepository.findById(countryId).get();
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return this.authorRepository.save(author);
    }
}
