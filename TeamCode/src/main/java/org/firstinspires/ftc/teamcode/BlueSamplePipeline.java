package org.firstinspires.ftc.teamcode;

import org.opencv.core.Scalar;

public class BlueSamplePipeline extends SamplePipeline {
    public static final Scalar LOWER = new Scalar(0, 0, 0);
    public static final Scalar UPPER = new Scalar(255, 255, 255);

    public BlueSamplePipeline() {
        super(LOWER, UPPER);
    }
}
