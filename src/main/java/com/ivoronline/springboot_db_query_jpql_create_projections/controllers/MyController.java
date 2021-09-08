package com.ivoronline.springboot_db_query_jpql_create_projections.controllers;

import com.ivoronline.springboot_db_query_jpql_create_projections.entities.Person;
import com.ivoronline.springboot_db_query_jpql_create_projections.services.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired DBAccess dbAccess;

  //================================================================
  // RETURN ENTITY
  //================================================================
  @RequestMapping("ReturnEntity")
  Person returnEntity() {
    Person person = dbAccess.returnEntity();
    return person;
  }

  //================================================================
  // RETURN SCALAR
  //================================================================
  @RequestMapping("ReturnScalar")
  Integer returnScalar() {
    Integer age = dbAccess.returnScalar();
    return  age;
  }
  //================================================================
  // RETURN OBJECT ARRAY
  //================================================================
  @RequestMapping("returnObjectArray")
  Object[] returnObjectArray() {
    Object[] objectArray = dbAccess.returnObjectArray();
    return   objectArray;
  }

}


