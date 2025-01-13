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


        RoadRunnerBotEntity Bot1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        RoadRunnerBotEntity Bot2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        RoadRunnerBotEntity Bot3 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        RoadRunnerBotEntity Bot4 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();


        Bot1.runAction(Bot1.getDrive().actionBuilder(new Pose2d(0, 56, 0))
                .splineTo(new Vector2d(50,60), 0)
                .splineToSplineHeading(new Pose2d(0,30,-90), -90)
                        .build());

        Bot2.runAction(Bot2.getDrive().actionBuilder(new Pose2d(28, 56, 0))
                .splineTo(new Vector2d(50,60), 0)
                .splineToSplineHeading(new Pose2d(0,30,-90), -90)
                .build());
        Bot3.runAction(Bot3.getDrive().actionBuilder(new Pose2d(-34, -52, 0))
                .splineTo(new Vector2d(-52,-52), 0)
               .splineToSplineHeading(new Pose2d(0,-32,-90), -90)
                .build());
        Bot4.runAction(Bot4.getDrive().actionBuilder(new Pose2d(5, -52, 0))
                .splineTo(new Vector2d(-52,-52), 0)
                .splineToSplineHeading(new Pose2d(0,-32,-90), -90)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(Bot1)
                .addEntity(Bot2)
                .addEntity(Bot3)
                .addEntity(Bot4)
                .start();
    }
}
