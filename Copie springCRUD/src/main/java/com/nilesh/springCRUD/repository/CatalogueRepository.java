package com.nilesh.springCRUD.repository;

import com.nilesh.springCRUD.model.Category;
import com.nilesh.springCRUD.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Produit, Long> {
}
