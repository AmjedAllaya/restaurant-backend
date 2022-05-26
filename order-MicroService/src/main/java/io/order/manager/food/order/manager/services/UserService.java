package io.order.manager.food.order.manager.services;


import io.order.manager.food.order.manager.entities.User;

import java.util.Collection;

public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
