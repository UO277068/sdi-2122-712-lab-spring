package com.uniovi.sdi2122712spring.repositories;


import com.uniovi.sdi2122712spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>
{
}
