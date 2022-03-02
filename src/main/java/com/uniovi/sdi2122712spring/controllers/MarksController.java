package com.uniovi.sdi2122712spring.controllers;

import com.uniovi.sdi2122712spring.entities.Mark;
import com.uniovi.sdi2122712spring.entities.User;
import com.uniovi.sdi2122712spring.services.MarksService;
import com.uniovi.sdi2122712spring.services.UsersService;
import com.uniovi.sdi2122712spring.validators.AddMarkValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
public class MarksController {

    //Inyectar beans
    @Autowired
    private MarksService marksService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AddMarkValidator addMarkValidator;

    @Autowired
    private HttpSession httpSession;


    @RequestMapping(value = "/mark/add") //Get
    public String getMark(Model model){
        model.addAttribute("usersList", usersService.getUsers());
        model.addAttribute("mark", new Mark());
        return "mark/add";
    }

    @RequestMapping(value="/mark/add",method= RequestMethod.POST) //Post
    public String setMark(@Validated Mark mark, BindingResult result,Model model){
        addMarkValidator.validate(mark,result);
        if(result.hasErrors()){
            model.addAttribute("usersList", usersService.getUsers());
            return "/mark/add";
        }
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping("/mark/list")
    public String getList(Model model, Principal principal){
//        Set<Mark> consultedList= (Set<Mark>) httpSession.getAttribute("consultedList");
//        if ( consultedList == null ) {
//            consultedList = new HashSet<Mark>();
//        }
//        model.addAttribute("consultedList", consultedList);

        String dni = principal.getName(); // DNI es el name de la autenticación
        User user = usersService.getUserByDni(dni);
        model.addAttribute("markList", marksService.getMarksForUser(user));
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
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        Mark originalMark = marksService.getMark(id);
        originalMark.setScore(mark.getScore()); //Solo se modifica la score y description
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/" + id;
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model,Principal principal){
        String dni = principal.getName(); // DNI es el name de la autenticación
        User user = usersService.getUserByDni(dni);
        model.addAttribute("markList", marksService.getMarksForUser(user) );
        return "mark/list :: tableMarks";
    }

    @RequestMapping(value = "/mark/{id}/resend", method = RequestMethod.GET)
    public String setResendTrue(Model model, @PathVariable Long id) {
        marksService.setMarkResend(true, id);
        return "redirect:/mark/list";
    }
    @RequestMapping(value = "/mark/{id}/noresend", method = RequestMethod.GET)
    public String setResendFalse(Model model, @PathVariable Long id) {
        marksService.setMarkResend(false, id);
        return "redirect:/mark/list";
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
