package uas.models;

public class Fedora extends Linux {

    public Fedora(String version) {
        super("KDE Plasma", "Fedora", version);
    }

    public Fedora(String desktopEnvironmentName, String version) {
        super(desktopEnvironmentName, "Fedora", version);
    }

    @Override
    public String getBootInfo(){
        return "Booting " + super.getName() + " " + super.getVersion();
    }
    
}
