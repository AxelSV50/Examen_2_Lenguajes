package com.sandbox.service;

import com.sandbox.model.Major;
import com.sandbox.repository.MajorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class MajorService {
    @Autowired
    private MajorRepository repository;

    public List<Major> getAllMajors() throws SQLException {
        return repository.findAll();
    }

    public Major getMajorById(int id) throws SQLException {
        Optional<Major> optionalMajor = repository.findById(id);
        return optionalMajor.orElseThrow(() -> new RuntimeException("Major not found for id :: " + id));
    }

    public void insertMajor(Major major) throws SQLException {
        repository.save(major);
    }

    public void updateMajor(Major major) throws SQLException{
        if (!repository.existsById(major.getId())) {
            throw new EntityNotFoundException("Major with ID " + major.getId() + " not found");
        }
        repository.save(major);
    }

    public void deleteMajorById(Integer id) throws SQLException{
        repository.deleteById(id);
    }
}
