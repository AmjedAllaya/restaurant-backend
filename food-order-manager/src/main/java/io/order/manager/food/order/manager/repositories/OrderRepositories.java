package io.order.manager.food.order.manager.repositories;

import io.order.manager.food.order.manager.entities.Food_Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositories extends JpaRepository<Food_Order,Integer> {
}
