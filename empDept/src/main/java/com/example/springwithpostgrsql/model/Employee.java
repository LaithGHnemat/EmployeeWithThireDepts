package com.example.springwithpostgrsql.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false)
    private long id;
    @Column(name = "empFirstName")
    private  String fname;
    @Column(name = "empLastName")
    private String lname;
    @Column(name = "email")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Employee() {
    }

    public Employee(String fname, String lname, String email, Department department) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.department= department;
    }

    public Employee(long id, String fname, String lname, String email, Department department) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartments() {
        return department;
    }

    public void setDepartments(Department department) {
        this.department = department;
    }
}
