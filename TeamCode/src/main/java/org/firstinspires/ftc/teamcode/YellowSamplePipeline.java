package org.firstinspires.ftc.teamcode;

import org.opencv.core.Scalar;

public class YellowSamplePipeline extends SamplePipeline {
    public static final Scalar LOWER = new Scalar(10, 100, 110);
    public static final Scalar UPPER = new Scalar(45, 255, 255);

    public YellowSamplePipeline() {
        super(LOWER, UPPER);
    }
}
