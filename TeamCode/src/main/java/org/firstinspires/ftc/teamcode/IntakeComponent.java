package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp

public class IntakeComponent {
    private Motor motor;
    public IntakeComponent(HardwareMap hardwareMap, String motorid) {
        motor =  new Motor(hardwareMap, motorid);
    }

    public void forward(){
        motor.set(1);
    }

    public void backward(){
        motor.set(-1);
    }

    public void still(){
        motor.set(0);
    }
}
