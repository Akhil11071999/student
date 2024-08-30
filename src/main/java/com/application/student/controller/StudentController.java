package com.application.student.controller;

import com.application.student.models.Student;
import com.application.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;

    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;

    }
    @PostMapping("/student/add")
    @ResponseStatus (code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);

    }
    @PutMapping("/student/update/{id}")

    public Student updateStudent (@PathVariable int id, @RequestParam String name){
        Student student = repo.findById(id).get();
         student.setName(name);
        repo.save(student);
        return student;
    }

    @DeleteMapping("/student/delete/{id}")
    
    public void deleteStudent(@PathVariable int id){
        Student student =repo.findById(id).get();
        repo.delete(student);
// it is used
    }

}
