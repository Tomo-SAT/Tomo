package pics.tomo.tomo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pics.tomo.tomo.daos.ConsRepository;

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

}