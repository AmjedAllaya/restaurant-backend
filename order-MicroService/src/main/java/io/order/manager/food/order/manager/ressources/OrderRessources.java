package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.services.impl.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/orders")
public class OrderRessources {
    @Autowired
    private FoodService foodService;


    @GetMapping
    // Affiche Liste des ordres
    public List<Food_Order> allOrders() {
        List<Food_Order> allOrders = foodService.allOrders();
        return allOrders;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public ResponseEntity<Food_Order> addOrder(@RequestBody Food_Order order) {
        //return foodOrderRepositories.save(order);
        return new ResponseEntity<>(foodService.addOrder(order), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Food_Order> updateFoodOrder(@PathVariable(value = "id") int id, @RequestBody Food_Order food_order) {
        return new ResponseEntity<>(foodService.updateOrder(id, food_order), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFoodOrder(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(foodService.deleteOrder(id), HttpStatus.OK);
    }

}
