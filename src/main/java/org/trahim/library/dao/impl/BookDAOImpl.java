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

import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

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

        Root<Book> root = cq.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)

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
    @Transactional
    public List<Book> getBooks(Author author) {

        Session session = sessionFactory.openSession();

        books = author.getBooks();
        session.close();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBooks(String bookName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        Selection[] selection = {
                root.get(Book_.ID), root.get(Book_.NAME),
                root.get(Book_.PAGE_COUNT), root.get(Book_.ISBN), root.get(Book_.PUBLISH_YEAR),
                root.get(Book_.IMAGE), root.get(Book_.DESCR), root.get(Book_.RATING),
                root.get(Book_.VOTE_COUNT), root.get(Book_.AUTHOR), root.get(Book_.GENRE), root.get(Book_.PUBLISHER)
        }; // выборка полей

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");//создали параметр

        cq.select(cb.construct(Book.class, selection)) /// select отдельные поля from
                .where(cb.like(root.get(Book_.NAME), nameParam));// к полю Book_.NAME таблицы book применяем like параметр nameParam

        Query query = session.createQuery(cq);

        query.setParameter("name", "%" + bookName + "%"); // задаем пераметр nameParam

        books = query.getResultList();

        session.close();

        return books;



    }

    @Override
    @Transactional
    public List<Book> getBooks(Genre genre) {

        Session session = sessionFactory.openSession();
        books = genre.getBooks();
        session.close();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBooks(Character letter) {



        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        Selection[] selection = {
                root.get(Book_.ID), root.get(Book_.NAME),
                root.get(Book_.PAGE_COUNT), root.get(Book_.ISBN), root.get(Book_.PUBLISH_YEAR),
                root.get(Book_.IMAGE), root.get(Book_.DESCR), root.get(Book_.RATING),
                root.get(Book_.VOTE_COUNT), root.get(Book_.AUTHOR), root.get(Book_.GENRE), root.get(Book_.PUBLISHER)
        }; // выборка полей

        ParameterExpression<String> nameParam = cb.parameter(String.class, "character");//создали параметр

        cq.select(cb.construct(Book.class, selection)) /// select отдельные поля from
                .where(cb.like(root.get(Book_.NAME), nameParam));// к полю Book_.NAME таблицы book применяем like параметр nameParam

        Query query = session.createQuery(cq);

        query.setParameter("character", letter.toString() + "%"); // задаем пераметр nameParam

        books = query.getResultList();

        session.close();

        return books;
    }

    @Override
    public Object getFieldValue(Long id, String fieldName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        Selection[] selection = {root.get(fieldName)}; // выборка полей
        ParameterExpression<Long> nameParam = cb.parameter(Long.class, "id");//создали параметр
        cq.select(cb.construct(Book.class, selection)) /// select отдельные поля from
                .where(cb.equal(root.get(Book_.ID), nameParam));// к полю fieldName таблицы book применяем equal параметр nameParam

        Query query = session.createQuery(cq);
        query.setParameter("id", id); // задаем пераметр nameParam

        Book book =  (Book) query.getSingleResult();

        session.close();

        return book.getContent();
    }
}
