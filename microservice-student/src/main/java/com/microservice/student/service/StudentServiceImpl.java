package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findByCourseId(Long courseId) {
        return studentRepository.findAllStudent(courseId);
    }
}
