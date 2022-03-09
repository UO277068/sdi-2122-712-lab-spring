package   com.uniovi.sdi2122712spring.services;

import com.uniovi.sdi2122712spring.repositories.ProfessorRepository;
import com.uniovi.sdi2122712spring.entities.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorRepository professorsRepository;

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        professorsRepository.findAll().forEach((professors::add));
        return professors;
    }

    public Professor getProfessor(String id) {
        return professorsRepository.findById(id).get();
    }

    public Professor getProfessorByDni(String dni){
        return professorsRepository.findByDni(dni);
    }

    public void addProfessor(Professor professor) {
        professorsRepository.save(professor);
    }

    public void deleteProfessor(String dni) {
        professorsRepository.deleteById(dni);
    }

}
