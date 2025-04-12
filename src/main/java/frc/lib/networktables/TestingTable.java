package frc.lib.networktables;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * This is a static class for uploading testing data to networktables folder for testing purposes exclusively.
 */
public class TestingTable{
    
    private NetworkTableInstance networkTableInstance;
    private NetworkTable mochaTable;
    private NetworkTable dataTable;
    private NetworkTable inputTable;

    private NetworkTable subTable;

    TestingTable(String name){ 
        this.networkTableInstance = NetworkTableInstance.getDefault();
        this.mochaTable = networkTableInstance.getTable("Mochalib");

        this.subTable = mochaTable.getSubTable(name);

        this.dataTable = subTable.getSubTable("data");
        this.inputTable = subTable.getSubTable("input");
        
    }

    public void upload(String name, double value){
        dataTable.getEntry(name).setDouble(value);
    }

    public void upload(String name, boolean value){
        dataTable.getEntry(name).setBoolean(value);
    }
    
    public void upload(String name, int value){
        dataTable.getEntry(name).setInteger(value);
    }
    public void upload(String name, String value){
        dataTable.getEntry(name).setString(value);
    }

    public void upload(String name, float value){
        dataTable.getEntry(name).setFloat(value);
    }


}
