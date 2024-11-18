package org.firstinspires.ftc.teamcode.opmode.test;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp
public class ArmOpmode extends OpMode {
    public static final int ARM_UP_POSITION = 100;
    public static final int ARM_DOWN_POSITION = 100;
    private Motor armMotor;
    private int setPoint = 0;
    private PIDController controller = new PIDController(0, 0, 0);
    private GamepadEx gamepad;
    private boolean armDown = false;

    @Override
    public void init() {
        armMotor = new Motor(hardwareMap, "arm_motor");
        gamepad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        gamepad.readButtons();
        if (gamepad.wasJustPressed(PSButtons.CIRCLE)) {
            if (armDown) {
                setPoint = ARM_DOWN_POSITION;
            } else {
                setPoint = ARM_UP_POSITION;
            }
            armMotor.set(controller.calculate(setPoint - armMotor.get()));
        }
    }
}
