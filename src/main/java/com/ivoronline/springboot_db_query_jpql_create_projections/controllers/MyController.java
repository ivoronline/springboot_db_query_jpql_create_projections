package com.ivoronline.springboot_db_query_jpql_create_projections.controllers;

import com.ivoronline.springboot_db_query_jpql_create_projections.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  //PROPERTIES
  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RETURN ENTITY
  //================================================================
  @RequestMapping("ReturnEntity")
  Person returnEntity() {

    //CREATE QUERY
    String select = "SELECT person FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select, Person.class);
           query.setParameter("name", "John");

    //SELECT ENTITY
    Person person = (Person) query.getSingleResult();

    //RETURN ENTITY
    return person;

  }

  //================================================================
  // RETURN OBJECT ARRAY
  //================================================================
  @RequestMapping("ReturnObjectArray")
  Object[] returnObjectArray() {

    //CREATE QUERY
    String select = "SELECT person.name, person.age FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select);
           query.setParameter("name", "John");

    //SELECT OBJECT ARRAY
    Object[] objectArray  = (Object[]) query.getSingleResult();

    //RETURN OBJECT ARRAY
    return objectArray;

  }

  //================================================================
  // RETURN SCALAR
  //================================================================
  @RequestMapping("ReturnScalar")
  Integer returnScalar() {

    //CREATE QUERY
    String select = "SELECT person.age FROM Person person WHERE person.name = :name";
    Query  query  = entityManager.createQuery(select);
           query.setParameter("name", "John");

    //SELECT SCALAR
    Integer age = (Integer) query.getSingleResult();

    //RETURN SCALAR
    return age;

  }


}


