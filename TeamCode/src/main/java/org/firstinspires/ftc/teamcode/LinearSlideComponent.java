package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlideComponent {
    private Motor slideMotor;
    public LinearSlideComponent(HardwareMap hardwareMap, String motorid){
        slideMotor = new Motor(hardwareMap, motorid);

    }

    public void run(double power){
        slideMotor.set(power);


    }



}
