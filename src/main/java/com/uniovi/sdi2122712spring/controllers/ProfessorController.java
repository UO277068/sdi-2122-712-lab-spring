package com.uniovi.sdi2122712spring.controllers;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.entities.Professor;
import com.uniovi.sdi2122712spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorsService professorService;


    @RequestMapping(value = "/professor/details/{dni}") //Get
    public String getDetail(@PathVariable String dni) {
        return professorService.getProfessor(dni).toString();
    }

    @RequestMapping("/professor/list")
    public String getListProfessor(Model model){
        model.addAttribute("professorsList",professorService.getProfessors());
        return "/professor/list";
    }

    @RequestMapping(value ="/professor/add",method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/add") //Get
    public String getProfessor(Model model){
        model.addAttribute("usersList", professorService.getProfessors());
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }


    @RequestMapping("/professor/delete/{dni}")
    public String deleteMark(@PathVariable String dni){
        professorService.deleteProfessor(dni);
        return "El profesor se ha eliminado correctamente";
    }
}
