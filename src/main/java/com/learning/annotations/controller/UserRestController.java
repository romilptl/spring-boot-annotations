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
    public ResponseEntity<List<User>> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        List<User> users = userService.findAllFilter(isDeleted);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
