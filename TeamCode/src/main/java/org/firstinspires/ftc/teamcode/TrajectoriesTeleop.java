package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class TrajectoriesTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        Action centerToBasket = drive.actionBuilder(new Pose2d(0, 25, 0))
                .splineToSplineHeading(new Pose2d(56, 56, 0), 0).build();

        Action basketToCenter = drive.actionBuilder(new Pose2d(56, 56, 0))
                .splineToSplineHeading(new Pose2d(0, 25, 0), 0).build();

        waitForStart();

        while(!isStopRequested()) {
            Actions.runBlocking(centerToBasket);
            Actions.runBlocking(basketToCenter);
        }
    }
}
