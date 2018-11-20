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

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByFacebookId(String facebookId){return  userRepository.findByFacebookId(facebookId);}

    public User getUserByUsername(String username){return  userRepository.findByUsername(username);}

}
