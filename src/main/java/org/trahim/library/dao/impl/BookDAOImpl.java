package org.trahim.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.trahim.library.dao.interfaces.BookDAO;
import org.trahim.library.hibernate.entity.Author;
import org.trahim.library.hibernate.entity.Book;
import org.trahim.library.hibernate.entity.Book_;
import org.trahim.library.hibernate.entity.Genre;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    @Transactional
    @Override
    public List<Book> getBooks() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Author> root = cq.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selection = {
                root.get(Book_.ID), root.get(Book_.NAME),
                root.get(Book_.PAGE_COUNT), root.get(Book_.ISBN), root.get(Book_.PUBLISH_YEAR),
                root.get(Book_.IMAGE), root.get(Book_.DESCR), root.get(Book_.RATING),
                root.get(Book_.VOTE_COUNT), root.get(Book_.AUTHOR), root.get(Book_.GENRE), root.get(Book_.PUBLISHER)
        }; // выборка полей



        cq.select(cb.construct(Book.class, selection));


        // этап выполнения запроса
        Query query = session.createQuery(cq);

        books = query.getResultList();

        session.close();

        return books;

    }

    @Override
    public List<Book> getBooks(Author author) {
        return null;
    }

    @Override
    public List<Book> getBooks(String bookName) {
        return null;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        return null;
    }

    @Override
    public List<Book> getBooks(Character letter) {
        return null;
    }
}
