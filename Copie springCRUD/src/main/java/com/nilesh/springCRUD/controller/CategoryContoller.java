package com.nilesh.springCRUD.controller;

import com.nilesh.springCRUD.model.Category;
//import com.nilesh.springCRUD.model.Student;
import com.nilesh.springCRUD.model.Student;
import com.nilesh.springCRUD.services.CategoryServices;
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
public class CategoryContoller {
    @Autowired
    CategoryServices cservice;

    @RequestMapping("/cat")
    public String viewHomePage(Model model) {
        List<Category> ListCat = cservice.listAll();
        model.addAttribute("ListCat",ListCat);
        return "cat";
    }
    @RequestMapping("/newcat")
    public String newCat(Model model) {
        Category cat=new Category();
        model.addAttribute(cat);
        return "createcat";
    }

    @RequestMapping(value="/savecat", method= RequestMethod.POST)
    public String saveCat(@ModelAttribute("cat") Category cat) {
        cservice.save(cat);
        return "redirect:/cat";
    }

    @RequestMapping("editcat/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable (name="id") Long id) {
        ModelAndView mav=new ModelAndView("editcat");
        Category cat=cservice.get(id);
        mav.addObject("cat",cat);
        return mav;
    }

    @RequestMapping("deletecat/{id}")
    public String deleteCategoriePage(@PathVariable (name="id") Long id) {
        cservice.delete(id);
        return "redirect:/cat";
    }
}
