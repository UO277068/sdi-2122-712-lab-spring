package com.uniovi.sdi2122712spring.services;

import com.uniovi.sdi2122712spring.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {
    private List<Professor> professorList = new LinkedList<Professor>();

    @PostConstruct
    public void init()
    {
        professorList.add(new Professor("5","Pepe","Gonzalez","Docente"));
        professorList.add(new Professor("5","Pepe","Gonzalez","Docente"));
    }

    public List<Professor> getProfessors()
    {
        return professorList;
    }

    public Professor getProfessor(String dni){
       return professorList.stream().filter(professor -> professor.getDni().equals(dni)).findFirst().get();
    }

    public void addProfessor(Professor professor){

        if(professor.getDni()!=null) {
            professorList.add(professor);
        }
    }

        public void deleteProfessor(String dni){
        Professor p = getProfessor(dni);
        if (p!=null) {
            this.professorList.remove(p);
        }
    }


}
