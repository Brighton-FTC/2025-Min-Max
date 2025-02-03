package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp
public class Teleop extends OpMode {

    private OuttakeComponent outtake;
    private MecanumDrive drive;
    private GamepadEx gamepad;
    private IMU imu;
    private OuttakeComponent outtake;

    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);
        outtake = new OuttakeComponent(hardwareMap, "outtake_servo");

        Motor[] motors = {
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_right_drive"),
                new Motor(hardwareMap, "back_left_drive"),
                new Motor(hardwareMap, "back_right_drive")
        };
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

        outtake = new OuttakeComponent(hardwareMap, "outtake_servo");
    }

    @Override
    public void loop() {
        gamepad.readButtons();

        drive.driveFieldCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX(), imu.getRobotYawPitchRollAngles().getYaw(), true);
        if (gamepad.wasJustPressed(PSButtons.SQUARE)){
            outtake.backward();
        }
    }

}