package com.uniovi.sdi2122712spring.controllers;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    //Inyectar beans
    @Autowired
    private MarksService marksService;

    @RequestMapping(value="/mark/add",method= RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark){

        marksService.addMark(mark);
        return "ok";
    }

    @RequestMapping("/mark/list")
    public String getList(){
        return marksService.getMarks().toString();
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id){
        return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        return "ok";
    }


    /* Version anterior 1.0
    @RequestMapping(value="/mark/add",method= RequestMethod.POST)
    public String setMark(@RequestParam String description,@RequestParam String score){
        return "Added:"+description+"with score"+score;
    }
     */

    /* Version anterior 1.1
    @RequestMapping("/mark/list")
    public String getList(){
        return "Getting List";
    }

    @RequestMapping(value="/mark/add",method= RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark){
        return "Added:"+mark.getDescription()+"with score:"+mark.getScore() + "id:"+mark.getId();
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id){
        return "Getting Details=>"+id;
    }

     */


}
