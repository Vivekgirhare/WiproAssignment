package com.example.assignment;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    
    @InjectMocks
    private StudentService studentService;
    
    @Test
    void getStudentById_shouldReturnStudentName_whenStudentExists() {
        Student dummyStudent = new Student(1, "John Doe");
        when(studentRepository.findById(1)).thenReturn(dummyStudent);
        
        String result = studentService.getStudentById(1);
       
        assertEquals("John Doe", result);
        verify(studentRepository, times(1)).findById(1);
    }
    
    @Test
    void getStudentById_shouldReturnNull_whenStudentNotFound() {
        when(studentRepository.findById(2)).thenReturn(null);
        
        String result = studentService.getStudentById(2);
        
        assertNull(result);
        verify(studentRepository, times(1)).findById(2);
    }
}