package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u\n" +
            "JOIN Order o ON  u.id = o.userId\n" +
            "WHERE (o.price * o.quantity) = " +
            "(SELECT MAX(o.price * o.quantity)\n" +
            "FROM Order o WHERE o.orderStatus = 'DELIVERED' AND\n" +
            "Year(o.createdAt) = 2003)")
    User findUserMaxSumOrderDeliveryIn2003();
    @Query("SELECT u FROM User u\n" +
            "JOIN Order o ON  u.id = o.userId\n" +
            "WHERE o.orderStatus = 'PAID' AND\n" +
            "YEAR(o.createdAt) = 2010")
    List<User> findUserWithStatusPaidIn2010();
}
