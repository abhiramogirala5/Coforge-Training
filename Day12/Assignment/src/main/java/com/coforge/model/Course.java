package com.coforge.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_course")
public class Course {

    @Id
    @Column(name = "course_id")
    private int course_id;

    @Column(name = "course_name")
    private String course_name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students;

    public Course() {
    }

    public Course(int course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course [course_id=" + course_id +
                ", course_name=" + course_name + "]";
    }
}