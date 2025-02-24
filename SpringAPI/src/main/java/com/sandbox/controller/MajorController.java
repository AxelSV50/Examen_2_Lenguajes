package com.sandbox.controller;

import com.sandbox.model.DTO.StudentDTO;
import com.sandbox.model.Major;
import com.sandbox.model.Nationality;
import com.sandbox.model.Student;
import com.sandbox.repository.NationalityRepository;
import com.sandbox.service.MajorService;
import com.sandbox.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/major")
public class MajorController {
    @Autowired
    private MajorService service;

    @GetMapping("/getAllMajors")
    public List<Major> getAllMajors() throws SQLException {
        return service.getAllMajors();
    }
    @GetMapping("/getMajorById/{id}")
    public ResponseEntity<Major> getMajorById(@PathVariable Integer id) throws SQLException{
        try {
            Major major = service.getMajorById(id);
            return new ResponseEntity<Major>(major, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/saveMajor")
    public ResponseEntity<?> saveMajor(@RequestBody Major major) throws SQLException {
        service.insertMajor(major);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/updateMajor")
    public void updateMajor(@RequestBody Major student) throws SQLException {
        service.updateMajor(student);
    }

    @DeleteMapping("/deleteMajorById/{id}")
    public void deleteMajorById(@PathVariable Integer id) throws SQLException {

        service.deleteMajorById(id);
    }
}
