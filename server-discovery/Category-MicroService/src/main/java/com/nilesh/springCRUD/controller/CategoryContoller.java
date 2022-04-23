package com.nilesh.springCRUD.controller;

//import com.nilesh.springCRUD.model.Student;
import com.nilesh.springCRUD.model.Category;
import com.nilesh.springCRUD.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/category")
public class CategoryContoller {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
// Affiche Liste des category
    public List<Category> allOffers() {
        List<Category> allcategory =  categoryRepository.findAll();
        return allcategory;
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter category:
    public Category addcategory(Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping(value = "/{id}")
    // Update category
    public Category updateCategory(Long id, Category newCategory) {
        if (categoryRepository.findById(id).isPresent()) {
            Category existingcategory = categoryRepository.findById(id).get();
            existingcategory.setNom(newCategory.getNom());
            existingcategory.setDescription(newCategory.getDescription());
            existingcategory.setProds(newCategory.getProds());
            return categoryRepository.save(existingcategory);

        } else
            return null;
    }

    @DeleteMapping(value = "/{id}")
    // Delete category
    public String deletecategory(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "category supprimé";
        } else {
            return "category non supprimé";
        }
    }

}
