package com.example.courseapp.topic;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// spring is the one initalzing and creating object for controller class.
@RestController
public class TopicController {
    //tell springs that this class  has a dependency, now spring make sure that we have a instance of the service in this class
    @Autowired
    private TopicService topicservice;
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        //spring mvc will covert list to jason automtically
       return topicservice.getAllTopics();
    }

    //{} mark the path as a parameter
    //@pathVariable("id") to map the uri to input
    //@pathvaribale tells spring the id is a path variable and its valus will be picked form path
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicservice.getTopic(id);
    }

    
    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic ( @RequestBody Topic topic){
        topicservice.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopic( @PathVariable String id){
        topicservice.deleteTopic(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicservice.updateTopic(id, topic);
    }

}
