package finki.ukim.mk.libraryapp.service.impl;

import finki.ukim.mk.libraryapp.model.Country;
import finki.ukim.mk.libraryapp.model.exceptions.CountryNotFoundException;
import finki.ukim.mk.libraryapp.repository.CountryRepository;
import finki.ukim.mk.libraryapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var country = this.findById(id);
        this.countryRepository.delete(country);
    }

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        var country = this.findById(id);
        country.setName(name);
        country.setContinent(continent);

        return this.countryRepository.save(country);
    }
}
