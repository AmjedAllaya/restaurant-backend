package com.nilesh.springCRUD.controller;

import com.nilesh.springCRUD.model.Category;
import com.nilesh.springCRUD.model.Produit;
import com.nilesh.springCRUD.model.Student;
import com.nilesh.springCRUD.services.CatalogueServices;
import com.nilesh.springCRUD.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CatalogueController {

    @Autowired
    CatalogueServices cataservice;

    @RequestMapping("/cata")
    public String viewHomePageCatalogue(Model model) {
        //List<Produit> catalogue = cataservice.listAll();
        //model.addAttribute("catalogue",catalogue);;
        return "side";
    }
}
