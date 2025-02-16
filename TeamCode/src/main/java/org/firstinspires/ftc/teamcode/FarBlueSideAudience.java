package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Far Blue Auto", group = "Autonomous")
public class FarBlueSideAudience extends Autonomous {
    @Override
    public void runOpMode() {
        initialPose = new Pose2d(0, 56, 0);
        basketPose = new Pose2d(22, 0, -90);
        parkPose = new Pose2d(50, 60, 0);
        tangent = -90;
        super.runOpMode();
    }
}

