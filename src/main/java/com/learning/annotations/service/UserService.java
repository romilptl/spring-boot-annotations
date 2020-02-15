package com.learning.annotations.service;

import com.learning.annotations.modal.User;
import com.learning.annotations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByContact(String contact) {
        return userRepository.findByContact(contact);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
