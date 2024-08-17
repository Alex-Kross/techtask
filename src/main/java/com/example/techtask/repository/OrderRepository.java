package com.example.techtask.repository;

import com.example.techtask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o\n" +
            "WHERE quantity > 1\n" +
            "ORDER BY createdAt DESC\n" +
            "LIMIT 1")
    Order findNewOrderWithMoreOneItem();
    @Query("SELECT o FROM Order o\n" +
            "JOIN User u ON  o.userId = u.id\n" +
            "WHERE u.userStatus = 'ACTIVE'\n" +
            "ORDER BY createdAt ASC")
    List<Order> findOrdersActiveUsersSortByDateCreated();
}
