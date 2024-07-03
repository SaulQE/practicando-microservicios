package com.microservice.course.service;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService
{
    List<Course> findAll();
    Course findById(Long courseId);
    void save(Course course);
    StudentByCourseResponse findStudentsByIdCourse(Long courseId);
}
