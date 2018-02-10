package pics.tomo.tomo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pics.tomo.tomo.daos.ConScheduleRepository;
import pics.tomo.tomo.daos.ConsRepository;
import pics.tomo.tomo.daos.UsersRepository;
import pics.tomo.tomo.models.ConSchedule;
import pics.tomo.tomo.models.User;
import pics.tomo.tomo.services.UsersService;

@Controller
public class UsersController {

    private UsersRepository usersDao;
    private ConsRepository consDao;
    private ConScheduleRepository consScheduleDao;
    private PasswordEncoder passwordEncoder;
    private UsersService userSvc;

    public UsersController(UsersRepository usersDao, ConsRepository consDao, PasswordEncoder passwordEncoder, UsersService userSvc, ConScheduleRepository consScheduleDao) {
        this.usersDao = usersDao;
        this.consDao = consDao;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
        this.consScheduleDao = consScheduleDao;
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
        userSvc.authenticate(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model ) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (user.getId() == 0) {
//            return "redirect:/login";
//        }
        User userLoggedIn = userSvc.loggedInUser(); //grab the loggedInUser from the UsersService and assign them a name, userLoggedIn.
        User user = usersDao.findById(userLoggedIn.getId());


//        boolean eventsAreEmpty = consDao.findAllById(con.getId()).isEmpty();
//        model.addAttribute("eventsAreEmpty", eventsAreEmpty);

        model.addAttribute("user", user);
        model.addAttribute("isOwnProfile", true);
        model.addAttribute("cons", consDao.findAll());
        model.addAttribute("consSchedule", consScheduleDao.findAllByCreatorId(userLoggedIn.getId()));
        System.out.println("======= get here ========");
        System.out.println(consScheduleDao.findAllByCreatorId(userLoggedIn.getId()));
        System.out.println("======= end here ========");
        return "users/profile";
    }

    @GetMapping("/profile/{id}")
    public String showOtherUsersProfile(@PathVariable Long id, Model model) {
        User user = usersDao.findById(id);
//
//        boolean eventsAreEmpty = consDao.findAllById(con.getId()).isEmpty();
//        model.addAttribute("eventsAreEmpty", eventsAreEmpty);

        model.addAttribute("user", user);
        model.addAttribute("isOwnProfile", userSvc.isLoggedIn() && user.equals(userSvc.loggedInUser()));
        model.addAttribute("cons", consDao.findAll());
        model.addAttribute("consSchedule", consScheduleDao.findAllByCreatorId(id));
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

    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("user", new User());
        return "users/booking";
    }


}
