package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class GrabberComponent {
    public static final int TURN_DEGREE = 90;

    private final ServoEx leftClaw;
    private final ServoEx rightClaw;

    private boolean closed;

    public GrabberComponent(HardwareMap hardwareMap, String leftId, String rightId) {
        leftClaw = new SimpleServo(hardwareMap, leftId, 0, 360);
        rightClaw = new SimpleServo(hardwareMap, rightId, 0, 360);
    }

    public void grab() {
        leftClaw.rotateBy(-TURN_DEGREE);
        rightClaw.rotateBy(TURN_DEGREE);
        closed = true;

    }

    public void reset() {
        leftClaw.rotateBy(TURN_DEGREE);
        rightClaw.rotateBy(-TURN_DEGREE);
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
