package com.example.RestApiController;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    Map<Integer, User> users = new HashMap<>();

//    this Api helps us to get the data of user from the hashmap
    @GetMapping("/get_users")     //http://localhost:8080/get_users
    public List<User> getUsers(){
        List<User> ListofUsers = new ArrayList<>();
        for(User user: users.values()){
            ListofUsers.add(user);
        }
        return ListofUsers;
    }

//    this Api well help us to add the user to Hashmap

//    @PostMapping("/add_user")   //http://localhost:8080/add_user?id=1&name=mudasir&age=24&country=India
    public void addUsers(@RequestParam(value = "id") int id,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "age") int age,
                         @RequestParam(value = "country") String country){
        User user = new User(id, name, age, country);
        users.put(id,user);
    }

//    this API will help us to add the user in a HashMap
    @PostMapping("/add_user_body")              //http://localhost:8080/add_user_body    it is used to add the data in hashmap
    public void addUserBody(@RequestBody(required = true)User u){
        users.put(u.getId(), u);
    }

//    this API will help us to get a particular user from Hashmap
    @GetMapping("/get_user/{id}")      //http://localhost:8080/get_user/2
    public User getUser(@PathVariable("id") int x){

        return users.get(x);
    }

//    this API Will help us to delete a particular user from the Hashmap
    @DeleteMapping("/delete_user/{id}")         //http://localhost:8080/delete_user/2
    public void deleteUsre(@PathVariable("id") int x ){

        users.remove(x);
    }

//    This Api Will help us to update the data of a particular user in a Hashmap
    @PutMapping("update_user/{id}")          //http://localhost:8080/update_user/2
    public void updateUser(@PathVariable("id") int id,@RequestBody() User u){

        users.put(id,u);
    }
}
