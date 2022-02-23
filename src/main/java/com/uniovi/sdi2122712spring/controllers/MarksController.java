package com.uniovi.sdi2122712spring.controllers;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarksController {

    //Inyectar beans
    @Autowired
    private MarksService marksService;

    @RequestMapping(value = "/mark/add") //Get
    public String getMark() {
        return "mark/add";
    }

    @RequestMapping(value="/mark/add",method= RequestMethod.POST) //Post
    public String setMark(@ModelAttribute Mark mark){

        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping("/mark/list")
    public String getList(Model model){

        model.addAttribute("markList", marksService.getMarks());
        return "/mark/list";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }

    //Edit

    @RequestMapping("/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/edit";
    }

    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        mark.setId(id);
        marksService.addMark(mark);
        return "redirect:/mark/details/" + id;
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model){
        model.addAttribute("markList", marksService.getMarks() );
        return "mark/list :: tableMarks";
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
