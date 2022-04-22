package io.order.manager.food.order.manager.services;

import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.repositories.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositories orderRepositories;
    // Affiche Liste des ordres
    public List<Food_Order> allOrders() {
        return orderRepositories.findAll();
    }

    //Ajouter order:
    public Food_Order addOrder(Food_Order order) {
        return orderRepositories.save(order);
    }

    // Update order
    public Food_Order updateOrder(int id, Food_Order newOrder) {
        if (orderRepositories.findById(id).isPresent()) {
            Food_Order existingOrder = orderRepositories.findById(id).get();
            existingOrder.setReference(newOrder.getReference());
            existingOrder.setQuantity(newOrder.getQuantity());
            existingOrder.setTotalPrice(newOrder.getTotalPrice());
            return orderRepositories.save(existingOrder);

        } else
            return null;
    }

    // Delete Order
    public String deleteOrder(int id) {
        if (orderRepositories.findById(id).isPresent()) {
            orderRepositories.deleteById(id);
            return "candidat supprimé";
        } else {
            return "candidat non supprimé";
        }
    }
}
