package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp

public class IntakeRotator extends OpMode {
    private ServoEx servo;
    public static final int DOWN_POSITION = 0;
    public static final int UP_POSITION = 90;
    private GamepadEx gamepadEx;

    @Override
    public void init() {
        servo = new SimpleServo(hardwareMap, "servo", DOWN_POSITION, UP_POSITION);
        gamepadEx = new GamepadEx(gamepad2);
    }

    @Override
    public void loop() {
        gamepadEx.readButtons();
        if (gamepadEx.wasJustPressed(PSButtons.CIRCLE)) {
            if (servo.getAngle() == DOWN_POSITION) {
                servo.turnToAngle(UP_POSITION);
            } else {
                servo.turnToAngle(DOWN_POSITION);
            }
        }
    }
}
