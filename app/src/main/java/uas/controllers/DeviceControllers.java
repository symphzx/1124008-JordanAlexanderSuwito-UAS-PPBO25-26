package uas.controllers;

import java.util.ArrayList;
import java.util.List;

import uas.models.Device;
import uas.models.IDeviceController;
import uas.models.OperatingSystem;

public class DeviceControllers implements IDeviceController {
    private List<Device> listDevice;

    public DeviceControllers(){
        this.listDevice = new ArrayList<>();
    }

    public void addDevice(String ownerName, OperatingSystem os){
        this.listDevice.add(new Device(ownerName, os));
    }

    public List<Device> getDeviceInfo(){
        return this.listDevice;
    }
}
