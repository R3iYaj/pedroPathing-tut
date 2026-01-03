package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            .forwardZeroPowerAcceleration(-36.2007)
            .lateralZeroPowerAcceleration(-96.5001)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.07, 0, 0.01, 0.025))
            .headingPIDFCoefficients(new PIDFCoefficients(0.85, 0, 0.02, 0.03))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.6, 0.0, 0.0001, 0.6, 0.025))
            .centripetalScaling(0.0005)
            .mass(10);

    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,
            100,
            1,
            1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .xVelocity(82.6200)
            .yVelocity(61.2488)
            .rightFrontMotorName("FrontRight")
            .rightRearMotorName("BackRight")
            .leftRearMotorName("BackLeft")
            .leftFrontMotorName("FrontLeft")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD);

    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            .forwardTicksToInches(.002993)
            .strafeTicksToInches(.0029976)
            .turnTicksToInches(.003050)
            .leftPodY(7)
            .rightPodY(-7)
            .strafePodX(-2.5)
            .leftEncoder_HardwareMapName("YLeftEncoder")
            .rightEncoder_HardwareMapName("YRightEncoder")
            .strafeEncoder_HardwareMapName("XEncoder")
            .leftEncoderDirection(Encoder.FORWARD)
            .rightEncoderDirection(Encoder.REVERSE)
            .strafeEncoderDirection(Encoder.REVERSE);
}
