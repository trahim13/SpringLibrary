package org.trahim.library.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, byte[]> image;
	public static volatile SingularAttribute<Book, Integer> pageCount;
	public static volatile SingularAttribute<Book, Author> author;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, Integer> rating;
	public static volatile SingularAttribute<Book, byte[]> content;
	public static volatile SingularAttribute<Book, String> descr;
	public static volatile SingularAttribute<Book, Integer> publishYear;
	public static volatile SingularAttribute<Book, Genre> genre;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, Publisher> publisher;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, Long> voteCount;

	public static final String IMAGE = "image";
	public static final String PAGE_COUNT = "pageCount";
	public static final String AUTHOR = "author";
	public static final String ISBN = "isbn";
	public static final String RATING = "rating";
	public static final String CONTENT = "content";
	public static final String DESCR = "descr";
	public static final String PUBLISH_YEAR = "publishYear";
	public static final String GENRE = "genre";
	public static final String NAME = "name";
	public static final String PUBLISHER = "publisher";
	public static final String ID = "id";
	public static final String VOTE_COUNT = "voteCount";

}

