package com.sandbox.repository;

import com.sandbox.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "GetAllStudentsSP", nativeQuery = true)
    List<Student> getAllStudents();

    @Query(value = "{ call SelectStudentById(:Id)}", nativeQuery = true)
    Student getStudentById(@Param("Id") Integer id);

    @Procedure(name = "InsertStudentSP")
    void insertStudentSP(@Param("Name") String name,
                         @Param("Email") String email,
                         @Param("Password") String password,
                         @Param("Nationality_Id") int nationalityId);

    @Procedure(name = "Student.UpdateStudentSP")
    void updateStudentSP(@Param("Id") Integer studentId,
                         @Param("Name") String name,
                         @Param("Email") String email,
                         @Param("Password") String password,
                         @Param("Nationality_Id") int nationalityId);


    @Procedure(name = "Student.DeleteStudentById")
    void deleteStudentSP(@Param("Id") Integer id);
}
