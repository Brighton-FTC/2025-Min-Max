package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@TeleOp
public class PreprogrammedAutoTuner extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        Motor[] motors = {
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_right_drive"),
                new Motor(hardwareMap, "back_left_drive"),
                new Motor(hardwareMap, "back_right_drive")
        };
        motors[3].setInverted(true);
        MecanumDrive drive = new MecanumDrive(motors[0], motors[1], motors[2], motors[3]);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("instructions.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        while (!isStopRequested()) {
            drive.driveRobotCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX(), true);
            writer.println(String.format("{%f, %f, %f},", gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX()));
            sleep(50);
        }

        writer.close();
    }
}
