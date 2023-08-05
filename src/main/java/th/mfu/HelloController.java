package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello World! " + name;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello World!";
    }

    @GetMapping("/plus/{num1}/{num2}")
    int Plus(@PathVariable int num1, @PathVariable int num2) {
        int result = num2 + num1;
        return result;
    }

    // Variable name after (@.....(here) should not be the same)
    @GetMapping("/multiply/{num1}/{num2}")
    int Sum(@PathVariable int num1, @PathVariable int num2) {
        if (num1 != 0 || num2 != 0) {
            int result = num2 * num1;
            return result;
        } else {
            return 0;
        }
    }

}
