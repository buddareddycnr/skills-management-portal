package co.uk.skills.constants;

public enum Titles {
    MR("Mr"),MRS("Mrs"),DR("Dr"),CAPTAIN("Captain");
    String title;

    Titles(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
