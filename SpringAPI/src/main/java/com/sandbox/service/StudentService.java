package com.sandbox.service;

import com.sandbox.model.DTO.StudentDTO;
import com.sandbox.model.Student;
import com.sandbox.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }
    //From the stored procedure
    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }
    //From the stored procedure
    public void insertStudentSP(StudentDTO studentDTO) {
        if (studentDTO.getNationalityId() == null) {
            throw new IllegalArgumentException("Nationality ID cannot be null");
        }

        repository.insertStudentSP(
                studentDTO.getName(),
                studentDTO.getEmail(),
                studentDTO.getPassword(),
                studentDTO.getNationalityId()
        );
    }
    //From the stored procedure
    public void updateStudentSP(StudentDTO student) {
        repository.updateStudentSP(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPassword(),
                student.getNationalityId()
        );
    }
    //From the stored procedure
    public void deleteStudentSP(Integer id) {
        repository.deleteStudentSP(id);
    }
}
