package task.microservices.tikhonov.microservicesTask1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import task.microservices.tikhonov.microservicesTask1.model.User;
import task.microservices.tikhonov.microservicesTask1.service.UserServiceImplementation;

@Controller
@RequestMapping("/app")
public class UsersController {

    private UserServiceImplementation userServiceImplementation;

    @Autowired
    public UsersController(UserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userServiceImplementation.getUsers());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        System.out.println("get: " + id);
        model.addAttribute("user", userServiceImplementation.getUser(id));
        return "users/user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("delete: " + id);
        userServiceImplementation.deleteUser(id);
        return "redirect:/app";
    }

    @GetMapping("/new")
    public String newUserForm(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userServiceImplementation.addUser(user);
        return "redirect:/app";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userServiceImplementation.getUser(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        System.out.println("here");
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userServiceImplementation.updateUser(id, user);
        return "redirect:/app";
    }


}
