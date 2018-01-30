//package pics.tomo.tomo.controllers;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import pics.tomo.tomo.daos.UsersRepository;
//
//@Controller
//public class UsersController {
//
//    private UsersRepository usersDao;
//    private PasswordEncoder passwordEncoder;
//
//    public UsersController(UsersRepository usersDao, PasswordEncoder passwordEncoder) {
//        this.usersDao = userDao;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("user", new User())
//    }
//
//}
