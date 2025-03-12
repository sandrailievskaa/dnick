package finki.ukim.mk.libraryapp.events;

import finki.ukim.mk.libraryapp.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookEditedEvent extends ApplicationEvent {
    public BookEditedEvent(Book source) {
        super(source);
    }
}
