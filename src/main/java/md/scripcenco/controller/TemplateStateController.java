package md.scripcenco.controller;

import md.scripcenco.temp.HandTemplate;
import md.scripcenco.template.TemplateState;
import md.scripcenco.template.UnProcessingCommands;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/template")
class TemplateStateController {

    @GetMapping
    public ResponseEntity<HandTemplate> next() {
        Optional<HandTemplate> handState = UnProcessingCommands.poll();
        if (handState.isPresent())
            return ResponseEntity.ok(handState.get());
        throw new RuntimeException();
    }

    @PostMapping("/next")
    public ResponseEntity<Void> triggerNextTemplate() {
        UnProcessingCommands.add(TemplateState.nextTemplate());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/current")
    public ResponseEntity<Void> triggerCurrentTemplate() {
        UnProcessingCommands.add(UnProcessingCommands.getLastProcessingCommand());
        return ResponseEntity.ok().build();
    }
}
