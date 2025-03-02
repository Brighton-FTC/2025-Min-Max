package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp(name = "Teleop (use this one", group = "competition")
public class Teleop extends OpMode {

    private MecanumDrive drive;
    private GamepadEx gamepad;
    private IMU imu;

    private GrabberComponent grabber;
    private LinearSlideComponent slide;

    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);

        Motor[] motors = {
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_right_drive"),
                new Motor(hardwareMap, "back_left_drive"),
                new Motor(hardwareMap, "back_right_drive")
        };

        motors[1].setInverted(true);
        motors[2].setInverted(true);
        motors[3].setInverted(true);

        drive = new MecanumDrive(motors[0], motors[1], motors[2], motors[3]);

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        ));

        imu.resetYaw();

        grabber = new GrabberComponent(hardwareMap, "left_claw_servo", "right_claw_servo");

        slide = new LinearSlideComponent(hardwareMap, "linear_slide_motor");
    }

    @Override
    public void loop() {
        gamepad.readButtons();

        drive.driveFieldCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX(), imu.getRobotYawPitchRollAngles().getYaw(), true);

        if (gamepad.wasJustPressed(PSButtons.SQUARE)){
            grabber.toggle();
        }

        if (gamepad.wasJustPressed(GamepadKeys.Button.DPAD_UP)) {
            slide.up();
        } else if (gamepad.wasJustPressed(GamepadKeys.Button.DPAD_DOWN)) {
            slide.down();
        }

        slide.run();


        telemetry.addData("Slide Position", slide.getMotor().getCurrentPosition());
        telemetry.addData("Slide Set point", slide.getSetPoint());
        telemetry.addData("Slide At Set-Point?", slide.atSetPoint());
        telemetry.addLine();

        telemetry.addData("Grabber Status", grabber.isClosed() ? "Closed" : "Opened");
    }
}