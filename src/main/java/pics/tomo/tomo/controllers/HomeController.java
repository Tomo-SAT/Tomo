package pics.tomo.tomo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/messages")
    public String messages() {
        return "/cons/messages";
    }

    @GetMapping("/display")
    public String display() { return "/users/display"; }

    @GetMapping("/about-fun")
    public String aboutFun() {return "about-fun";}

    @GetMapping("/about")
    public String about() {return "about";}



}