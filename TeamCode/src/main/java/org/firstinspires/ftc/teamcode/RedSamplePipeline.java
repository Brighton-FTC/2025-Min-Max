package org.firstinspires.ftc.teamcode;

import org.opencv.core.Scalar;

public class RedSamplePipeline extends SamplePipeline {
    public static final Scalar LOWER = new Scalar(140, 100, 160);
    public static final Scalar UPPER = new Scalar(210, 225, 240);

    public RedSamplePipeline() {
        super(LOWER, UPPER);
    }
}
