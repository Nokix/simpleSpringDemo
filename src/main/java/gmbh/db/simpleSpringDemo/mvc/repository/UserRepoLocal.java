package gmbh.db.simpleSpringDemo.mvc.repository;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoLocal {
    List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
