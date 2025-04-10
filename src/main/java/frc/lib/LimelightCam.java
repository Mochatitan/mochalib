// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableListener;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.HttpCamera;
import frc.lib.Config;

public class LimelightCam {

    private boolean flash = false;

    private double lockedApriltag = -1;
    private double lastSeenApriltag = -1;
    private final String namePrefix = "limelight";
    private String name = "default-name";
    private String fullname = "default_fullname";

    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable masterTable = inst.getTable("vision-table");
    NetworkTable cameraTable;

    public LimelightCam(String name) {
        this.name = name;
        this.fullname = namePrefix + "-" + name;
        HttpCamera httpCamera = new HttpCamera(name, getIP());

        cameraTable = masterTable.getSubTable(name);
        CameraServer.getVideo(httpCamera);

        cameraTable.getEntry("flashers").setBoolean(flash);

    }

    private String getIP(){
        final String teamNumString = Integer.toString(Config.TEAM_NUMBER);
        String teamNumIP = "68.94";
        if(teamNumString.length() == 4){
            teamNumIP = teamNumString.substring(0,2) + "." + teamNumString.substring(2,4);
        }
        final String camIP = "http://10." + teamNumIP + ".11:5801/";
        return camIP;
    }


    /**
     * @return The ID of the apriltag it can see
     */
    public double getTid() {
        return NetworkTableInstance.getDefault().getTable(fullname).getEntry("tid").getDouble(0);
    }

    public double getLastID() {
        return lastSeenApriltag;
    }

    /**
     * @return the distance from the center of the limelight view to the apriltag
     *         horizontally
     */
    public double getTx() {
        return NetworkTableInstance.getDefault().getTable(fullname).getEntry("tx").getDouble(0);
    }

    /**
     * @return the distance from the center of the limelight view to the apriltag
     *         vertically
     */
    public double getTy() {
        return NetworkTableInstance.getDefault().getTable(fullname).getEntry("ty").getDouble(0);
    }

    /**
     * 
     * @return the size of the apriltag seen as a square, which roughly translates
     *         to distance away from the apriltag
     */
    public double getTa() {
        return NetworkTableInstance.getDefault().getTable(fullname).getEntry("ta").getDouble(0);
    }

    /**
     * 
     * @param mode 1.0 for on, 0.0 for off
     */
    public void setFlasher(double mode) {
        NetworkTableInstance.getDefault().getTable(fullname).getEntry("ledMode").setDouble(mode);
    }

    /**
     * whether or not the limelight sees a apriltag
     * 
     * @return true if it sees an apriltag, false if it didnt detect a tag
     */
    public Boolean tagDetected() {
        if (NetworkTableInstance.getDefault().getTable(fullname).getEntry("tv").getDouble(0) == 1) {
            return true;
        }
        return false;
    }

    public void lockApriltag(){
        this.lockedApriltag = lastSeenApriltag;
    }

    /**
     * command for calculating limelight distance
     * 
     * @return horizontal floor distance from robot to apriltag
     */
    // public double getDistance() {

    //     double targetOffsetAngle_Vertical = getTy();
    //     double goalHeightInches = LimelightConstants.APRILTAG_HEIGHT;
    //     double angleToGoalRadians = (LimelightConstants.LIMELIGHT_ANGLE + targetOffsetAngle_Vertical) * (3.14159 / 180);

    //     if (getTid() == 4 || getTid() == 5) {
    //         goalHeightInches = LimelightConstants.APRILTAG_DOUBLE_SUBSTATION_HEIGHT;
    //     } // tid 4 and 5 are the double substations

    //     // calculate distance
    //     if (getTy() >= 0) {
    //         return (goalHeightInches - LimelightConstants.LIMELIGHT_HEIGHT) / Math.tan(angleToGoalRadians);
    //     } else {
    //         return (LimelightConstants.LIMELIGHT_HEIGHT) / Math.tan(angleToGoalRadians);
    //     }

    // }


    public void periodic() {
        // This method will be called once per scheduler run
        if(getTid() != -1){
            lastSeenApriltag = this.getTid();
        }
        

        cameraTable.getEntry("tx").setDouble(this.getTx());
        cameraTable.getEntry("ty").setDouble(this.getTy());
        cameraTable.getEntry("ta").setDouble(this.getTa());
        cameraTable.getEntry("tag detected").setBoolean(tagDetected());
        System.out.println(cameraTable.getEntry("flashers").getBoolean(false));

        SmartDashboard.putNumber("apriltag", getTid());
        SmartDashboard.putNumber("Locked apriltag", lockedApriltag);
        SmartDashboard.putNumber("last apriltag", lastSeenApriltag);


    }
}