package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class FarBlueSideAudience extends Autonomous{

    //initialise Pose
    protected Pose2d FarBlueSidePose = new Pose2d(0, 56, 0);
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

    TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
            .splineTo(new Vector2d(50,60), 0)
            .splineToSplineHeading(new Pose2d(22,0,-90), -90);
}
