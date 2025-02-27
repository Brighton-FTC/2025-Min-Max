package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class GrabberComponent {
    private final ServoEx servo;
    private final ServoEx leftClaw;
    private final ServoEx rightClaw;

    public boolean grabberComponentActivated;
    public boolean servoComponentActivated;// Lowercased to match Java conventions

    public GrabberComponent(HardwareMap hardwareMap, String servoId) {
        leftClaw = new SimpleServo(hardwareMap, servoId, 225, 180);
        rightClaw = new SimpleServo(hardwareMap, servoId, 135, 180);
        servo = new SimpleServo(hardwareMap, servoId, 0, 360);
    }

    public void grab() {
        leftClaw.rotateBy(-45);
        rightClaw.rotateBy(45);
        grabberComponentActivated = true; // Update state to activated

    }

    public void reset() {
        leftClaw.rotateBy(45);
        rightClaw.rotateBy(-45);
        grabberComponentActivated = false; // Update state to activated

    }

    public void activateServo(){
        servo.rotateBy(180);
        servoComponentActivated = true;
    }

    public void resetServo(){
        servo.rotateBy(-180);
        servoComponentActivated = false;
    }

}
