package com.stackroute.userservice.controllers;

import com.stackroute.userservice.services.UserService;
import com.stackroute.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User savedUser = userService.saveUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        User foundUser = userService.getUser(id);
        return new ResponseEntity<User>(foundUser,HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List>(userList,HttpStatus.OK);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") int id){
        User updatedUser = userService.updateUser(user,id);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }
}
