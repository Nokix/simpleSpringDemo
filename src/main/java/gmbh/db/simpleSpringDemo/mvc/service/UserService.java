package gmbh.db.simpleSpringDemo.mvc.service;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import gmbh.db.simpleSpringDemo.mvc.repository.UserRepoLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepoLocal userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User saveRandomNewUser() {
        String randomName = "Gustav";
        User user = new User(100L, randomName);
        return userRepo.save(user);
    }
}
