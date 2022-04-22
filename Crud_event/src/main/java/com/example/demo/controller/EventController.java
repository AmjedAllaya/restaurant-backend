package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventServices eservice;

    @RequestMapping("/event")
    public String viewHomePage(Model model) {
        List<Event> ListEvent = eservice.listAll();
        model.addAttribute("ListEvent",ListEvent);
        return "event";
    }
    @RequestMapping(value="/newEvent", method= RequestMethod.GET)
    public String newCat(Model model) {
        Event event=new Event();
        model.addAttribute(event);
        return "createEvent";
    }

    @RequestMapping(value="/saveEvent", method= RequestMethod.POST)
    public String saveCat(@ModelAttribute("event") Event event) {
        eservice.save(event);
        return "redirect:/event";
    }

    @RequestMapping("editEvent/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable (name="id") Long id) {
        ModelAndView mav=new ModelAndView("editEvent");
        Event event=eservice.get(id);
        mav.addObject("event",event);
        return mav;
    }

    @RequestMapping("deleteEvent/{id}")
    public String deleteCategoriePage(@PathVariable(name="id") Long id) {
        eservice.delete(id);
        return "redirect:/event";
    }


}
