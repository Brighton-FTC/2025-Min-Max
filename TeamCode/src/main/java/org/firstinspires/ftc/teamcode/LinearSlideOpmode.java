package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class LinearSlideOpmode extends OpMode {

    private GamepadEx gamepad;
    private LinearSlideComponent linearSlide;

    @Override
    public void init() {
        linearSlide = new LinearSlideComponent(hardwareMap, "linear_slide_motor");
        gamepad = new GamepadEx(gamepad1);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
    }

    @Override
    public void loop() {
        gamepad.readButtons();

        if (gamepad.wasJustPressed(GamepadKeys.Button.DPAD_UP)) {
            linearSlide.up();
        } else if (gamepad.wasJustPressed(GamepadKeys.Button.DPAD_DOWN)) {
            linearSlide.down();
        }

        linearSlide.run();

        telemetry.addData("Position", linearSlide.getMotor().getCurrentPosition());
        telemetry.addData("Set point", linearSlide.getSetPoint());
        telemetry.addData("At Set-Point", linearSlide.atSetPoint());
    }
}
