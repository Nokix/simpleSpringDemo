package gmbh.db.simpleSpringDemo.mvc.controller;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import gmbh.db.simpleSpringDemo.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users/create")
    public User createRandomUser() {
        return userService.saveRandomNewUser();
    }
}
