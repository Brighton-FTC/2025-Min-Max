package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp
public class OuttakeTester extends OpMode {
    private OuttakeComponent outtake; // Manages the outtake mechanism
    private GamepadEx gamepad;        // Enhanced gamepad handler

    @Override
    public void init() {
        outtake = new OuttakeComponent(hardwareMap, "outtake_servo");
        gamepad = new GamepadEx(gamepad1);
        outtake.reset();
    }

    @Override
    public void loop() {
        // Check if button A is pressed to lift
        if (gamepad.getButton(GamepadKeys.Button.A)) {
            outtake.lift();
            telemetry.addData("Outtake Status", "Lifted");
        }

        // Check if button B is pressed to reset
        if (gamepad.getButton(GamepadKeys.Button.B)) {
            outtake.reset();
            telemetry.addData("Outtake Status", "Reset");
        }

        // Continuously update telemetry for debugging
        telemetry.addData("Component Active", outtake.isComponentActivated());
        telemetry.update();
    }
}
