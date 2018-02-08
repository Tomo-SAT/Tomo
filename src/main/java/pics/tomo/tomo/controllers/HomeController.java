package pics.tomo.tomo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "home";
    }
    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/messages")
    public String messages() {
        return "/cons/messages";
    }

    @GetMapping("/display")
    public String display() {
        return "/users/display";
    }

}