package com.example.courseapp.course;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//A service layer is a layer in an application that facilitates communication between the controller and the persistence layer.
//mark this as business service
@Service
public class CourseService {

    // adding repository
    @Autowired
    private CourseRepository courseRepo;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses=new ArrayList<>();
        courseRepo.findByTopicId(topicId).forEach(courses:: add);
        return courses;
    }
    public Course getCourse(String id){
        return courseRepo.findById(id).orElse(null);
    }
    public void addCourse(Course course){
        courseRepo.save(course);
    }
    public void deletecourse(String id){
        courseRepo.deleteById(id);
    }
    public void updateCourse(Course course){

        courseRepo.save(course);
    }
}
