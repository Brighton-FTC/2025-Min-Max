package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;


@TeleOp

public class IntakerOpmode extends OpMode {
    private Motor turnMotor;
    private GamepadEx gamePad;

    @Override
    public void init() {
        turnMotor = new Motor(hardwareMap, "turn_motor");
        gamePad = new GamepadEx(gamepad2);

    }

    @Override
    public void loop() {
        turnMotor.stopMotor();

        gamePad.readButtons();
        if (gamePad.wasJustPressed(PSButtons.CROSS)) {
            turnMotor.setTargetPosition(0);
        }
        if (gamePad.wasJustPressed(PSButtons.CIRCLE)) {
            turnMotor.setTargetPosition(1200);

        }


    }

}
