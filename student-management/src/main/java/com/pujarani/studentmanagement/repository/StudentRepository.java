package com.pujarani.studentmanagement.repository;

import com.pujarani.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}