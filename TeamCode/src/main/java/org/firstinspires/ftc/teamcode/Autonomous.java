package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;


@Config
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public class Autonomous extends LinearOpMode {
    protected Pose2d initialPose;
    protected Pose2d FarBlueSidePose = new Pose2d(0, 56, 0);
    protected Pose2d BlueSidePose = new Pose2d(28, 56, 0);
    protected Pose2d FarRedSidePose = new Pose2d(5, -52, 0);
    protected Pose2d RedSidePose = new Pose2d(-34, -52, 0);


    @Override
    public void runOpMode(){
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        Action startFromFarBlue = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(50,60), 0)
                .splineToSplineHeading(new Pose2d(22,0,-90), -90).build();

        Action startFromBlue = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(50,60), 0)
                .splineToSplineHeading(new Pose2d(22,0,-90), -90).build();

        Action startFromFarRed = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(-52,-52), 0)
                .splineToSplineHeading(new Pose2d(-22,0,-90), 90).build();

        Action startFromRed = drive.actionBuilder(new Pose2d(-34, -52, 0))
                .splineTo(new Vector2d(-52,-52), 0)
                .splineToSplineHeading(new Pose2d(-22,0,-90), 90).build();


        waitForStart();

        Action trajectoryActionChosen = null;
        if (initialPose == FarBlueSidePose){
            trajectoryActionChosen = startFromFarBlue;
        } else if (initialPose == BlueSidePose){
            trajectoryActionChosen = startFromBlue;
        } else if (initialPose == FarRedSidePose) {
            trajectoryActionChosen = startFromFarRed;
        } else if (initialPose == RedSidePose) {
            trajectoryActionChosen = startFromRed;
        }

        if (trajectoryActionChosen != null) {
            trajectoryActionChosen.run(new TelemetryPacket());
        }

    }
}