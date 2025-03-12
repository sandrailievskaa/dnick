package finki.ukim.mk.libraryapp.web;

import finki.ukim.mk.libraryapp.model.Book;
import finki.ukim.mk.libraryapp.model.dto.BookDTO;
import finki.ukim.mk.libraryapp.service.AuthorService;
import finki.ukim.mk.libraryapp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;
    private final AuthorService authorService;

    public BookController(BookService service, AuthorService authorService) {
        this.service = service;
        this.authorService = authorService;
    }

    @PostMapping("/add-book")
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        if(bookDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(authorService.findById(bookDTO.getAuthorId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.create(bookDTO.getName(), bookDTO.getCategory(), bookDTO.getAuthorId(), bookDTO.getAvailableCopies());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete-book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit-book/{id}")
    public ResponseEntity<Void> editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        if(bookDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(authorService.findById(bookDTO.getAuthorId()) == null || service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.update(id, bookDTO.getName(), bookDTO.getCategory(), bookDTO.getAuthorId(), bookDTO.getAvailableCopies());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark-book/{id}")
    public ResponseEntity<Void> markBook(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.mark(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Book> getBooks(@RequestParam(required = false) String name) {

        if(name == null) {
            return this.service.listAll();
        }

        return this.service.listBooks(name);
    }

    @GetMapping("/get-book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        Book book = service.findById(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book);
    }
}
