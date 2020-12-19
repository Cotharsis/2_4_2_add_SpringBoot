package jm.boot.controller;

import jm.boot.model.Role;
import jm.boot.model.User;
import jm.boot.service.UserService;
import jm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/adminn")
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

    //    @PostMapping
//    public ModelAndView addUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        List<User> usersis = userService.allUsers();
//        userService.add(user);
//        return modelAndView;
//    }

//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute User user, @PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/adminn");
//        userService.edit(user);
//        return modelAndView;
//    }
//        @GetMapping("/edit/{id}")
//    public ModelAndView editPage(@PathVariable("id") int id) {
//        User user = userService.getById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editUser");
//        modelAndView.addObject("allRoles", Role.values());
//        modelAndView.addObject("User", user);
//        return modelAndView;
//    }

    @GetMapping("/ad")
    public ResponseEntity<List<User>> read() {
        final List<User> clients = userService.allUsers();
        return clients != null &&  !clients.isEmpty()
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

//
////    @PutMapping ("/edit/{id}")
////    public ModelAndView editUser(@ModelAttribute User user, @PathVariable("id") int id) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("redirect:/admin");
////        userService.edit(user);
////        return modelAndView;
////    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
         userService.edit(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//
//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {

        userService.delete(userService.getById(id));
       // final boolean deleted = userService.delete(userService.getById(id));

//        return userService.getById(id) == null
//                ? new ResponseEntity<>(HttpStatus.OK)
              return new ResponseEntity<>(HttpStatus.OK);
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
////
////    @DeleteMapping(value = "/delete/{id}")
////    public ModelAndView deleteUser(@PathVariable("id") int id) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("redirect:/admin");
////        User user = userService.getById(id);
////        userService.delete(user);
////        return modelAndView;
////    }
//
//
//








//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody User user) {
//        userServices.create(user);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> read() {
//        final List<User> clients = userServices.readAll();
//
//        return clients != null &&  !clients.isEmpty()
//                ? new ResponseEntity<>(clients, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
//        final User user = userServices.read(id);
//
//        return user != null
//                ? new ResponseEntity<>(user, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
//        final boolean updated = userServices.update(user, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
//        final boolean deleted = userServices.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}

