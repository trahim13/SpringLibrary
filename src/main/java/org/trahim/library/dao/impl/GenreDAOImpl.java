package org.trahim.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.trahim.library.dao.interfaces.GenreDAO;
import org.trahim.library.hibernate.entity.Genre;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Genre> genres;

    @Override
    @Transactional
    public List<Genre> getGenres() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Genre.class);
        Root<Genre> root = cq.from(Genre.class);

        cq.select(root);

        Query query = session.createQuery(cq);
        genres  = query.getResultList();
        session.close();

        return genres;
    }
}
