package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.IntakeRotator.DOWN_POSITION;
import static org.firstinspires.ftc.teamcode.IntakeRotator.UP_POSITION;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeRotatorComponent {
    private ServoEx servo;
    public static final int DOWN_POSITION = 0;
    public static final int UP_POSITION = 90;
    private GamepadEx gamepadEx;

    public IntakeRotatorComponent(HardwareMap hardwareMap, String servoId) {
        servo = new SimpleServo(hardwareMap, servoId, DOWN_POSITION, UP_POSITION);
    }

    public void up() {
        servo.turnToAngle(UP_POSITION);
    }

    public void down() {
        servo.turnToAngle((DOWN_POSITION));
    }
}
