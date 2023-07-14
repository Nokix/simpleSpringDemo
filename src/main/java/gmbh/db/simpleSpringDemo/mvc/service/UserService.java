package gmbh.db.simpleSpringDemo.mvc.service;

import com.github.javafaker.Faker;
import gmbh.db.simpleSpringDemo.mvc.entity.User;
import gmbh.db.simpleSpringDemo.mvc.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    Faker faker;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    public List<User> saveRandomNewUsers(int amount) {
        List<User> list = new ArrayList<>();
        for (int value = 0; value < amount; value++) {
            User user = new User(faker.name().firstName());
            list.add(userRepo.save(user));
        }
        return list;
    }

    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<User> getUsersByName(String name) {
        return userRepo.findByName(name);
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
