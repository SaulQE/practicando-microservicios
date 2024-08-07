package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController
{
    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course)
    {
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse()
    {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{studentId}")
    public ResponseEntity<?> findById(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(courseService.findById(courseId));
    }

    @GetMapping("/search-student/{courseId}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long courseId)
    {
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
    }

}
