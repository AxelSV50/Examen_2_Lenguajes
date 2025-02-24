package com.sandbox.controller;

import com.sandbox.model.DTO.StudentDTO;
import com.sandbox.model.Nationality;
import com.sandbox.model.Student;
import com.sandbox.repository.NationalityRepository;
import com.sandbox.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/student")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private NationalityRepository nationalityRepository;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        try {
            Student student = service.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<?> insertStudent(@RequestBody StudentDTO studentDTO) {
        service.insertStudentSP(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody StudentDTO student){
        service.updateStudentSP(student);
    }

    @DeleteMapping("/deleteSP/{id}")
    public void deleteSP(@PathVariable Integer id) {
        service.deleteStudentSP(id);
    }
}
