package org.trahim.library.dao.interfaces;

import org.trahim.library.hibernate.entity.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();
}
