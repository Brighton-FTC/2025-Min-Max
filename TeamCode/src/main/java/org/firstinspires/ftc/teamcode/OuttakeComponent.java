package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class OuttakeComponent {
    private final ServoEx servo;

    public boolean servoComponentActivated; // Lowercased to match Java conventions

    public OuttakeComponent(HardwareMap hardwareMap, String servoId) {
        servo = new SimpleServo(hardwareMap, servoId, 0, 360);
    }

    public void lower() {
            servo.rotateBy(-90);  // Rotate servo to vertical position
            servoComponentActivated = true; // Update state to activated

    }

    public void reset() {
            servo.rotateBy(90);  // Rotate servo back to horizontal position
            servoComponentActivated = false; // Update state to deactivated
    }

    public boolean isComponentActivated() {
        return servoComponentActivated; // Allow status checks
    }
}
