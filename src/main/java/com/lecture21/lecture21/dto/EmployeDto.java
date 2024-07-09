package com.lecture21.lecture21.dto;

public class EmployeDto {
    Integer id;
    String rollno;
    String name;
    String collegeName;
    String location;

    public EmployeDto() {
    }

    public EmployeDto(Integer id, String rollno, String name, String collegeName, String location) {
        this.id = id;
        this.rollno = rollno;
        this.name = name;
        this.collegeName = collegeName;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
