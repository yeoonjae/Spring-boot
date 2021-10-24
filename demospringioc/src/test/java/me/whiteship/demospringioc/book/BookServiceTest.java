package me.whiteship.demospringioc.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Mock // Mock을 통해 가짜 객체 생성
    BookRepository bookRepository;


    @Test
    public void save() {
        Book book = new Book();

        when(bookRepository.save(book)).thenReturn(book);
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);

        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookSataus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();

        // BookRepository bookRepository = new BookRepository();
    }
}
