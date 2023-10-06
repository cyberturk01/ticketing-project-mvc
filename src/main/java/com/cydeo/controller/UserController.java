package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        //RoleDTO will change
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String postUser(@ModelAttribute("user") UserDTO user, Model model) {
//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());
//        model.addAttribute("users", userService.findAll());
//      Save it before regenerating the page
        userService.save(user);
//      if you same view u can use redirect, and you don't need to add attributes again
        return "redirect:/user/create";
    }

    @GetMapping("/update/{email}")
    public String editUser(@PathVariable("email") String email, Model model){
        userService.update(userService.findById(email));
        model.addAttribute("user", userService.findById(email));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/update";
    }
    @PostMapping("/update")
    public String updateUser(UserDTO user){
        userService.update(user);

        return "redirect:/user/create";
    }
}
