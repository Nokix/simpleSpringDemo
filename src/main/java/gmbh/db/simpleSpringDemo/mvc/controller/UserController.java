package gmbh.db.simpleSpringDemo.mvc.controller;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import gmbh.db.simpleSpringDemo.mvc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/find")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByName(@RequestParam String name) {
        return userService.getUsersByName(name);
    }

    @PostMapping("/users/create")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> createRandomUser(
            @RequestParam(defaultValue = "1", name = "n") int amount
    ) {
        return userService.saveRandomNewUsers(amount);
    }

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveNewUser(
            @Valid @RequestBody User user
    ) {
        User user1 = userService.saveUser(user);
        return user1;
    }
}
