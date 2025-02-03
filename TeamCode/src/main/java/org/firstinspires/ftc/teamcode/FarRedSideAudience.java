package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class FarRedSideAudience extends Autonomous{

    //initialise Pose
    protected Pose2d initialPose = new Pose2d(5, -52, 0);
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);


    //outtake instance
    Autonomous.OuttakeComponent outtake = new Autonomous.OuttakeComponent(hardwareMap, "outtake_servo");

    //slide instance
    Autonomous.LinearSlideComponent linearSlide = new Autonomous.LinearSlideComponent(hardwareMap, "linear_slide_motor");

    TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
            .splineTo(new Vector2d(-52,-52), 0)
            .splineToSplineHeading(new Pose2d(-22,0,-90), 90);
}
