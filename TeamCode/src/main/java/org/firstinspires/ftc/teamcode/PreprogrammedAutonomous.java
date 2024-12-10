package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class PreprogrammedAutonomous extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        double[][] instructions = { // fill in
                {0, 0, 0},
                {0, 0, 0}
        };

        Motor[] motors = {
                new Motor(hardwareMap, "front_left_drive"),
                new Motor(hardwareMap, "front_right_drive"),
                new Motor(hardwareMap, "back_left_drive"),
                new Motor(hardwareMap, "back_right_drive")
        };
        motors[3].setInverted(true);
        MecanumDrive drive = new MecanumDrive(motors[0], motors[1], motors[2], motors[3]);

        for (int i = 0; i < instructions.length && !isStopRequested(); ++i) {
            drive.driveRobotCentric(instructions[i][0], instructions[i][1], instructions[i][2], true);
            sleep(50);
        }
    }
}
