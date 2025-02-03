package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;


@Config
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public class Autonomous extends LinearOpMode {
    protected Pose2d startpose;

    //Define Outtake Component
    @TeleOp
    public static class OuttakeComponent {
        private final ServoEx servo;
        private boolean componentActivated = false; // Lowercased to match Java conventions

        public OuttakeComponent(HardwareMap hardwareMap, String servoId) {
            servo = new SimpleServo(hardwareMap, servoId, 0, 360);
        }

        public void lift() {
            if (!componentActivated) {
                servo.rotateBy(-90);  // Rotate servo to vertical position
                componentActivated = true; // Update state to activated
            }
        }

        public void reset() {
            if (componentActivated) {
                servo.rotateBy(90);  // Rotate servo back to horizontal position
                componentActivated = false; // Update state to deactivated
            }
        }

        public boolean isComponentActivated() {
            return componentActivated; // Allow status checks
        }
    }

    //Outtake Comp Usage
    @TeleOp
    public class OuttakeTester extends OpMode {
        private org.firstinspires.ftc.teamcode.OuttakeComponent outtake; // Manages the outtake mechanism
        private GamepadEx gamepad;        // Enhanced gamepad handler

        @Override
        public void init() {
            outtake = new org.firstinspires.ftc.teamcode.OuttakeComponent(hardwareMap, "outtake_servo");
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

    //Define Linear Slide Component.
    public class LinearSlideComponent {
        private Motor slideMotor;
        public LinearSlideComponent(HardwareMap hardwareMap, String motorid){
            slideMotor = new Motor(hardwareMap, motorid);

        }

        public void run(double power){
            slideMotor.set(power);

        }
    }
    //Linear slide usage
    @TeleOp
    public class LinearSlideOpmode extends OpMode {

        private GamepadEx gamePad;
        private LinearSlideComponent linearSlide;

        @Override
        public void init() {
            linearSlide = new LinearSlideComponent(hardwareMap, "linear_slide_motor");
            gamePad = new GamepadEx(gamepad1);
        }

        @Override
        public void loop() {
            linearSlide.run(gamePad.getLeftY());
        }
    }

    @Override
    public void runOpMode(){


    }
}