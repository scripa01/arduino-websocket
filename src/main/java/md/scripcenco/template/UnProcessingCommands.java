package md.scripcenco.template;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import md.scripcenco.temp.HandTemplate;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UnProcessingCommands {

    private static final Queue<HandTemplate> UN_PROCESSING_COMMANDS = new ArrayDeque<>();
    private static HandTemplate LAST_PROCESSING_COMMAND = TemplateState.findAll().get(0);

    public static Optional<HandTemplate> poll() {
        LAST_PROCESSING_COMMAND = UN_PROCESSING_COMMANDS.poll();
        return Optional.ofNullable(LAST_PROCESSING_COMMAND);
    }

    public static void add(HandTemplate state) {
        UN_PROCESSING_COMMANDS.add(state);
    }

    public static HandTemplate getLastProcessingCommand() {
        return LAST_PROCESSING_COMMAND;
    }
}
