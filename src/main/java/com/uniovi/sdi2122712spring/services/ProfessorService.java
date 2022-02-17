package com.uniovi.sdi2122712spring.services;

import com.uniovi.sdi2122712spring.entities.Professor;
import com.uniovi.sdi2122712spring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;


    public List<Professor> getProfessors()
    {
        List<Professor> professors = new LinkedList<Professor>();
        professorRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(String dni){
        return professorRepository.findById(dni).get();
    }

    public void addProfessor(Professor professor){
        professorRepository.save(professor);
    }

        public void deleteProfessor(String dni){
            professorRepository.deleteById(dni);
    }


}
