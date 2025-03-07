package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class GrabberComponent {
    public static final double TURN_AMOUNT = 0.5;

    private final ServoEx leftClaw;
    private final ServoEx rightClaw;


    public GrabberComponent(HardwareMap hardwareMap, String leftId, String rightId) {
        leftClaw = new SimpleServo(hardwareMap, leftId, 0, 360);
        rightClaw = new SimpleServo(hardwareMap, rightId, 0, 360);

        leftClaw.setInverted(true);
    }

    public void grab() {
        leftClaw.setPosition(0);
        rightClaw.setPosition(0);

    }

    public void reset() {
        leftClaw.setPosition(TURN_AMOUNT);
        rightClaw.setPosition(TURN_AMOUNT);

    }

    public void toggle() {
        if (leftClaw.getPosition() == 0) {
            reset();
        } else {
            grab();
        }
    }

    public boolean isClosed() {
        return leftClaw.getPosition() == 0;
    }
}
