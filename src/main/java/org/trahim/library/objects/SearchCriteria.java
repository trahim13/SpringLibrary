package org.trahim.library.objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.trahim.library.enums.SearchType;
import org.trahim.library.hibernate.entity.Genre;

import java.io.Serializable;

@Component
@Scope("singleton")
public class SearchCriteria implements Serializable {

    private String text;
    private Character letter;
    private SearchType searchType;
    private Genre genre;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
