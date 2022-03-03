package com.uniovi.sdi2122712spring.controllers;

import com.uniovi.sdi2122712spring.entities.Professor;
import com.uniovi.sdi2122712spring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @RequestMapping(value = "/professor/details/{dni}") //Get
    public String getDetail(@PathVariable String dni) {
        return professorService.getProfessor(dni).toString();
    }

    @RequestMapping("/professor/list")
    public String getListProfessor(Model model){
        return professorService.getProfessors().toString();
    }

    @RequestMapping("/professor/add")
    public String setProfessor(@ModelAttribute Professor professor){
        professorService.addProfessor(professor);
        return "Se ha añadido correctamente";
    }
    @RequestMapping("/professor/delete/{dni}")
    public String deleteMark(@PathVariable String dni){
        professorService.deleteProfessor(dni);
        return "El profesor se ha eliminado correctamente";
    }
}
