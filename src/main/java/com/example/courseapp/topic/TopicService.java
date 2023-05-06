package com.example.courseapp.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
//A service layer is a layer in an application that facilitates communication between the controller and the persistence layer.
//mark this as business service
@Service
public class TopicService {
    private List<Topic> topics= Arrays.asList(
        new Topic("spring","Spring","Spring framework course"),
        new Topic("java","JAVA Core","JAVA course"),
        new Topic("javascript","JavaScript","JavaScript course")
    );
    public List<Topic> getAllTopics(){
        return this.topics;
    }
    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
}
