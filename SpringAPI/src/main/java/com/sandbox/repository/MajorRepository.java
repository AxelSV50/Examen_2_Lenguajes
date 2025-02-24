package com.sandbox.repository;

import com.sandbox.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MajorRepository extends JpaRepository<Major, Integer> {

    @Modifying
    @Transactional
    @Query(value = "EXEC DeleteMajorById @Id = ?1", nativeQuery = true)
    void deleteMajorById(Integer id);
}
