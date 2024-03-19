package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.entity.User;
import springboot.service.UserSrvice;

@Controller
public class UserController {

    private final UserSrvice userService;

    @Autowired
    public UserController(UserSrvice userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allFilms(Model model) {
        model.addAttribute("users", userService.listAll());
        return "users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "create_or_update";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create_or_update";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id, Model model) {
        userService.delete(id);

        return "redirect:/";
    }
}