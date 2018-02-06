package pics.tomo.tomo.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pics.tomo.tomo.daos.ConsRepository;
import pics.tomo.tomo.models.User;

@Controller
public class ConsController {

    private ConsRepository consRepo;

    public ConsController(ConsRepository consRepo) {
        this.consRepo = consRepo;
    }

    @GetMapping("/upcomingCons")
    public String showCons(Model model) {
        model.addAttribute("cons", consRepo.findAll());
        return "cons/upcomingCons";
    }

    @GetMapping("/cons/{id}")
    public String showIndividualCon(@PathVariable long id, Model model) {
        model.addAttribute("con", consRepo.findOne(id));
        return "cons/showCon";
    }

    @GetMapping("/calender")
    public String showCalender(Model model)
    {model.addAttribute("cons",consRepo.findAll());
    return "cons/calender";
    }




    @GetMapping("/cons/calender")
    public String calender(Model model) {model.addAttribute("cons",consRepo.findAll());
    return "cons/calender";
    }

    @GetMapping("/addCon")
    public String showAddConPage(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
        return "cons/addCon";
    }

}