package org.firstinspires.ftc.teamcode;

import org.opencv.core.Scalar;

public class YellowSamplePipeline extends SamplePipeline {
    public static final Scalar LOWER = new Scalar(10, 110, 140);
    public static final Scalar UPPER = new Scalar(45, 225, 225);

    public YellowSamplePipeline() {
        super(LOWER, UPPER);
    }
}
