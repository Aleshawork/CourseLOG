package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
}
