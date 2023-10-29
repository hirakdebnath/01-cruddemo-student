package com.facebook.cruddemo;

import com.facebook.cruddemo.dao.StudentDAO;
import com.facebook.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForFindingLastName(studentDAO);
//			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("deleting student with id:"+studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		//give student id
		int studentId=1;

		//object injection
		Student myStudent=studentDAO.findByID(studentId);

		//setting first name of student with id 1
		myStudent.setFirstName("Scooby");

		//updating the  new updated first name in database

		studentDAO.update(myStudent);

		//printing the updated student
		System.out.println(myStudent);
	}

	private void queryForFindingLastName(StudentDAO studentDAO) {
		List<Student> jonesStudents=studentDAO.findByLastName("jones");
		for(Student thestudent:jonesStudents){
			System.out.println("Students having last Name as Jones:"+thestudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();
		for( Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating student..");
		Student tempStudent=new Student("Halley","jones","hallie@yahoo.com");

		//save the student
		studentDAO.save(tempStudent);
		System.out.println("Student saved, Generating the id...");

		//display id of student
		int stuId=tempStudent.getId();
		System.out.println("the id is:"+stuId);

		//display student
		Student mystudent=studentDAO.findByID(stuId);
		System.out.println("Found student at:"+mystudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//creating student
		System.out.println("Creating 3 new Students..");
		Student tempstu=new Student("Julie","Sweet","juliesweet@gmail.com");
		Student tempstu2=new Student("Adam","Star","adam@gmail.com");
		Student tempstu3=new Student("Harley","right","harley@gmail.com");

		//saving the student
		System.out.println("Saving the student");
		studentDAO.save(tempstu);
		studentDAO.save(tempstu2);
		studentDAO.save(tempstu3);

		//Getting student id and saving it in stuid var

		int theId= tempstu.getId();

		//displaying the id
		System.out.println("Student saved"+theId);

		//getting the details of the student using id
		Student myStudent=studentDAO.findByID(theId);

		//printing the student details
		System.out.println(myStudent);

	}


//	private void createStudent(StudentDAO studentDAO) {
//		//create a new student details
//		System.out.println("Creating new Student..");
//		Student tempstudent= new Student("hirak","debnath","hirakdebnath@gmail.com");
//		//save the student details in the date base
//		System.out.println("Student is saved");
//        studentDAO.save(tempstudent);
//
//
//
//
//
//	}
}
