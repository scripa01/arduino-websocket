package md.scripcenco.template;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import md.scripcenco.model.Action;
import md.scripcenco.temp.HandTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TemplateState {

    private static final List<HandTemplate> TEMPLATES = new ArrayList<>(3);

    static {
        TEMPLATES.add(HandTemplate.builder()
                .thumb(Action.SQUEEZE)
                .index(Action.SQUEEZE)
                .middle(Action.UNCLENCH)
                .ring(Action.SQUEEZE)
                .pinky(Action.SQUEEZE)
                .build());

        TEMPLATES.add(HandTemplate.builder()
                .thumb(Action.SQUEEZE)
                .index(Action.SQUEEZE)
                .middle(Action.UNCLENCH)
                .ring(Action.SQUEEZE)
                .pinky(Action.SQUEEZE)
                .build());

        TEMPLATES.add(HandTemplate.builder()
                .thumb(Action.SQUEEZE)
                .index(Action.SQUEEZE)
                .middle(Action.UNCLENCH)
                .ring(Action.SQUEEZE)
                .pinky(Action.SQUEEZE)
                .build());
    }

    public static List<HandTemplate> findAll() {
        return Collections.unmodifiableList(TEMPLATES);
    }

    public static void add(HandTemplate template) {
        TEMPLATES.add(template);
    }

    public static HandTemplate nextTemplate() {
        int lastTemplateIndex = -1;
        for (int i = 0; i < TEMPLATES.size(); i++) {
            HandTemplate lastProcessingCommand = UnProcessingCommands.getLastProcessingCommand();
            if (lastProcessingCommand.equals(TEMPLATES.get(i))) {
                lastTemplateIndex = i;
            }
        }

        if (lastTemplateIndex == TEMPLATES.size() - 1)
            return TEMPLATES.get(0);
        else
            return TEMPLATES.get(lastTemplateIndex + 1);
    }
}
