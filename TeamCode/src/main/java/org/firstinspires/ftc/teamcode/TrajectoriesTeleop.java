package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

public class TrajectoriesTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        Action centerToBasket = drive.actionBuilder(new Pose2d(0, 25, 0))
                .splineToSplineHeading(new Pose2d(56, 56, 0), 0).build();

        Action basketToCenter = drive.actionBuilder(new Pose2d(56, 56, 0))
                .splineToSplineHeading(new Pose2d(0, 25, 0), 0).build();

        GamepadEx gamepad = new GamepadEx(gamepad1);

        waitForStart();

        boolean isAtCenter = true;

        while(!isStopRequested()) {
            gamepad.readButtons();
            if (gamepad.wasJustPressed(PSButtons.CIRCLE) && isAtCenter) {
                Actions.runBlocking(centerToBasket);
                isAtCenter = !isAtCenter;
            }
            if(gamepad.wasJustPressed(PSButtons.CIRCLE) && isAtCenter == false){
                Actions .runBlocking(basketToCenter);
                isAtCenter = !isAtCenter;
            }
            sleep(20);
        }
    }
}
