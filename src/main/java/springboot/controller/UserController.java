package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.entity.User;
import springboot.service.UserServiceImpl;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String allFilms(Model model) {
        model.addAttribute("users", userServiceImpl.listAll());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.get(id));
        return "create_or_update";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create_or_update";
    }

    @PutMapping("/{id}")
    public String create(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id, Model model) {
        userServiceImpl.delete(id);

        return "redirect:/";
    }
}