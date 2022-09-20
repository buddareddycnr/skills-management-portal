package co.uk.skills.constants;

public enum Gender {
    MALE("M"),FEMALE("F"),TRANSGENDER("T");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
