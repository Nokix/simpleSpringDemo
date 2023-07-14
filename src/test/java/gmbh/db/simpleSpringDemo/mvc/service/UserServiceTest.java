package gmbh.db.simpleSpringDemo.mvc.service;

import gmbh.db.simpleSpringDemo.mvc.entity.User;
import gmbh.db.simpleSpringDemo.mvc.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    UserRepo userRepo;

    @BeforeEach
    public void setUpRepo() {
        // Antworten der gemockten Bean vorbereiten:
        User user1 = new User(1L, "Karlo");
        User user2 = new User(2L, "Hanna");

        List<User> karloInList = List.of(user1);

        // Anfragen an die gemockte Bean vorbereiten:
        Mockito.when(userRepo.findByName("Karlo"))
                .thenReturn(karloInList);
    }

    @Test
    @DisplayName("Finde User basierend auf dem Namen.")
    public void findUserByName_test() {
        List<User> users = userService.getUsersByName("Karlo");

        assertEquals(1, users.size());
    }
}