package me.whiteship.dempspring51;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepositories;

    public void printBookRepository(){
        this.bookRepositories.forEach(s -> System.out.println(s.getClass()));
    }
}
