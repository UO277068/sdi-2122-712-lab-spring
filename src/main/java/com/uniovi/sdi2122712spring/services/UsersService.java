package com.uniovi.sdi2122712spring.services;

import java.util.*;
import javax.annotation.PostConstruct;

import com.uniovi.sdi2122712spring.entities.User;
import com.uniovi.sdi2122712spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String  passwordEncript;

    @PostConstruct
    public void init() {
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public void addUser(User user) {
        user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
        passwordEncript=user.getPassword();
        usersRepository.save(user);
    }

    public void updateUser(User user)
    {
        user.setPassword(passwordEncript);
       usersRepository.save(user);
    }
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public User getUserByDni(String dni) {
        return usersRepository.findByDni(dni);
    }

}
