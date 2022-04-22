package com.nilesh.springCRUD.services;

import com.nilesh.springCRUD.model.Category;
import com.nilesh.springCRUD.model.Produit;
import com.nilesh.springCRUD.repository.CatalogueRepository;
import com.nilesh.springCRUD.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServices {
    @Autowired
    private CatalogueRepository repo;
    public List<Produit> listAll(){
        return repo.findAll();
    }
}
