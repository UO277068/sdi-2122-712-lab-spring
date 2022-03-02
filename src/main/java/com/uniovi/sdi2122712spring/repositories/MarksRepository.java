package com.uniovi.sdi2122712spring.repositories;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MarksRepository extends CrudRepository<Mark,Long>
{
    //Se utiliza el @Query y se ordena la lista obtenida para evitar error de modificacion.
    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    List<Mark> findAllByUser(User user);

    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1))")
    List<Mark> searchByDescriptionAndName(String searchText);

    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1)) AND r.user=?2 ")
    List<Mark> searchByDescriptionNameAndUser(String searchText,User user);

    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);
}
