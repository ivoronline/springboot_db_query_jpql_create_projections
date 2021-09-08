package com.ivoronline.springboot_db_query_jpql_create_projections.services;

import com.ivoronline.springboot_db_query_jpql_create_projections.entities.Person;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class DBAccess {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RETURN ENTITY
  //================================================================
  public Person returnEntity() {

    //CREATE QUERY
    String select = "SELECT person FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select, Person.class);
           query.setParameter("name", "John");

    //SELECT PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;

  }

  //================================================================
  // RETURN SCALAR
  //================================================================
  public Integer returnScalar() {

    //CREATE QUERY
    String select = "SELECT person.age FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select);
           query.setParameter("name", "John");

    //SELECT PERSON
    Integer age = (Integer) query.getSingleResult();

    //RETURN PERSON
    return age;

  }

  //================================================================
  // RETURN OBJECT ARRAY
  //================================================================
  public Object[] returnObjectArray() {

    //CREATE QUERY
    String select = "SELECT person.name, person.age FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select);
           query.setParameter("name", "John");

    //SELECT PERSON
    Object[] objectArray  = (Object[]) query.getSingleResult();

    //RETURN PERSON
    return objectArray;

  }

}
