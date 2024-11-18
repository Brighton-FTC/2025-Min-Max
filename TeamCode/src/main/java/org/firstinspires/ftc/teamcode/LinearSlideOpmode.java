package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class LinearSlideOpmode extends OpMode {


    private Motor slideMotor;
    private GamepadEx gamePad;

    @Override
    public void init() {
        slideMotor = new Motor(hardwareMap, "slide_motor");
        gamePad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        slideMotor.set(gamePad.getLeftY());


    }
}
