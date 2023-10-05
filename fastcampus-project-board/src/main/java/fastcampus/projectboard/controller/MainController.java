package fastcampus.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //controller anotaion
public class MainController {

    @GetMapping("/")
    public String root() {
        return "forward:/articles";
    }
}
