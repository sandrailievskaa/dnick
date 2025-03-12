package finki.ukim.mk.libraryapp.web;

import finki.ukim.mk.libraryapp.model.Author;
import finki.ukim.mk.libraryapp.model.dto.AuthorDTO;
import finki.ukim.mk.libraryapp.service.AuthorService;
import finki.ukim.mk.libraryapp.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService service;
    private final CountryService countryService;

    public AuthorController(AuthorService service, CountryService countryService) {
        this.service = service;
        this.countryService = countryService;
    }

    @PostMapping("/add-author")
    public ResponseEntity<Void> addAuthor(@RequestBody AuthorDTO authorDTO) {
        if(authorDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(countryService.findById(authorDTO.getCountryId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.create(authorDTO.getName(), authorDTO.getSurname(), authorDTO.getCountryId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return this.service.listAll();
    }

    @PostMapping("/delete-author/{id}")
    public ResponseEntity<Void> getAuthors(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
