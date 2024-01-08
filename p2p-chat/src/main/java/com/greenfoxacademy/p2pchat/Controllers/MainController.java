package com.greenfoxacademy.p2pchat.Controllers;

import com.greenfoxacademy.p2pchat.Models.Message;
import com.greenfoxacademy.p2pchat.Models.User;
import com.greenfoxacademy.p2pchat.Services.Main.MainService;
import com.greenfoxacademy.p2pchat.Services.Message.MessageService;
import com.greenfoxacademy.p2pchat.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final MainService mainService;
    private final UserService userService;
    private final MessageService messageService;

    @Autowired
    public MainController(MainService mainService, UserService userService, MessageService messageService) {
        this.mainService = mainService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String index(User user, Message message, Model model) {
        mainService.log();
        if (mainService.userRepoCheck()) {
            List<Message> messages = messageService.findAll();
            model.addAttribute("user", user);
            model.addAttribute("messages", messages);
            return "index";
        }
        return "register";
    }

    @GetMapping("/register")
    public String registerGet(Model model, User user) {
        if (mainService.userRepoCheck()) {
            return "index";
        }
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam(name = "clientId", required = false) String clientId, User user, Model model) {
        if (user.getClientId() == null || user.getClientId().isEmpty()) {
            model.addAttribute("error", "The username field is empty");
            return "register";
        }
        userService.register(clientId);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam String clientId, Model model) {
        if (clientId == null || clientId.isEmpty()) {
            model.addAttribute("error", "The username field is empty");
            return "redirect:/";
        }
        userService.update(clientId);
        return "redirect:/";
    }

    @PostMapping("/send")
    public String send(@RequestParam String messageText, Model model) {
        if (messageText == null || messageText.isEmpty()) {
            model.addAttribute("error", "The message field is empty");
            return "redirect:/";
        }
        messageService.send("Gerzson", messageText);
        return "redirect:/";
    }

}