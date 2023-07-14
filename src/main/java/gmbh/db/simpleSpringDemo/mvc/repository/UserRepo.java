package gmbh.db.simpleSpringDemo.mvc.repository;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
