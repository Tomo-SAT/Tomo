package pics.tomo.tomo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

//    @GetMapping("/upcomingCons")
//    public String upcoming() {
//        return "/cons/upcomingCons";
//    }

    @GetMapping("/messages")
    public String messages() {
        return "/cons/messages";
    }

    @GetMapping("/display")
    public String display() {
        return "/users/display";
    }

}