package com.example.product.productmicroservice.ressources;

import com.example.product.productmicroservice.models.Product;
import com.example.product.productmicroservice.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/products")
public class ProductRessources {
    @Autowired
    ProductRepositories productRepositories;

    @GetMapping
// Affiche Liste des ordres
    public List<Product> allpro() {
        List<Product> pro= productRepositories.findAll();
        return pro;
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public Product addOrder(Product order) {
        return productRepositories.save(order);
    }

    @PutMapping(value = "/{id}")
    // Update order
    public Product updateOrder(int id, Product newOrder) {
        if (productRepositories.findById(id).isPresent()) {
            Product existingOrder = productRepositories.findById(id).get();
            existingOrder.setName(newOrder.getName());
            existingOrder.setPrice(newOrder.getPrice());
            existingOrder.setDescription(newOrder.getDescription());
            return productRepositories.save(existingOrder);

        } else
            return null;
    }

    @DeleteMapping(value = "/{id}")
    // Delete Order
    public String deleteOrder(int id) {
        if (productRepositories.findById(id).isPresent()) {
            productRepositories.deleteById(id);
            return "order supprimé";
        } else {
            return "order non supprimé";
        }
    }

}
