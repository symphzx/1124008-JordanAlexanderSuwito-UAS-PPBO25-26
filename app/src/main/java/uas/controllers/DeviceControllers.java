package uas.controllers;

import java.util.ArrayList;
import java.util.List;

import uas.models.Device;
import uas.models.Fedora;
import uas.models.IDeviceController;
import uas.models.OperatingSystem;
import uas.models.Ubuntu;
import uas.models.Windows;

public class DeviceControllers implements IDeviceController {
    private List<Device> listDevice;

    public DeviceControllers(){
        this.listDevice = new ArrayList<>();
    }

    // public void addDevice(String ownerName, String version, String os){
    //     if (os.equalsIgnoreCase("Windows")) {
    //         OperatingSystem operatingSystem = new Windows(version);
    //         Device device = new Device(ownerName, operatingSystem);
    //         this.listDevice.add(device);
    //     }else if(os.equalsIgnoreCase("Ubuntu")){
    //         OperatingSystem operatingSystem = new Ubuntu(version);
    //         Device device = new Device(ownerName, operatingSystem);
    //         this.listDevice.add(device);
    //     }else{
    //         OperatingSystem operatingSystem = new Fedora(version);
    //         Device device = new Device(ownerName, operatingSystem);
    //         this.listDevice.add(device);
    //     }
    // }

    public void addDevice(String ownerName, OperatingSystem os){
        this.listDevice.add(new Device(ownerName, os));
    }

    // public void addDevice(String ownerName, String version, String desktopEnvironmentName){
    //     // OperatingSystem operatingSystem = new Ubuntu(version,desktopEnvironmentName);
    //     // OperatingSystem operatingSystem = new Fedora(version,desktopEnvironmentName);
    // }

    public List<Device> getDeviceInfo(){
        return this.listDevice;
    }
}
