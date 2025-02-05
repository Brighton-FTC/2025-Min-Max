package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class FarRedSideAudience extends Autonomous{
    public FarRedSideAudience() {
        initialPose = FarRedSidePose;
    }

    //initialise Pose
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

}
