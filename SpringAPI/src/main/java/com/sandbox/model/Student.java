package com.sandbox.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
@NamedStoredProcedureQuery(name = "Student.getAllStudents", procedureName = "SelectStudent")
@NamedStoredProcedureQuery(name = "Student.getStudentById",procedureName =
        "SelectStudentById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class)})
@NamedStoredProcedureQuery(name = "Student.DeleteStudentById",procedureName = "DeleteStudentById",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type =
                Integer.class)})
@NamedStoredProcedureQuery(name = "Student.insertStudentSP",procedureName = "InsertStudent", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IdNationality", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class)
})
@NamedStoredProcedureQuery(name = "Student.UpdateStudentSP",procedureName = "UpdateStudentSP", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Nationality_Id", type = Integer.class)

})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "Nationality_Id", referencedColumnName = "Id", nullable = false)
    private Nationality nationality;

    // Constructor vacío obligatorio para JPA
    public Student() {
    }

    // Constructor con parámetros
    public Student(Integer id, String name, String email, String password, Nationality nationality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nationality = nationality;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}

