package gmbh.db.simpleSpringDemo.hospital;

import org.springframework.stereotype.Component;

@Component
public class Nurse {
    public void assist() {
        System.out.println("Nurse is assisting.");
    }
}
