package uas.models;

public class Device {
    private String ownerName;
    private OperatingSystem os;

    public Device(String ownerName, OperatingSystem os) {
        this.ownerName = ownerName;
        this.os = os;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public OperatingSystem getOperatingSystem() {
        return this.os;
    }

    public String getDetails() {
        return this.ownerName + " booted: " + os.getBootInfo();
    }
}
