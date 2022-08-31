package main.web.controller;

import main.hiber.entity.User;
import main.hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> userList = service.listUsers();
        model.addAttribute("userList", userList);
        return "all-users.html";
    }

    @RequestMapping(value = "/delete-user")
    public String deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam Long id, Model model) {
        User user = service.getUser(id);
        model.addAttribute("user", user);
        return "user-info.html";
    }

    @RequestMapping("/new-user")
    public String saveUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info.html";
    }

    @RequestMapping("/save-or-update-user")
    public String userInfo(@ModelAttribute("user") User user) {
        service.saveOrUpdate(user);
        return "redirect:/";
    }
}