package md.scripcenco.controller;

import md.scripcenco.controller.command.ChangeStateCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandController {
    @GetMapping
    public ModelAndView handForm() {
        return new ModelAndView("hand");
    }

    @PostMapping
    public ModelAndView submit(@ModelAttribute("state") ChangeStateCommand changeStateCommand) {
        return new ModelAndView("result");
    }
}
