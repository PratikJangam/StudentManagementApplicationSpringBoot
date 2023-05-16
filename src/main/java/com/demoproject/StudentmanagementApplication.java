package com.demoproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demoproject.entity.Student;
import com.demoproject.repository.StudentRepository;

@SpringBootApplication
public class StudentmanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student student1 = new Student("Ramesh", "Joshi", "ramesh@gamil.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Suresh", "Shah", "suresh@gamil.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Tony", "Stark", "tony@gamil.com");
//		studentRepository.save(student3);

	}

}
