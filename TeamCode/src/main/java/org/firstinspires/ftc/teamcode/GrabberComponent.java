package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class GrabberComponent {
    public static final double TURN_AMOUNT = 0.5;

    private final ServoEx leftClaw;
    private final ServoEx rightClaw;

    private boolean closed = true;

    public GrabberComponent(HardwareMap hardwareMap, String leftId, String rightId) {
        leftClaw = new SimpleServo(hardwareMap, leftId, 0, 360);
        rightClaw = new SimpleServo(hardwareMap, rightId, 0, 360);
    }

    public void grab() {
        leftClaw.rotateBy(-TURN_AMOUNT);
        rightClaw.rotateBy(TURN_AMOUNT);
        closed = true;

    }

    public void reset() {
        leftClaw.rotateBy(TURN_AMOUNT);
        rightClaw.rotateBy(-TURN_AMOUNT);
        closed = false;

    }

    public void toggle() {
        if (closed) {
            reset();
        } else {
            grab();
        }
    }

    public boolean isClosed() {
        return closed;
    }
}
