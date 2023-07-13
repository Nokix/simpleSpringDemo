package gmbh.db.simpleSpringDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
class SimpleSpringDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
