package com.facebook.cruddemo.dao;

import com.facebook.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository  //Component scanning and translates JDBC expeptions
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement the save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);// persist is to save the student object

    }

    //implementing find method
    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    //FindAll method using JPQL
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> typedQuery=entityManager.createQuery("FROM Student",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> typedQuery=entityManager.createQuery("From Student where lastName=:theData",Student.class);

        //code to set the parameters
        typedQuery.setParameter("theData",theLastName);

        //return the querie
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //find student
        Student theStudent= entityManager.find(Student.class, id);

        //remove student
        entityManager.remove(theStudent);

    }


}
