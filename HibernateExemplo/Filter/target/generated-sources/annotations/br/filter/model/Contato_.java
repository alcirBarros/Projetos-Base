package br.filter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contato.class)
public abstract class Contato_ {

	public static volatile SingularAttribute<Contato, Boolean> ativo;
	public static volatile SingularAttribute<Contato, Pessoa> pessoa;
	public static volatile SingularAttribute<Contato, Integer> id;
	public static volatile SingularAttribute<Contato, String> info;

}

