package frc.lib.networktables;

import edu.wpi.first.networktables.NetworkTableEntry;

public class NTButton {
    private final NetworkTableEntry entry;
    private boolean lastState = false;

    public NTButton(NetworkTableEntry entry) {
        this.entry = entry;
    }

    public boolean wasJustPressed() {
        boolean current = entry.getBoolean(false);
        boolean result = current && !lastState;
        lastState = current;
        return result;
    }
}

