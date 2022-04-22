package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.DTO.OrderDTO;
import io.order.manager.food.order.manager.models.Food_Order;
import io.order.manager.food.order.manager.repositories.FoodOrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/orders")
public class OrderRessources {
    @Autowired
    private FoodOrderRepositories foodOrderRepositories;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
// Affiche Liste des ordres
    public Response allOrders() {
        return Response.ok(foodOrderRepositories.findAll()).build();
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public Response addOrder(Food_Order order) {
        return Response.ok(foodOrderRepositories.save(order)).build();
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
    // Update order
    public Response updateOrder(int id, Food_Order newOrder) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            Food_Order existingOrder = foodOrderRepositories.findById(id).get();
            existingOrder.setReference(newOrder.getReference());
            existingOrder.setQuantity(newOrder.getQuantity());
            existingOrder.setTotalPrice(newOrder.getTotalPrice());
            return Response.ok(foodOrderRepositories.save(existingOrder)).build();

        } else
            return null;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
    // Delete Order
    public Response deleteOrder(int id) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            foodOrderRepositories.deleteById(id);
            return Response.ok("good").build();
        } else {
            return Response.ok("bad").build();
        }
    }

}
