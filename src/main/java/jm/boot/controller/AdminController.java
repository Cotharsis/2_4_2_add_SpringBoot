package jm.boot.controller;


import jm.boot.model.Role;
import jm.boot.model.User;
import jm.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
         userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }

}

