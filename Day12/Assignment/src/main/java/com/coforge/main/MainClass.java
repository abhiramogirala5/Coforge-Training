package com.coforge.main;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class MainClass {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        // Create Course
        Course course = new Course();
        course.setCourse_id(101);
        course.setCourse_name("Java");

        // Student 1
        Student s1 = new Student();
        s1.setStudent_id(1);
        s1.setStudent_name("Sai");
        s1.setCourse(course);

        // Student 2
        Student s2 = new Student();
        s2.setStudent_id(2);
        s2.setStudent_name("Rahul");
        s2.setCourse(course);

        // Set students to course
        course.setStudents(Arrays.asList(s1, s2));

        session.save(course);

        transaction.commit();

        session.close();
        factory.close();

        System.out.println("Records Inserted Successfully...");
    }
}