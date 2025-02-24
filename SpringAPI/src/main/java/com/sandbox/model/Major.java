package com.sandbox.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Major")

public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Code", nullable = false, unique = true)
    private String code;

    public Major (){

    }
    public Major(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }



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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

