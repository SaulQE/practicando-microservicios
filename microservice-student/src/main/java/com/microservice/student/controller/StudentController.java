package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController
{
    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student)
    {
        studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent()
    {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{studentId}")
    public ResponseEntity<?> findById(@PathVariable Long studentId)
    {
        return ResponseEntity.ok(studentService.findById(studentId));
    }

    @GetMapping("/search-by-course/{courseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(studentService.findByCourseId(courseId));
    }

}
