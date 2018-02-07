package pics.tomo.tomo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pics.tomo.tomo.daos.ConsRepository;
import pics.tomo.tomo.daos.UsersRepository;
import pics.tomo.tomo.models.User;

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

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
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
        if (user.getId() == 0) {
            return "redirect:/login";
        }
        User profileUser = usersDao.findOne(user.getId());
        model.addAttribute("user", profileUser);
        return "users/profile";
    }

    @GetMapping("/profile/edit")
    public String showEditProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == 0) {
            return "redirect:/login";
        }
        User profileUser = usersDao.findOne(user.getId());
        model.addAttribute("user", profileUser);
        return "users/edit";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(@ModelAttribute User user) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        user.setId(id);
//        usersDao.save(user);
        User profileUser = usersDao.findOne(user.getId());

        profileUser.setName(user.getName());
        profileUser.setBio(user.getBio());
        profileUser.setEmail(user.getEmail());

        usersDao.save(profileUser);
        return "redirect:/profile";
    }


    @GetMapping("/search")
    public String search(@RequestParam String q, Model viewModel) {
        viewModel.addAttribute("searchedContent", usersDao.search("%" + q + "%"));
//        viewModel.addAttribute("users", usersDao.findAll());
//        viewModel.addAttribute("cons", consDao.findAll());
        return "users/search";
    }


}
