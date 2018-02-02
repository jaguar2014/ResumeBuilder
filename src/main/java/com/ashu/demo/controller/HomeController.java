package com.ashu.demo.controller;


import com.ashu.demo.model.Education;
import com.ashu.demo.model.Experience;
import com.ashu.demo.model.Skill;
import com.ashu.demo.model.User;
import com.ashu.demo.repository.EducationRepository;
import com.ashu.demo.repository.ExperienceRepository;
import com.ashu.demo.repository.SkillRepository;
import com.ashu.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("user", new User());
        return "userform";

    }


    @PostMapping("/adduser")
    public String addUser(@Valid User user , BindingResult result){

        if(result.hasErrors()){
            return "userform";
        }

        userRepository.save(user);
     return "redirect:/addmore";
    }

    @GetMapping("/addmore")
    public String addMore(){
        return "addmoreform";
    }

    @GetMapping("/addexperience")
    public String addExperience(Model model)
    {
        model.addAttribute("experience", new Experience());

        return "experienceform";
    }

    @PostMapping("/addexperience")
    public String addUser(@Valid Experience experience , BindingResult result){

        if(result.hasErrors()){
            return "experienceform";
        }

        experienceRepository.save(experience);

        return "addmoreform";
    }

    @GetMapping("/addeducation")
    public String addEducation(Model model)
    {
        model.addAttribute("education", new Education());

        return "educationform";
    }


    @PostMapping("/addeducation")
    public String addEducation(@Valid Education education , BindingResult result){

        if(result.hasErrors()){
            return "educationform";
        }

        educationRepository.save(education);

        return "addmoreform";
    }


    @GetMapping("/addskill")
    public String addSkill(Model model)
    {
        model.addAttribute("skill", new Skill());

        return "skillform";
    }


    @PostMapping("/addskill")
    public String addEducation(@Valid Skill skill , BindingResult result){

        if(result.hasErrors()){
            return "skillform";
        }

        skillRepository.save(skill);

        return "addmoreform";
    }

    @GetMapping("/display")
    public String displayResume(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("experiences",experienceRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());

        return "displayresume";

    }








}
