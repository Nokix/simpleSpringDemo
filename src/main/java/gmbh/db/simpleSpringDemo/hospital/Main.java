package gmbh.db.simpleSpringDemo.hospital;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HospitalConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();

        System.out.println("########## BEANS: ###########");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}

// main -> main methode erstellen
// Zum nächsten Fehler im Code springen: F2
// Strg+Alt+V für Variable definieren
// Automatisch generieren: Alt+Einfg
// Oder: Rechtsklick -> Generate...
// sout -> System.out.println
// Strg+Shift+Enter Zeile abschließen
