package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.repositories.OrderRepositories;
import io.order.manager.food.order.manager.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/orders")
public class OrderRessources {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Food_Order> GetOrders() {
        return orderService.allOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Food_Order> createOrder(@RequestBody Food_Order order) {
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Food_Order> updateOrder(@PathVariable(value = "id") int id, @RequestBody Food_Order order) {
        return new ResponseEntity<>(orderService.updateOrder(id, order), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

}
