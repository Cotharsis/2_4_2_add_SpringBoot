package jm.boot.controller;


import jm.boot.model.Role;
import jm.boot.model.User;
import jm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allUsers(@AuthenticationPrincipal User user) {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        modelAndView.addObject("userA", user);
        modelAndView.addObject("allRoles", Role.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addEditUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        List<User> usersis = userService.allUsers();
//        if(usersis.contains(user)==false){
            userService.edit(user);
//    }else{
//            user.setRoles(Collections.singleton(Role.ROLE_USER));
//            userService.add(user);}
        return modelAndView;
    }




    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("allRoles", Role.values());
        modelAndView.addObject("User", user);
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute User user, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.edit(user);
        return modelAndView;
    }
//    @RequestMapping(value = "/user-update", method = RequestMethod.POST)
//    public ModelAndView updateUser(
//            @RequestParam(value = "id1", required = false ) Integer id,
//            @RequestParam(value = "name1", required = false ) String name,
//            @RequestParam(value = "password1", required = false ) String password,
//            @RequestParam(value = "role1", required = false ) String role) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/users");
//        System.out.println(id + " " + name + " " + password + " " + role);
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setPassword(password);
//        if (!role.equals("ROLE_ADMIN")) role = "ROLE_USER";
//        List<Long> rolesId = new ArrayList<>(); //чистый лист
//        for (Role role1 : userService.findAllRole()){
//            rolesId.add(role1.getId());
//        }
//        Role role2 = new Role(Collections.max(rolesId) + 1L, role);
//        userService.saveRole(role2);
//        user.setRoles(Collections.singleton(role2));
//        userService.saveUser(user);
//        return modelAndView;
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView addPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("addUser");
//        return modelAndView;
//    }
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        user.setRoles(Collections.singleton(Role.ROLE_USER));
////      user.setRoles(Set.of(Role.ROLE_USER, Role.ROLE_ADMIN));
//        userService.add(user);
//        return modelAndView;
//    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }

}

