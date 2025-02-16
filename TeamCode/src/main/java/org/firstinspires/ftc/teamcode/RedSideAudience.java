package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Auto", group = "Autonomous")
public class RedSideAudience extends Autonomous {
    @Override
    public void runOpMode() {
        initialPose = new Pose2d(-34, -52, 0);
        basketPose = new Pose2d(-22, 0, -90);
        parkPose = new Pose2d(-52, -52, 0);
        tangent = 90;
        super.runOpMode();
    }
}

