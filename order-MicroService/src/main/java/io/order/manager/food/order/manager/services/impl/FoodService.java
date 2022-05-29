package io.order.manager.food.order.manager.services.impl;

import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.repositories.FoodOrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodOrderRepositories foodOrderRepositories;

    // Affiche Liste des ordres
    public List<Food_Order> allOrders() {
        List<Food_Order> allOrders = foodOrderRepositories.findAll();
        return allOrders;
    }

    // Add order
    public Food_Order addOrder(Food_Order food_order){
        return foodOrderRepositories.save(food_order);
    }

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

    // Delete Order
    public String deleteOrder(int id) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            foodOrderRepositories.deleteById(id);
            return "order supprimé";
        } else {
            return "order non supprimé";
        }
    }
}
