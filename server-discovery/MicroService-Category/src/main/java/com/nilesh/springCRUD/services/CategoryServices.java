package com.nilesh.springCRUD.services;

import com.nilesh.springCRUD.models.Category;
import com.nilesh.springCRUD.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository repo;

    public List<Category> listAll(){
        return repo.findAll();
    }

    public void save(Category cat) {
        repo.save(cat);
    }

    public Category get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
