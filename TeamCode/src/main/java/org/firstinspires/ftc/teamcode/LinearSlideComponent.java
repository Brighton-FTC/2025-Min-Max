package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlideComponent {
    private Motor motor;

    public LinearSlideComponent(HardwareMap hardwareMap, String motorid) {
        motor = new Motor(hardwareMap, motorid);

    }

    public void forward() {
        motor.set(1);
    }

    public void backward() {
        motor.set(-1);
    }

    public void run(double power) {
        motor.set(power);


    }


}
