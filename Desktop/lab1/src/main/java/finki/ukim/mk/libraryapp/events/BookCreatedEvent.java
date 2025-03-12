package finki.ukim.mk.libraryapp.events;

import finki.ukim.mk.libraryapp.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookCreatedEvent extends ApplicationEvent {
    public BookCreatedEvent(Book source) {
        super(source);
    }
}
