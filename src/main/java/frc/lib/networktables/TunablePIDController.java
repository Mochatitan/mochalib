package frc.lib.networktables;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class TunablePIDController{
    
    private PIDController pidController;

    private NetworkTableInstance networkTableInstance;
    private NetworkTable mochaTable;
    private NetworkTable tuningTable;
    private NetworkTable pidTable;
    private NetworkTable controllerTable;

    TunablePIDController(String name, double p, double i, double d){

        this.networkTableInstance = NetworkTableInstance.getDefault();
        this.mochaTable = networkTableInstance.getTable("Mochalib");
        this.tuningTable = mochaTable.getSubTable("tuning");
        this.pidTable = tuningTable.getSubTable("PID");
        this.controllerTable = pidTable.getSubTable(name);

        this.pidController = new PIDController(p, i, d);

        controllerTable.getEntry("P").setDouble(p);
        controllerTable.getEntry("I").setDouble(i);
        controllerTable.getEntry("D").setDouble(d);
    }

    private double getP(){
        return controllerTable.getEntry("P").getDouble(0);
    }
    private double getI(){
        return controllerTable.getEntry("I").getDouble(0);
    }
    private double getD(){
        return controllerTable.getEntry("D").getDouble(0);
    }

    public double calculate(double measurement, double setpoint){
        return pidController.calculate(measurement, setpoint);
    }

    public void updatePID(){
        pidController.setPID(getP(), getI(), getD());
    }

}
