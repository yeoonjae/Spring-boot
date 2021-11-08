package me.whiteship.demospringioc.book;


import java.util.Date;

public class Book {

    private Date created;

    private BookStatus bookSataus;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BookStatus getBookSataus() {
        return bookSataus;

    }

    public void setBookStatus(BookStatus bookSataus) {
        this.bookSataus = bookSataus;
    }
}
