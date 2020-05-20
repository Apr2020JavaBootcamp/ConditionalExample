package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/confirmation")
    public String list(@ModelAttribute Student student, Model model){
        if (student.getScore() >= 70)
            student.setHasPassed(true);
        else
            student.setHasPassed(false);

        model.addAttribute("student", student);
        return "confirmStudent";
    }

//    @PostMapping("/again")
//    public String again(@RequestParam("answer") boolean answer, Model model){
//        if (answer)
//            return "redirect:/";
//        else
//            return "signoff";
//    }


}
