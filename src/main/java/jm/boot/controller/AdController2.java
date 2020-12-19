package jm.boot.controller;


import jm.boot.model.Role;
import jm.boot.model.User;
import jm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/adminn")
public class AdController2 {
    @Autowired
    private final UserService userService;

    public AdController2(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersButRest");
//        modelAndView.addObject("allRoles", Role.values());
        return modelAndView;
    }
//
////    @RequestMapping(method = RequestMethod.POST)
////    public ModelAndView addEditUser(@ModelAttribute("user") User user) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("redirect:/admin");
////        userService.edit(user);
////        return modelAndView;
////    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//      // user.setRoles(Collections.singleton(Role.ROLE_USER));
////      user.setRoles(Set.of(Role.ROLE_USER, Role.ROLE_ADMIN));
////        userService.add(user);
//        userService.edit(user);
//        return modelAndView;
//    }
//
//
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteUser(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        User user = userService.getById(id);
//        userService.delete(user);
//        return modelAndView;
//    }
//
//
//
//
//
//
//
//
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView editPage(@PathVariable("id") int id) {
//        User user = userService.getById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editUser");
//        modelAndView.addObject("allRoles", Role.values());
//        modelAndView.addObject("User", user);
//        return modelAndView;
//    }
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute User user, @PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        userService.edit(user);
//        return modelAndView;
//    }

}
