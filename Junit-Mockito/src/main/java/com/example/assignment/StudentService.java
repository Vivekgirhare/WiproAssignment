package com.example.assignment;

public class StudentService {
    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public String getStudentById(int id) {
        Student student = studentRepository.findById(id);
        return student != null ? student.getName() : null;
    }
}