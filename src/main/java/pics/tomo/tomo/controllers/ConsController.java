package pics.tomo.tomo.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pics.tomo.tomo.daos.ConSheduleRepository;
import pics.tomo.tomo.daos.ConsRepository;
import pics.tomo.tomo.models.Con;
import pics.tomo.tomo.models.ConSchedule;
import pics.tomo.tomo.models.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class ConsController {

    private ConsRepository consRepo;
    private ConSheduleRepository conSheduleRepository;
    public ConsController(ConsRepository consRepo, ConSheduleRepository conSheduleRepository) {
        this.consRepo = consRepo;
        this.conSheduleRepository = conSheduleRepository;
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

    @GetMapping("/cons/calender")
    public String calender(Model model)
    {model.addAttribute("cons",consRepo.findAll());
    return "cons/calender";
    }

    @GetMapping("/addCon")
    public String showAddConPage(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
        return "cons/addCon";
    }


//    @PostMapping("/addCon")
//    @ResponseBody
//    public String saveConScheduleF(@RequestParam(name = "fGroup")List<String> times) {
//        return Arrays.toString(times.toArray());
////        viewmodle.attribute("fGroup", times);
////        return "user/profile";
//    }

//    @PostMapping("/addCon")
//    @ResponseBody
//    public String saveConScheduleS(@RequestParam(name = "sGroup")List<String> times) {
//        return Arrays.toString(times.toArray());
////        viewmodle.attribute("sGroup", times);
////        return "user/profile";
//    }

    @PostMapping("/addCon/{id}")
    @ResponseBody
    public String saveConSchedule(@PathVariable Long id, @RequestParam(name = "Group")List<String> times) {
        Con con = consRepo.findOne(id);
        User creator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (String time : times) {
            String[] parts = time.split(" ");
            String day = parts[0];
            String time1 = parts[1];

            ConSchedule conSchedule = new ConSchedule(creator, con, time1, day);
            conSheduleRepository.save(conSchedule);
        }

        return Arrays.toString(times.toArray());
//        viewmodle.attribute("suGroup", times);
//        return "user/profile";
    }
}