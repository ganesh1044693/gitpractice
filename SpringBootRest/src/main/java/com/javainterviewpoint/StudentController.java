package com.javainterviewpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController



public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentRepository studentRepository;

	// Create
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	// Read
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable long id) {
		return studentRepository.findOne(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		System.out.println("confliting");
        System.out.println("confliting");
        System.out.println("confliting");
        System.out.println("confliting");	
		List<Student> list = null;
		LOGGER.debug("entee into StudentController-getAllStudents() method ");
		list = (List<Student>) studentRepository.findAll();
		LOGGER.debug("list of students from the api "+list.toString());
		LOGGER.debug("exit from into StudentController-getAllStudents() method ");
		return list;
	}


}
