package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser() {
        return userRepository.findUserMaxSumOrderDeliveryIn2003();
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findUserWithStatusPaidIn2010();
    }
}
