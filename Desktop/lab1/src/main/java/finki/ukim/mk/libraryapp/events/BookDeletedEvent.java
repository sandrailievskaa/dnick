package finki.ukim.mk.libraryapp.events;

import finki.ukim.mk.libraryapp.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookDeletedEvent extends ApplicationEvent {
    public BookDeletedEvent(Book source) {
        super(source);
    }
}
