package com.uniovi.sdi2122712spring.services;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

@Autowired
private MarksRepository marksRepository;

public List<Mark> getMarks() {
    List<Mark> marks = new ArrayList<Mark>();
    marksRepository.findAll().forEach(marks::add);
    return marks;
}

public Mark getMark(Long id) {
    return marksRepository.findById(id).get();
}

public void addMark(Mark mark) {
        marksRepository.save(mark);
}
public void deleteMark(Long id) {
    marksRepository.deleteById(id);

}

}
