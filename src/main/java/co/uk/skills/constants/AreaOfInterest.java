package co.uk.skills.constants;

public enum AreaOfInterest {
    PROGRAMING("Programming"),DEVELOPMENT("Development"),SCRIPTING("Scripting"),
    Testing("Testing"),DEVOPS("Devops"),OTHER("Other");
    private String areaOfInterest;
    AreaOfInterest(String areaOfInterest){
        this.areaOfInterest = areaOfInterest;
    }

    @Override
    public String toString() {
        return areaOfInterest;
    }
}
