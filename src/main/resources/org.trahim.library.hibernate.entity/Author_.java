package org.trahim.library.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SingularAttribute<Author, Date> birthday;
	public static volatile ListAttribute<Author, Book> books;
	public static volatile SingularAttribute<Author, Long> id;
	public static volatile SingularAttribute<Author, String> fio;

	public static final String BIRTHDAY = "birthday";
	public static final String BOOKS = "books";
	public static final String ID = "id";
	public static final String FIO = "fio";

}

