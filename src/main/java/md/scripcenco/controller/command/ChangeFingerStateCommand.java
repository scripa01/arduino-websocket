package md.scripcenco.controller.command;

import lombok.Data;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.EnumMap;

@Data
public class ChangeFingerStateCommand {

    private EnumMap<Finger, Action> fingerStates = new EnumMap<>(Finger.class);

}
