package md.scripcenco.service;

import md.scripcenco.controller.command.ChangeFingerStateCommand;
import md.scripcenco.dto.MovementDto;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.Map;

public interface HandService {

    MovementDto getInformation();

    Map<Finger, Action> getCurrentState();

    void submitState(ChangeFingerStateCommand changeStateCommand);
}
