package me.whiteship.demospringioc.book;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookService -> BookRepository
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookSRepository;

    public BookService(BookRepository bookSRepository) {
        this.bookSRepository = bookSRepository;
    }

    public Book save(Book book) {
        book.setCreated(new Date());
//        book.setBookStatus(BookStatus.DRAFT);
        return bookSRepository.save(book);
    }

}
