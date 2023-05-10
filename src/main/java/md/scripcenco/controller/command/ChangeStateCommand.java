package md.scripcenco.controller.command;

import lombok.Data;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Data
public class ChangeStateCommand {

    private Map<Finger, Action> fingerStates = new HashMap<>();

}
