package com.opencodez.microservice.springclientemployeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @Autowired
    StudentRepository studentRepository;
    //Create
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    
    
    
    @RequestMapping(value="/students", method = RequestMethod.GET)
    public List<Student> getAllStudents()
    {
        return (List<Student>)studentRepository.findAll();
    }
    
    //Update
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    
    
    @RequestMapping(value="/studentss", method = RequestMethod.GET)
    public String getA()
    {
        return "Hllonsic";
    }
}
