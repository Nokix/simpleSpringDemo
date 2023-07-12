package gmbh.db.simpleSpringDemo.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Doctor {
    String name;
    Nurse nurse;

    public Doctor(
            String name,
            Nurse nurse
    ) {
        this.name = name;
        this.nurse = nurse;
    }

    public void assist() {
        System.out.println("Doctor " + name + " is assisting.");
        this.nurse.assist();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}
