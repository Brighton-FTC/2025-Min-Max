package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp
public class GrabberTester extends OpMode {
    private GrabberComponent leftClaw;
    private GrabberComponent rightClaw;
    private GrabberComponent servo;

    // Manages the outtake mechanism
    private GamepadEx gamepad;        // Enhanced gamepad handler

    @Override
    public void init() {
        leftClaw = new GrabberComponent(hardwareMap, "left_Claw");
        rightClaw = new GrabberComponent(hardwareMap, "right_Claw");
        servo = new GrabberComponent(hardwareMap, "grabber_servo");
        gamepad = new GamepadEx(gamepad1);
        servo.reset();

    }

    @Override
    public void loop() {
        // Check if button A is pressed to lift
        if (gamepad.getButton(PSButtons.SQUARE) && !servo.grabberComponentActivated) {
            servo.activateServo();
            leftClaw.grab();
            servo.resetServo();
            telemetry.addData("Grabber Status", "Lowered");
        }

        // Check if button B is pressed to reset
        if (gamepad.getButton(PSButtons.SQUARE) && servo.grabberComponentActivated) {
            servo.activateServo();
            rightClaw.reset();
            servo.resetServo();
            telemetry.addData("Grabber Status", "Reset");
        }

    }
}
