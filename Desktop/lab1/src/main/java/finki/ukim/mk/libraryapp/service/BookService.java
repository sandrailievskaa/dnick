package finki.ukim.mk.libraryapp.service;

import finki.ukim.mk.libraryapp.model.Author;
import finki.ukim.mk.libraryapp.model.Book;
import finki.ukim.mk.libraryapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    List<Book> listAll();
    List<Book> listBooks(String name);
    Book findById(Long id);
    void deleteById(Long id);
    Book create(String name, Category category, Long authorId, Integer availableCopies);
    Book update(Long id, String name, Category category, Long authorId, Integer availableCopies);
    void mark(Long id);
    void onBookCreated();
    void onBookEdited();
    void onBookDeleted();

}
