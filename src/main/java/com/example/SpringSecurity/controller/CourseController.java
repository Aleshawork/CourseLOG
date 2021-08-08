package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.entity.Course;
import com.example.SpringSecurity.service.CourseService;
import com.example.SpringSecurity.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping(path = "/all")
    public List<Course> getAll(){
      return  courseService.findAll();
    }
}
