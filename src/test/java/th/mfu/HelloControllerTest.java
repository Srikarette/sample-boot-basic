package th.mfu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Test
    public void testHello() {
        // Act
        String response = controller.hello("tang");
        // Assert
        assertEquals("Hello World! tang", response);
    }

    @Test
    public void testPlus() {
        // Act
        int response = controller.Plus(8, 9);
        // Assert
        assertEquals(17, response);
    }

    @Test
    public void testMultiply() {
        // Act
        int response = controller.Sum(5, 3);
        // Assert
        assertEquals(15, response);
    }
}
