package md.scripcenco.service;

import md.scripcenco.controller.command.ChangeStateCommand;
import md.scripcenco.dto.MovementDto;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;
import org.springframework.stereotype.Service;

import java.util.EnumMap;

import static java.util.Arrays.stream;

@Service
public class HandServiceImpl implements HandService {

    private static final EnumMap<Finger, Action> FINGER_STATE;

    static {
        FINGER_STATE = new EnumMap<>(Finger.class);
    }

    @Override
    public MovementDto getInformation() {

        return new MovementDto(
                stream(Action.values()).toList(),
                stream(Finger.values()).toList()
        );
    }

    @Override
    public EnumMap<Finger, Action> getCurrentState() {
        return FINGER_STATE.clone();
    }

    @Override
    public void submitState(ChangeStateCommand changeStateCommand) {
        // TODO переписать состояние руки, веб-Сокет

        FINGER_STATE.putAll(changeStateCommand.getFingerStates());
    }
}
