package com.sandbox.controller;

import com.sandbox.model.Major;
import com.sandbox.service.MajorService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/major")
public class MajorController {
    @Autowired
    private MajorService service;

    @GetMapping("/getAllMajors")
    public ResponseEntity<List<Major>> getAllMajors() {
        try {
            return new ResponseEntity<>(service.getAllMajors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMajorById/{id}")
    public ResponseEntity<Major> getMajorById(@PathVariable Integer id) {
        try {
            Major major = service.getMajorById(id);
            return new ResponseEntity<>(major, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveMajor")
    public ResponseEntity<?> saveMajor(@RequestBody Major major) {
        try {
            service.insertMajor(major);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateMajor")
    public ResponseEntity<?> updateMajor(@RequestBody Major major) {
        try {
            service.updateMajor(major);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMajorById/{id}")
    public ResponseEntity<?> deleteMajorById(@PathVariable Integer id) {
        try {
            service.deleteMajorById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
