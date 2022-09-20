package co.uk.skills.constants;

public enum ProficiencyLevels {
    EXPERT("Expert"),PRACTITIONER("Practitioner"),WORKING("Working"),AWARENESS("Awareness");

    private String proficiencyLevel;
    ProficiencyLevels(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public String toString() {
        return proficiencyLevel;
    }
}
