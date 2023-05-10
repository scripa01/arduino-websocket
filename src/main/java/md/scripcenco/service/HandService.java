package md.scripcenco.service;

import md.scripcenco.controller.command.ChangeStateCommand;
import md.scripcenco.dto.MovementDto;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.EnumMap;
import java.util.List;

public interface HandService {

    MovementDto getInformation();

    EnumMap<Finger, Action> getCurrentState();

    void submitState(ChangeStateCommand changeStateCommand);
}
