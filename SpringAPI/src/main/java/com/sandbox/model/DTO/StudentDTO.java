package com.sandbox.model.DTO;

public class StudentDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer nationalityId;

    // Constructor vacío
    public StudentDTO() {
    }

    // Constructor con parámetros
    public StudentDTO(Integer id, String name, String email, String password, Integer nationalityId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nationalityId = nationalityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getters y Setters
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

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
}

