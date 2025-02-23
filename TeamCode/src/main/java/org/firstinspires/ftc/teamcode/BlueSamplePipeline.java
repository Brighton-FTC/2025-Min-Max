package org.firstinspires.ftc.teamcode;

import org.opencv.core.Scalar;

public class BlueSamplePipeline extends SamplePipeline {
    public static final Scalar LOWER = new Scalar(110, 155, 110);
    public static final Scalar UPPER = new Scalar(150, 240, 250);

    public BlueSamplePipeline() {
        super(LOWER, UPPER);
    }
}
