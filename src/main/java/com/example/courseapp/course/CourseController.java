package com.example.courseapp.course;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseapp.topic.Topic;

// spring is the one initalzing and creating object for controller class.
@RestController
public class CourseController {
    //tell springs that this class  has a dependency, now spring make sure that we have a instance of the service in this class
    @Autowired
    private CourseService courseservice;
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        //spring mvc will covert list to jason automtically
       return courseservice.getAllCourses(id);
    }

    //{} mark the path as a parameter
    //@pathVariable("id") to map the uri to input
    //@pathvaribale tells spring the id is a path variable and its valus will be picked form path
    @RequestMapping("/topics/{topic_id}/courses/{course_id}")
    public Course getCourse(@PathVariable String course_id){
        return courseservice.getCourse(course_id);
    }

    
    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
    public void addCourse ( @RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseservice.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topic_id}/courses/{id}")
    public void deleteTopic( @PathVariable String id){
        courseservice.deletecourse(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseservice.updateCourse(course);
    }

}
