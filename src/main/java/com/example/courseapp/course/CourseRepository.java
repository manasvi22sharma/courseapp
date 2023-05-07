package com.example.courseapp.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String>{
    //implementation done by spring automatically as we named methord in a proper way
    public List<Course> findByTopicId (String topicId);

}