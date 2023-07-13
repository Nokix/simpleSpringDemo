package gmbh.db.simpleSpringDemo.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String helloWord() {
        logger.info("Hello World endpoint accessed");
        return "Hallo DB!";
    }
}
