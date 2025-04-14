// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static String armPreset = "L2"; //L1, L2, L3, L4, coralstation, 

  public static class DriverConstants {
    public static final int MAIN_DRIVER_PORT = 0;
    public static final int AUX_DRIVER_PORT = 1;
    public static final int DRIVER_STATION_PORT = 2;
    // public static final String DEADBAND = "0.5";
    public static final double DEADBAND = 0;
    public static final double MAX_SPEED = Units.feetToMeters(9); //4.5
    public static final int[] driverstationButtons = { 14, 20, 30, 40 }; // 0 = top left, and then read it like a book
  }

  public static class CandleConstants {
    public static final int CANDLE_ID = 57;
  }

  public static class WristConstants {
    public static final double WRIST_MOTOR_SPEED = 0.2;
    public static final double WRIST_POSITION_TWO = 5;
    public static final double WRIST_POSITION_ONE = 0;
  }

  public static class ShoulderConstants {
    public static final int SHOULDER_MOTOR_ID = 50;
    public static final int ABSOLUTE_ENCODER_CHANNEL = 1;

    public static final double SHOULDER_MOTOR_SPEED = 0.2;

    public static final double TOTAL_OFFSET = 4;

    public static final double L1_SETPOINT = -70 + TOTAL_OFFSET;
    public static final double L2_SETPOINT = -30 + TOTAL_OFFSET;
    public static final double L3_SETPOINT = 8 + TOTAL_OFFSET;
    public static final double L4_SETPOINT = 48 + TOTAL_OFFSET;

    public static final double CORAL_STATION_SETPOINT = 6; //4
    public static final double GROUND_SETPOINT = -70; // TODO
    public static final double GROUND_VERTICAL_SETPOINT = -170;
    public static final double UPPER_ALGAE_SETPOINT = 3.927; // TODO
    public static final double LOWER_ALGAE_SETPOINT = -67.7; // TODO
  }

  public static class IntakeConstants {
    public static final double INTAKE_MOTOR_SPEED = 1;
    public static final double INTAKE_OUT_MOTOR_SPEED = 0.7;
    public static final double INTAKE_OUT_MOTOR_SLOW_SPEED = 0.3;
    public static final double DISTANCE_FROM_PIECE = 1; // This value is in inches
    public static final double INTAKE_PULSE_INTERVAL = 2.5; // This value is in seconds
    public static final double INTAKE_PULSE_LENGTH = 0; // This value is in seconds
  }

  public static class ActuatorConstants {
    public static final int length = 100; // Servo Length
  }

  public static class ElevatorConstants {
    public static final int ELEVATOR_MOTOR_ID = 51;
    public static final int ELEVATOR_LIMITSWITCH_CHANNEL = 0;

    public static final double ELEVATOR_MOTOR_SPEED = 0.2;
    public static final double ELEVATOR_LIMIT = 230;

    public static final double TOTAL_OFFSET = 0;

    public static final double SAFE_RESET_SETPOINT = 5;
    public static final double L1_SETPOINT = 0 + TOTAL_OFFSET;
    public static final double L2_SETPOINT = 40 + TOTAL_OFFSET;
    public static final double L3_SETPOINT = 108.275 + TOTAL_OFFSET;
    public static final double L4_SETPOINT = 230 + TOTAL_OFFSET;
    public static final double CORAL_STATION_SETPOINT = 35 + TOTAL_OFFSET; //32
    public static final double GROUND_SETPOINT = 20.115; // TODO
    public static final double GROUND_VERTICAL_SETPOINT = 30;
    public static final double UPPER_ALGAE_SETPOINT = 90.941 + TOTAL_OFFSET; // TODO
    public static final double LOWER_ALGAE_SETPOINT = 22 + TOTAL_OFFSET; // TODO
  }

  public static final class LimelightConstants {
    /** upward angle of limelight camera [degrees] */
    public static final double LIMELIGHT_ANGLE = 3.0;
    /** distance from limelight lens from floor [inches] */
    public static final double LIMELIGHT_HEIGHT = 18.5;
    /** distance from apriltag to floor(bottom of tag) [inches] */
    public static final double APRILTAG_HEIGHT = 14.25;
    /**
     * distance from apriltag to floor but its the double substation(bottom of tag)
     * [inches]
     */
    public static final double APRILTAG_DOUBLE_SUBSTATION_HEIGHT = 23.375;
  }

}