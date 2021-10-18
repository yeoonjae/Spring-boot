package me.whiteship.demospringioc.book;

import org.junit.jupiter.api.Test;

public class BookServiceTest {

    @Test
    public void save() {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);

    }
}
