package com.example.courseapp.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//A service layer is a layer in an application that facilitates communication between the controller and the persistence layer.
//mark this as business service
@Service
public class TopicService {

    // adding repository
    @Autowired
    private TopicRepository topicRepo;
    //Arrays.asList makes an immutable list we cant add to it , hehce passed to a arraylist constructor.
    // private List<Topic> topics= new ArrayList<>(Arrays.asList(
    //     new Topic("spring","Spring","Spring framework course"),
    //     new Topic("java","JAVA Core","JAVA course"),
    //     new Topic("javascript","JavaScript","JavaScript course")
    // ));
    public List<Topic> getAllTopics(){
        List<Topic> topics =new ArrayList<>();
        topicRepo.findAll().forEach(topics:: add);
        return topics;
        //return this.topics;
    }
    public Topic getTopic(String id){
        //steam? java 8
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepo.findById(id).orElse(null);
    }
    public void addTopic(Topic topic){
        topicRepo.save(topic);
        //topics.add(topic);
    }
    public void deleteTopic(String id){
        topicRepo.deleteById(id);
        //topics.removeIf(t-> t.getId().equals(id));
    }
    public void updateTopic(String id,Topic topic){

        topicRepo.save(topic);
    //    for(int i=0;i<topics.size();i++){
    //     Topic t= topics.get(i);
    //     if(t.getId().equals(id)){
    //         topics.set(i,topic);
    //         return;
    //     }
    //    }
    }
}
