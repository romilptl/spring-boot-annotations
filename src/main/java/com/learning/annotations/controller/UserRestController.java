package com.learning.annotations.controller;

import com.learning.annotations.modal.User;
import com.learning.annotations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/rest")
public class UserRestController {

    @Autowired UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
