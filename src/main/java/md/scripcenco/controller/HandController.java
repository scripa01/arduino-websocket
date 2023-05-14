package md.scripcenco.controller;

import lombok.RequiredArgsConstructor;
import md.scripcenco.controller.command.ChangeFingerStateCommand;
import md.scripcenco.service.HandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/main"})
@RequiredArgsConstructor
class HandController {

    private final HandService handService;

    @GetMapping
    public ModelAndView handForm() {
        return new ModelAndView("hand")
                .addObject("fingers", handService.getInformation())
                .addObject("changeFingerStateCommand", new ChangeFingerStateCommand());
    }

    @PostMapping
    public ModelAndView submit(@ModelAttribute("state") ChangeFingerStateCommand changeStateCommand) {
        return new ModelAndView("hand");
    }
}
