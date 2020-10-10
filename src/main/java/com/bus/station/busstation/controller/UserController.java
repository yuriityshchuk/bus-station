package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.User;
import com.bus.station.busstation.service.TicketService;
import com.bus.station.busstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final TicketService ticketService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder,
                          TicketService ticketService) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.ticketService = ticketService;
    }


    @GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }


    @PostMapping(value = "/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }


    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {

        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getById(userId));
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        user.setId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") int userId) {
        userService.deleteById(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/tickets")
    public ResponseEntity<?> getAllTicketsByUserId(@PathVariable("userId") int userId) {

        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAllTicketsByUserId(userId));
    }
}

