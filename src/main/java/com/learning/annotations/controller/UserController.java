package com.learning.annotations.controller;

import com.learning.annotations.modal.User;
import com.learning.annotations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
/*
* -> We can use @RequestMapping at class level to specify common path or prefix related to application or operations
* -> This reduces the the task of specifying common path for all endpoints mapping at method level
*/
public class UserController {

    @Autowired UserService userService;

    /** @Controller & @RestController
     * Removing @ResponseBody from methods findAll,save will results in 404 Not Found "path": "/users/list"
     * Is @ResponseBody is mandatory?
     *   -> Use RestController which is combination of @Controller and @ResponseBody
     *   -> We can use ResponseEntity to resolve 404 Not Found without using @ResponseBody
     */

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public @ResponseBody User save(@RequestBody User user) {
        user = userService.save(user);
        return user;
    }

    @GetMapping(value = "/list")
    public @ResponseBody List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping(value = "/list/error")
    public List<User> findAllWithError() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping(value = "/response-entity/list")
    public ResponseEntity<List<User>> findAllWithResponseEntity() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/contact")
    public @ResponseBody User findUserByContact(@RequestParam(value = "contact") String contact) {
        User user = userService.findByContact(contact);
        return user;
    }

    @GetMapping(value = "/user/{id}")
    public @ResponseBody Optional<User>  findUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id); 
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
