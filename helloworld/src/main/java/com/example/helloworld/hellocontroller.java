package com.example.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class hellocontroller {

    // in-memory list to store users....no data base just list
    private List<User> users=new ArrayList<>();

    //post add new user
     @PostMapping("/users")
    public String addUser(@RequestBody List<User> userList) {
        users.addAll(userList);
        return "user added : "+ users.size();
       
    }

    //GET:return list of all users..which we will be posting

    @GetMapping("/userss")

    public List<User> getUsers(){
        return users;
    }
    
}
