package com.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demoproject.entity.Student;
import com.demoproject.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

//		Create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
//		System.out.println(student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		System.out.println(model);
		System.out.println(id);
		model.addAttribute("student", studentService.getStudentById(id));
		System.out.println(model);
		System.out.println("==========" + id);
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

//		Get Student from database by id

		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

//		Save updated student

		studentService.updateStudent(existingStudent);

		return "redirect:/students";
	}

//	Delete student handler

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
