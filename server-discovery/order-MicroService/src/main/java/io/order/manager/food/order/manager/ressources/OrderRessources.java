package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.models.Food_Order;
import io.order.manager.food.order.manager.repositories.FoodOrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/orders")
public class OrderRessources {
    @Autowired
    FoodOrderRepositories foodOrderRepositories;

    @GetMapping
// Affiche Liste des ordres
    public List<Food_Order> allOrders() {
        List<Food_Order> allOrders= foodOrderRepositories.findAll();
        return allOrders;
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public Food_Order addOrder(Food_Order order) {
        return foodOrderRepositories.save(order);
    }

    @PutMapping(value = "/{id}")
    // Update order
    public Food_Order updateOrder(int id, Food_Order newOrder) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            Food_Order existingOrder = foodOrderRepositories.findById(id).get();
            existingOrder.setReference(newOrder.getReference());
            existingOrder.setQuantity(newOrder.getQuantity());
            existingOrder.setTotalPrice(newOrder.getTotalPrice());
            return foodOrderRepositories.save(existingOrder);

        } else
            return null;
    }

    @DeleteMapping(value = "/{id}")
    // Delete Order
    public String deleteOrder(int id) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            foodOrderRepositories.deleteById(id);
            return "candidat supprimé";
        } else {
            return "candidat non supprimé";
        }
    }

}
