package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;


@Config
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public abstract class Autonomous extends LinearOpMode {
    protected Pose2d initialPose;
    protected Pose2d basketPose;
    protected Pose2d parkPose;
    protected MecanumDrive drive;
    public int tangent;




    @Override
    public void runOpMode() {
        drive = new MecanumDrive(hardwareMap, initialPose);

        Action autonomousAction = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(parkPose.position.x, parkPose.position.y), parkPose.heading)
                .splineToSplineHeading(new Pose2d(basketPose.position.x,basketPose.position.y,-90), tangent)
                .build();

        waitForStart();

        if (opModeIsActive()) {
            Actions.runBlocking(autonomousAction);
            up();
            deposit();
            reset();

        }
    }
}
