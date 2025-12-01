package uas.models;

public class Ubuntu extends Linux {
    
    public Ubuntu(String version) {
        super("Gnome", "Ubuntu", version);
    }

    public Ubuntu(String desktopEnvironmentName, String version) {
        super(desktopEnvironmentName, "Ubuntu", version);
    }

    @Override
    public String getBootInfo(){
        return "Booting " + super.getName() + " " + super.getVersion();
    }
    
}
