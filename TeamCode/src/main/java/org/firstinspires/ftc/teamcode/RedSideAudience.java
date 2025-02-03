package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class RedSideAudience extends Autonomous{

    //initialise Pose
    protected Pose2d RedSidePose = new Pose2d(-34, -52, 0);

    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

}
