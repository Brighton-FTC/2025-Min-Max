package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;

@TeleOp
public class RedTrajectoriesTeleop extends TrajectoriesTeleop {
    protected Pose2d centerpose = new Pose2d(0, -25, 0);
    protected Pose2d basketpose = new Pose2d(-56, -56, 0);

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        Action centerToBasket = drive.actionBuilder(centerpose)
                .splineToSplineHeading(basketpose, 0).build();

        Action basketToCenter = drive.actionBuilder(basketpose)
                .splineToSplineHeading((centerpose), 0).build();

        GamepadEx gamepad = new GamepadEx(gamepad1);

        waitForStart();

        boolean isAtCenter = true;

        while(!isStopRequested()) {
            gamepad.readButtons();
            if (gamepad.wasJustPressed(PSButtons.CIRCLE) && isAtCenter) {
                Actions.runBlocking(centerToBasket);
                isAtCenter = false;
            }
            if(gamepad.wasJustPressed(PSButtons.CIRCLE) && !isAtCenter){
                Actions .runBlocking(basketToCenter);
                isAtCenter = true;
            }
            sleep(20);
        }
    }
}
