package org.trahim.library.dao.interfaces;

import org.trahim.library.hibernate.entity.Author;
import org.trahim.library.hibernate.entity.Book;
import org.trahim.library.hibernate.entity.Genre;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);
    Object getFieldValue(Long id, String fieldName);
}
