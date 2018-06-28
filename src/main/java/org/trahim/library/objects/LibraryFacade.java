package org.trahim.library.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trahim.library.dao.interfaces.BookDAO;
import org.trahim.library.hibernate.entity.Book;

import java.util.List;

@Component
public class LibraryFacade {

    private BookDAO bookDAO;
    private List<Book> books;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    public List<Book> getBooks() {
        return books;
    }
}