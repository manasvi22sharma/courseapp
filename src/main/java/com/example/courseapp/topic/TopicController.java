package com.example.courseapp.topic;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        //spring mvc will covert list to jason automtically
        return Arrays.asList(
            new Topic("spring","Spring","Spring framework course"),
            new Topic("java","JAVA Core","JAVA course"),
            new Topic("javascript","JavaScript","JavaScript course")
        );
    }
    
}
