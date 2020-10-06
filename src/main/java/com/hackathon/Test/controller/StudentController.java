package com.hackathon.Test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.Test.model.Student;
import com.hackathon.Test.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	//to register a student
	@PostMapping(path="/register-student")
	public void registerStudent(@RequestBody Student student) {
		studService.registerStudent(student);
	}
	
	//login check
	@GetMapping(path="/{email_id}/{password}")
	public boolean checkForUser(@PathVariable String email_id, @PathVariable String password) {
		int count = studService.checkForUser(email_id,password);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}
	
	//To get all students score along with their details
	@GetMapping(path="/get_all_student_scores")
	public List<Student> findStudentsScores(){
		return studService.findStudentsScores();
	}
	
	//update student's score
	@PutMapping(path="/{email_id}/{score}")
	public void updateStudentScore(@PathVariable String email_id, @PathVariable Long score, @RequestBody Student student) {
		studService.updateStudentScore(email_id,score);
	}
	
	//get student's score
	@GetMapping(path="/{email_id}/get_score")
	public long getStudentScore(@PathVariable String email_id) {
		return studService.getStudentScore(email_id);
	}

}
