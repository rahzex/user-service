package com.stackroute.userservice.services;

import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User getUser(int id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public List<User> getAllUsers(){
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers;
    }

    public User updateUser(User user,int id){
        user.setId(id);
        return userRepository.save(user);
    }

}
