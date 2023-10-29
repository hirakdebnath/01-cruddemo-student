package com.facebook.cruddemo.dao;
import java.util.*;
import com.facebook.cruddemo.entity.Student;
public interface StudentDAO {
    //creating save interface
    void save(Student theStudent);

    //creating find interface
    Student findByID(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);
    void delete(Integer id);

}
