package pl.polsl.hotelapplication.hotel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! :)";
    }
}