package org.trahim.library.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Publisher.class)
public abstract class Publisher_ {

	public static volatile ListAttribute<Publisher, Book> books;
	public static volatile SingularAttribute<Publisher, String> name;
	public static volatile SingularAttribute<Publisher, Long> id;

	public static final String BOOKS = "books";
	public static final String NAME = "name";
	public static final String ID = "id";

}

