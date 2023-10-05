package fastcampus.projectboard.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller //controller anotaion
public class MainController {

    @GetMapping("/")
    public String root() {
       return  "forward:/articles";
    }
}
