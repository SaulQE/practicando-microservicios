package com.microservice.student.repository;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    @Query("SELECT s FROM Student s WHERE s.courseId = :courseId")
    List<Student> findAllStudent(Long courseId);
}
