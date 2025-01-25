package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class LinearSlideOpmode extends OpMode {

    private GamepadEx gamePad;
    private LinearSlideComponent linearSlide;

    @Override
    public void init() {
        linearSlide = new LinearSlideComponent(hardwareMap, "linear_slide_motor");
        gamePad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        linearSlide.run(gamePad.getLeftY());


    }
}
