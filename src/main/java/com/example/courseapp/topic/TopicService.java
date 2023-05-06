package com.example.courseapp.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
//A service layer is a layer in an application that facilitates communication between the controller and the persistence layer.
//mark this as business service
@Service
public class TopicService {
    //Arrays.asList makes an immutable list we cant add to it , hehce passed to a arraylist constructor.
    private List<Topic> topics= new ArrayList<>(Arrays.asList(
        new Topic("spring","Spring","Spring framework course"),
        new Topic("java","JAVA Core","JAVA course"),
        new Topic("javascript","JavaScript","JavaScript course")
    ));
    public List<Topic> getAllTopics(){
        return this.topics;
    }
    public Topic getTopic(String id){
        //steam? java 8
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    public void addTopic(Topic topic){
        topics.add(topic);
    }
    public void deleteTopic(String id){
        topics.removeIf(t-> t.getId().equals(id));
    }
    public void updateTopic(String id,Topic topic){
       for(int i=0;i<topics.size();i++){
        Topic t= topics.get(i);
        if(t.getId().equals(id)){
            topics.set(i,topic);
            return;
        }
       }
    }
}
