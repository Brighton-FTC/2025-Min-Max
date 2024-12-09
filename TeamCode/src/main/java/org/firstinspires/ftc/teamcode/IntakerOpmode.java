package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;


@TeleOp

public class IntakerOpmode extends OpMode {
    private IntakeComponent intake;
    private GamepadEx gamePad;

    @Override
    public void init() {
        gamePad = new GamepadEx(gamepad2);
        intake = new IntakeComponent(hardwareMap, "intake_motor");
    }

    @Override
    public void loop() {
        gamePad.readButtons();

        if (gamePad.wasJustPressed(PSButtons.CROSS)) {
            intake.forward();
        }

        if (gamePad.wasJustPressed(PSButtons.CIRCLE)) {
            intake.backward();
        }

        if (gamePad.wasJustPressed(PSButtons.TRIANGLE)){
            intake.still();
        }
    }

}