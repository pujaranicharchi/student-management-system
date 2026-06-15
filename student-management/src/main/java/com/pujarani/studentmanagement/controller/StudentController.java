package com.pujarani.studentmanagement.controller;

import com.pujarani.studentmanagement.entity.Student;
import com.pujarani.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {

        Student existingStudent =
                repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            return repository.save(existingStudent);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }

}