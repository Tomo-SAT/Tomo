package pics.tomo.tomo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pics.tomo.tomo.daos.ConsRepository;
import pics.tomo.tomo.daos.UsersRepository;
import pics.tomo.tomo.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    private UsersRepository usersDao;
    private ConsRepository consDao;
    private PasswordEncoder passwordEncoder;

    public UsersController(UsersRepository usersDao, ConsRepository consDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.consDao = consDao;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("user", new User());
//        return "users/login";
//    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           @RequestParam(defaultValue = "false", name="roleCos") boolean roleCosValue,
                           @RequestParam(defaultValue = "false", name="rolePhoto") boolean rolePhotoValue){

        user.setCos(roleCosValue);
        user.setPhotog(rolePhotoValue);

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        usersDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User profileUser = usersDao.findOne(user.getId());
        model.addAttribute("user", profileUser);
        return "users/profile";
    }



    @GetMapping("/search")
    public String search(@RequestParam String q, Model viewModel) {
        viewModel.addAttribute("searchedContent", usersDao.search("%" + q + "%"));
//        viewModel.addAttribute("users", usersDao.findAll());
//        viewModel.addAttribute("cons", consDao.findAll());
        return "users/search";
    }


}