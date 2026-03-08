package com.xp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeUsername;
    private String employeeName;
    private String employeePassword;

    public Employee() {}

    public Employee(String username, String name, String password) {
        this.employeeUsername = username;
        this.employeeName = name;
        this.employeePassword = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long adminId) {
        this.employeeId = adminId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String adminName) {
        this.employeeName = adminName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String adminPassword) {
        this.employeePassword = adminPassword;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String adminUsername) {
        this.employeeUsername = adminUsername;
    }
}