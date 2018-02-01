package com.ashu.demo.controller;


import com.ashu.demo.repository.EducationRepository;
import com.ashu.demo.repository.ExperienceRepository;
import com.ashu.demo.repository.SkillRepository;
import com.ashu.demo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    ExperienceRepository experienceRepository;

    EducationRepository educationRepository;

    SkillRepository skillRepository;

    UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("resume", experienceRepository.findAll());
        return "displayresume";

    }


    @GetMapping("/addexperience")
    public String addExperience(){

    }

    public String processExerience(){

    }

    public String addEducation(){

    }

    public String processEducation(){

    }

    public String addSkill(){

    }

    public String processSkill(){

    }


    public String displayResume(){

    }






}
