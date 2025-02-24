package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.util.roadrunner.MecanumDrive;


@Config
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public abstract class Autonomous extends LinearOpMode {
    protected Pose2d initialPose;
    protected Pose2d basketPose;
    protected Pose2d parkPose;
    protected MecanumDrive drive;
    public int tangent;

    private Motor slideMotor;

    private PIDController controller = new PIDController(0, 0, 0);
    public static double kP = 0, kI = 0, kD = 0;

    public static double UP_POSITION = 100;
    public static double DOWN_POSITION = 0;

    private final ServoEx servo;

    private boolean componentActivated = false; // Lowercased to match Java conventions

    public OuttakeComponent(HardwareMap hardwareMap, String servoId) {
        servo = new SimpleServo(hardwareMap, servoId, 0, 360);
    }

    public void deposit() {
        if (!componentActivated) {
            servo.rotateBy(-180);  // Rotate servo to vertical position
            componentActivated = true; // Update state to activated
        }
    }

    public void reset() {
        if (componentActivated) {
            servo.rotateBy(180);  // Rotate servo back to horizontal position
            componentActivated = false; // Update state to deactivated
        }
    }

    public boolean isComponentActivated() {
        return componentActivated; // Allow status checks
    }

    public LinearSlideComponent(HardwareMap hardwareMap, String motorId){
        slideMotor = new Motor(hardwareMap, motorId);
        slideMotor.resetEncoder();
        slideMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        slideMotor.setRunMode(Motor.RunMode.VelocityControl);
    }

    /**
     * Make sure to call every tick.
     */
    public void run() {
        controller.setPID(kP, kI, kD);
        slideMotor.set(controller.calculate(slideMotor.getCurrentPosition()));
    }

    public void up() {
        controller.setSetPoint(UP_POSITION);
    }

    public void down() {
        controller.setSetPoint(DOWN_POSITION);
    }

    public boolean atSetPoint() {
            return controller.atSetPoint();
    }

    public Motor getMotor() {
        return slideMotor;
    }



    @Override
    public void runOpMode() {
        drive = new MecanumDrive(hardwareMap, initialPose);

        Action autonomousAction = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(parkPose.position.x, parkPose.position.y), parkPose.heading)
                .splineToSplineHeading(new Pose2d(basketPose.position.x,basketPose.position.y,-90), tangent)
                .build();

        waitForStart();

        if (opModeIsActive()) {
            Actions.runBlocking(autonomousAction);
            up();
            deposit();
            reset();

        }
    }
}
