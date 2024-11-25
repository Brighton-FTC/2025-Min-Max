package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@Config
@TeleOp
public class ArmOpmode extends OpMode {
    public static int ARM_UP_POSITION = 100;
    public static int ARM_DOWN_POSITION = 100;
    private Motor armMotor;
    private int setPoint = 0;
    private PIDController controller = new PIDController(kP, kI, kD);
    private GamepadEx gamepad;
    private boolean armDown = false;
    public static int kP;
    public static int kI;
    public static int kD;

    @Override
    public void init() {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        armMotor = new Motor(hardwareMap, "arm_motor");
        gamepad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        controller.setPID(kP, kI, kD);
        gamepad.readButtons();
        if (gamepad.wasJustPressed(PSButtons.CIRCLE)) {
            if (armDown) {
                setPoint = ARM_DOWN_POSITION;
            } else {
                setPoint = ARM_UP_POSITION;
            }
            armMotor.set(controller.calculate(setPoint - armMotor.get()));
            
            telemetry.addData("set point", setPoint);
            telemetry.addData("position", armMotor.getCurrentPosition());
        }
    }
}
