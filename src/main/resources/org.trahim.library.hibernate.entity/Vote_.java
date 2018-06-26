package org.trahim.library.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vote.class)
public abstract class Vote_ {

	public static volatile SingularAttribute<Vote, Long> id;
	public static volatile SingularAttribute<Vote, Integer> value;
	public static volatile SingularAttribute<Vote, String> username;

	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String USERNAME = "username";

}

