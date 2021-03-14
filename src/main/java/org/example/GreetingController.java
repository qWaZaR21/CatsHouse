package org.example;

import org.example.config.db.services.MessageService;
import org.example.config.db.services.impl.MessageServiceImpl;
import org.example.domain.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class GreetingController {
    private final MessageService messageService;

    public GreetingController() {
        this.messageService = new MessageServiceImpl();
    }

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model) throws SQLException {
        Iterable<Message> messages = messageService.getAll();

        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String tag, @RequestParam String text, Model model) throws SQLException {
        Message message = new Message(tag, text);

        messageService.insert(message);

        Iterable<Message> messages = messageService.getAll();

        model.addAttribute("messages", messages);

        return "main";
    }
}
