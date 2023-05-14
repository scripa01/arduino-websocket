package md.scripcenco.state;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import md.scripcenco.model.Action;
import md.scripcenco.model.Finger;

import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HandState {
    private static final EnumMap<Finger, Action> FINGER_STATE;

    static {
        FINGER_STATE = new EnumMap<>(Finger.class);
    }

    public static Map<Finger, Action> getState() {
        return FINGER_STATE.clone();
    }

    public static void update(Map<Finger, Action> newState) {
        FINGER_STATE.putAll(newState);
    }
}
