package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public abstract class Autonomous extends LinearOpMode {
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



}