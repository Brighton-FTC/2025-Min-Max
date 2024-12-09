package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

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
    private IntakeRotatorComponent intakeRotator;

    @Override
    public void init() {
        gamepadEx = new GamepadEx(gamepad2);
        intakeRotator = new IntakeRotatorComponent(hardwareMap, "intake_rotator_servo");
    }

    @Override
    public void loop() {
        gamepadEx.readButtons();

        if (gamepadEx.wasJustPressed(PSButtons.CIRCLE)) {
            intakeRotator.up();
        }
        if(gamepadEx.wasJustPressed(PSButtons.SQUARE)) {
            intakeRotator.down();
        }
    }
}
