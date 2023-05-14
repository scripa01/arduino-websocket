package md.scripcenco.service;

import md.scripcenco.controller.command.ChangeFingerStateCommand;
import md.scripcenco.dto.MovementDto;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;
import md.scripcenco.state.HandState;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Arrays.stream;

@Service
class HandServiceImpl implements HandService {

    @Override
    public MovementDto getInformation() {
        return new MovementDto(
                stream(Action.values()).toList(),
                stream(Finger.values()).toList()
        );
    }

    @Override
    public Map<Finger, Action> getCurrentState() {
        return HandState.getState();
    }

    @Override
    public void submitState(ChangeFingerStateCommand changeStateCommand) {
        HandState.update(changeStateCommand.getFingerStates());
    }
}
