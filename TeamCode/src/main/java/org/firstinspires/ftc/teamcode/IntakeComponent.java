package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeComponent {
    private Motor intakeMotor;

    public IntakeComponent(HardwareMap hardwareMap, String motorId){
        intakeMotor = new Motor(hardwareMap, motorId);
    }

    public void forward() {
        intakeMotor.set(1);
    }

    public void backward() {
        intakeMotor.set(-1);
    }

    public void stop() {
        intakeMotor.set(0);
    }

}

