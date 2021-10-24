package me.whiteship.demospringioc.book;

import java.util.Date;
import javax.annotation.PostConstruct;
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
        // book.setBookStatus(BookStatus.DRAFT);
        return bookSRepository.save(book);
    }

    /**
     * @PostConstruct
     * - 의존성 주입이 이루어진 후 초기화를 수행하는 메소드입니다.
     * - 객체의 초기화 부분
     * - 객체가 생성된 후 별도의 초기화 작업을 위해 실행하는 메소드를 선언합니다.
     * - @PostConstruct 어노테이션을 설정해놓은 init 메소드는 WAS가 띄워질 때 실행됩니다.
     * */
    @PostConstruct
    public void postConstuct(){
        System.out.println("===============");
        System.out.println("Hello");
    }
}
