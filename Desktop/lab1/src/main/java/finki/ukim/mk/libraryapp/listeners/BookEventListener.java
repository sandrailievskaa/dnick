package finki.ukim.mk.libraryapp.listeners;

import finki.ukim.mk.libraryapp.events.BookCreatedEvent;
import finki.ukim.mk.libraryapp.events.BookDeletedEvent;
import finki.ukim.mk.libraryapp.events.BookEditedEvent;
import finki.ukim.mk.libraryapp.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventListener {

    private final BookService bookService;

    public BookEventListener(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreated(BookCreatedEvent event) {
        this.bookService.onBookCreated();
    }

    @EventListener
    public void onBookDeleted(BookDeletedEvent event) {
        this.bookService.onBookDeleted();
    }

    @EventListener
    public void onBookEdited(BookEditedEvent event) {
        this.bookService.onBookEdited();
    }
}
