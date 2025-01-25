package com.example.trajectories;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true"); // improve performance

        MeepMeep meepMeep = new MeepMeep(800);


        RoadRunnerBotEntity myBot1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 1)
                .build();
        RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        RoadRunnerBotEntity myBot3 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        RoadRunnerBotEntity myBot4 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot1.runAction(myBot1.getDrive().actionBuilder(new Pose2d(0, 25, 0))
                .splineTo(new Vector2d(56, 56), 0)
                        .splineToSplineHeading(new Pose2d(0, 25, 0),0)
                        .build());
        myBot2.runAction(myBot2.getDrive().actionBuilder(new Pose2d(0, 25, 0))
                .splineTo(new Vector2d(-56, 56), 0)
                .splineToSplineHeading(new Pose2d(0, 25, 0),0)
                .build());
        myBot3.runAction(myBot3.getDrive().actionBuilder(new Pose2d(0, -25, 0))
                .splineTo(new Vector2d(-56, -56), 0)
                .splineToSplineHeading(new Pose2d(0, -25, 0),0)
                .build());
        myBot4.runAction(myBot4.getDrive().actionBuilder(new Pose2d(0, -25, 0))
                .splineTo(new Vector2d(56, -56), 0)
                .splineToSplineHeading(new Pose2d(0, -25, 0),0)
                .build());




        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot1)
                .addEntity(myBot2)
                .addEntity(myBot3)
                .addEntity(myBot4)
                .start();
    }
}
