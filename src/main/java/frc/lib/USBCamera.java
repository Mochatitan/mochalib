package frc.lib;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

public class USBCamera {
    private UsbCamera usbCam;

    USBCamera(String name){
        usbCam = CameraServer.startAutomaticCapture(name, 0);
    }

    public UsbCamera getCamera(){
        return usbCam;
    }

}
