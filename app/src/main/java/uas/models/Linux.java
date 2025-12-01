package uas.models;

public abstract class Linux extends OperatingSystem {
    private String desktopEnvironmentName;
    
    public Linux(String desktopEnvironmentName, String name, String version){
        super(name, version);
        this.desktopEnvironmentName = desktopEnvironmentName;
    }
    
    public String getDesktopEnvironmentName(){
        return this.desktopEnvironmentName;
    }

    @Override
    public String getBootInfo() {
        return "Booting " + super.getName() + " " + super.getVersion();
    }
    
}
