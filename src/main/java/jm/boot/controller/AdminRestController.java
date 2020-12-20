package jm.boot.controller;

import jm.boot.model.User;
import jm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @GetMapping("/ad")
    public ResponseEntity<List<User>> read() {
        final List<User> clients = userService.allUsers();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
        final User client = userService.getById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.edit(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {

        userService.delete(userService.getById(id));
        // final boolean deleted = userService.delete(userService.getById(id));

//        return userService.getById(id) == null
//                ? new ResponseEntity<>(HttpStatus.OK)
        return new ResponseEntity<>(HttpStatus.OK);
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
