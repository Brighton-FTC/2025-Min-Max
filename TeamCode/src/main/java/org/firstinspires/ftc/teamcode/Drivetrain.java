package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp(name = "Drivetrain", group = "teleop")
public class Drivetrain extends OpMode {
    public static double THRESHOLD = 0.1;
    private boolean isFieldCentric = true;
    private MecanumDrive drive;
    private GamepadEx gamepad;
    private IMU imu;
    private PIDController controller = new PController(-0.025, 0, 0);

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
                        RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                        RevHubOrientationOnRobot.UsbFacingDirection.LEFT
                )
        ));

        imu.resetYaw();
    }

    @Override
    public void loop() {
        gamepad.readButtons();

        double yaw = imu.getRobotYawPitchRollAngles().getYaw();

        if (gamepad.wasJustPressed(PSButtons.TRIANGLE)) {
            isFieldCentric = !isFieldCentric;
        }

        if (Math.abs(gamepad.getRightX()) > THRESHOLD) {
            if (isFieldCentric) {
                drive.driveFieldCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX(), yaw, true);
            } else {
                drive.driveRobotCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX(), true);
            }
            controller.setSetPoint(yaw);
        } else {
            if (isFieldCentric) {
                drive.driveFieldCentric(gamepad.getLeftX(), gamepad.getLeftY(), controller.calculate(yaw), yaw, true);
            } else {
                drive.driveRobotCentric(gamepad.getLeftX(), gamepad.getLeftY(), controller.calculate(yaw), true);
            }
        }
    }
}
