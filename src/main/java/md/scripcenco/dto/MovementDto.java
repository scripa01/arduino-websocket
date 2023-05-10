package md.scripcenco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.List;

@Data
@AllArgsConstructor
public class MovementDto {
    List<Action> actions;
    List<Finger> fingers;

}
