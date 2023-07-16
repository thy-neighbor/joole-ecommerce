package com.neighbor.jooleuserservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neighbor.jooleuserservice.user.UserRepository;

@Service
@ComponentScan("com.neighbor.jooleuserservice")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Lazy   //had to add this to fix circular reference error
    @Autowired
    private PasswordEncoder passwordEncoder;    //Josue added(enabled using BCrypt)

    private List<User> testUsers = new ArrayList<>(Arrays.asList(
            new User("test","test","test@test.com","test","image"),
            new User("test1","test1","test1@test.com","test1","image1"),
            new User("test2","test2","test2@test.com","test2","image2")
    ));

    public List<User> getTestUsers() {
        return testUsers;
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> users=new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Transactional
    public User getByUsername(String subjectUsername){
        //return testUsers.stream().filter(t -> t.getUsername().equals(subjectUsername)).findFirst().get();
        return userRepository.findByUsername(subjectUsername);
    }

    @Transactional
    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Create user "+ user.getUsername() +" "+user.getPassword());
        return userRepository.save(user) != null;
    }


    public boolean deleteByUsername(String subjectUsername) {
        return testUsers.removeIf(t -> t.getUsername().equals(subjectUsername));
    }

    @Transactional
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
