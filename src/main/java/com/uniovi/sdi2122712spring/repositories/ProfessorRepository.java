package com.uniovi.sdi2122712spring.repositories;

import com.uniovi.sdi2122712spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor,String> {
    Professor findByDni(String dni);
}
