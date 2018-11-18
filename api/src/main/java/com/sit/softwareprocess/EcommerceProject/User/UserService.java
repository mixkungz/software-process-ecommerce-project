package com.sit.softwareprocess.EcommerceProject.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(int id){
         return userRepository.getOne(id);
    }

    public void createUser(String username, String password, String firstName, String lastName,  String email, String telephoneNumber,boolean isAdmin){
        User user = new User(username,password,firstName,lastName,email,telephoneNumber,isAdmin);
        userRepository.save(user);
    }

}
