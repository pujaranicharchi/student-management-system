package com.pujarani.studentmanagement.service;


import com.pujarani.studentmanagement.entity.Student;
import com.pujarani.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class StudentService {

        @Autowired
        private StudentRepository repository;

        public List<Student> getAllStudents() {
            return repository.findAll();
        }

        public Student saveStudent(Student student) {
            return repository.save(student);
        }
    }

