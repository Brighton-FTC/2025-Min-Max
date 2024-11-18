package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class LinearSlideOpmode extends OpMode {


    private Motor slideMotor;
    private GamepadEx gamepad;

    @Override
    public void init() {
        slideMotor = new Motor(hardwareMap, "slide_motor");
        gamepad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        slideMotor.set(gamepad.getLeftY());


    }
}
