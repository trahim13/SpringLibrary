package org.trahim.library.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.trahim.library.dao.interfaces.BookDAO;
import org.trahim.library.hibernate.entity.Author;
import org.trahim.library.hibernate.entity.Book;



import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@Scope("singleton")

public class LibraryFacade implements Serializable {

    private static final String FIELD_CONTENT = "content";

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Book> books;


    public List<Book> getBooks() {
        if (books == null) {
            return bookDAO.getBooks();
        }
        return books;
    }

    public void searchBooksByLetter() {

        Character letter = searchCriteria.getLetter();
        books = bookDAO.getBooks(letter);

    }

    public void searchBooksByGenre() {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText() {

        switch (searchCriteria.getSearchType()){
            case TITLE:
                books = bookDAO.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDAO.getBooks(new Author(searchCriteria.getText()));
                break;
        }

    }

    public byte[] getContent(long id){
        return (byte[])bookDAO.getFieldValue(id, FIELD_CONTENT);
    }
}
